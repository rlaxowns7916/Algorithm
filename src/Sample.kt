class Sample{
    fun main(){
        val N = 5
        val M = 5
        val K = 2

        val requests = listOf(
            300 to 200,
            100 to 400,
            500 to 0,
            130 to 370,
            400 to 100
        )

        val samples = listOf(
            20 to 30,
            5 to 45,
            50 to 0,
            39 to 11,
            37 to 13
        )

        val result = simulateCircuitBreaker(N, M, K, requests, samples)
        println("\n최종 답: $result")
    }

    val CLOSED_TO_OPEN_THRESHOLD = 0.5   // 50%
    val HALF_OPEN_THRESHOLD = 0.3        // 30%
    val OPEN_DURATION = 2                // 2초

    fun simulateCircuitBreaker(
        N: Int,
        M: Int,
        K: Int,
        requests: List<Pair<Int, Int>>,
        samples: List<Pair<Int, Int>>
    ): Int {
        // 초기 상태
        var state = CircuitState.CLOSED
        var openStartTime = -1
        var halfOpenStartTime = -1
        var preventedFailures = 0

        // Sliding Window 저장소: Triple(time, success, failure)
        val slidingWindow = mutableListOf<Triple<Int, Int, Int>>()
        val halfOpenWindow = mutableListOf<Triple<Int, Int, Int>>()

        fun failureRate(success: Int, failure: Int): Double {
            val total = success + failure
            return if (total > 0) failure.toDouble() / total else 0.0
        }

        fun getWindowStats(
            window: List<Triple<Int, Int, Int>>,
            currentTime: Int,
            windowSize: Int
        ): Triple<Int, Int, Int> {
            val startTime = maxOf(0, currentTime - windowSize + 1)
            var sSum = 0
            var fSum = 0
            for ((t, s, f) in window) {
                if (t in startTime..currentTime) {
                    sSum += s
                    fSum += f
                }
            }
            return Triple(sSum, fSum, sSum + fSum)
        }

        println("Circuit Breaker 시뮬레이션 시작")
        println("설정: M=$M, K=$K, CLOSED→OPEN=50%, HALF_OPEN 임계값=30%, OPEN 지속시간=2초")
        println("=".repeat(80))

        for (currentTime in 0 until N) {
            val (currentSuccess, currentFailure) = requests[currentTime]
            val currentTotal = currentSuccess + currentFailure
            val (sampleSuccess, sampleFailure) = samples[currentTime]
            val sampleTotal = sampleSuccess + sampleFailure

            println("\n시간 ${currentTime}초:")
            println("  전체 요청: 성공=$currentSuccess, 실패=$currentFailure, 총=$currentTotal")
            println("  샘플 요청: 성공=$sampleSuccess, 실패=$sampleFailure, 총=$sampleTotal")
            println("  현재 상태: $state")

            var preventedThisSecond = 0

            when (state) {
                CircuitState.CLOSED -> {
                    // CLOSED 상태: 모든 요청이 A사로 전달
                    slidingWindow += Triple(currentTime, currentSuccess, currentFailure)

                    val (wS, wF, wT) = getWindowStats(slidingWindow, currentTime, K)
                    if (wT >= M) {
                        val rate = failureRate(wS, wF)
                        println("  Sliding Window 평가: 총=$wT, 실패율=${"%.2f".format(rate * 100)}%")
                        if (rate > CLOSED_TO_OPEN_THRESHOLD) {
                            state = CircuitState.OPEN
                            openStartTime = currentTime
                            println("  → OPEN 상태로 전환!")
                        }
                    }
                }

                CircuitState.OPEN -> {
                    // OPEN 상태: 모든 요청 B사로 전송
                    preventedThisSecond = currentFailure
                    preventedFailures += preventedThisSecond
                    println("  B사로 전달 → $preventedThisSecond 개 실패 방지")
                    // 2초 경과 시 HALF_OPEN
                    if (currentTime - openStartTime >= OPEN_DURATION) {
                        state = CircuitState.HALF_OPEN
                        halfOpenStartTime = currentTime
                        halfOpenWindow.clear()
                        println("  → HALF_OPEN 상태로 전환!")
                    }
                }

                CircuitState.HALF_OPEN -> {
                    // HALF_OPEN 상태: 샘플만 A사로, 나머지는 B사로
                    halfOpenWindow += Triple(currentTime, sampleSuccess, sampleFailure)
                    val nonSampled = currentTotal - sampleTotal
                    if (currentTotal > 0) {
                        val actualRate = failureRate(currentSuccess, currentFailure)
                        preventedThisSecond = (nonSampled * actualRate).toInt()
                        preventedFailures += preventedThisSecond
                        println("  샘플링되지 않은 요청: $nonSampled 개")
                        println("  A사 실패율: ${"%.2f".format(actualRate * 100)}%")
                        println("  B사로 전달된 요청 중 방지된 실패: $preventedThisSecond 개")
                    }

                    val halfOpenWindowSize = currentTime - halfOpenStartTime + 1
                    val (hS, hF, hT) = getWindowStats(halfOpenWindow, currentTime, halfOpenWindowSize)
                    if (hT >= M) {
                        val sampleRate = failureRate(hS, hF)
                        println("  HALF_OPEN 샘플 평가: 총=$hT, 실패율=${"%.2f".format(sampleRate * 100)}%")
                        if (sampleRate > HALF_OPEN_THRESHOLD) {
                            state = CircuitState.OPEN
                            openStartTime = currentTime
                            println("  → OPEN 상태로 전환!")
                        } else {
                            state = CircuitState.CLOSED
                            slidingWindow.clear()
                            println("  → CLOSED 상태로 전환! (Sliding Window 초기화)")
                        }
                    }
                }
            }

            println("  이번 초에 방지된 실패: $preventedThisSecond 개")
            println("  누적 방지된 실패: $preventedFailures 개")
        }

        println("\n" + "=".repeat(80))
        println("최종 결과: 총 $preventedFailures 개의 실패를 방지했습니다.")
        return preventedFailures
    }

    enum class CircuitState {
        CLOSED, OPEN, HALF_OPEN

    }
}