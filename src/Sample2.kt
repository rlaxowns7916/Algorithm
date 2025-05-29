import java.util.Deque

class Sample2 {
    val halfOpenThreshold = 3
    val openDurationSeconds = 2
    val failureRateThreshold = 0.4

    fun main(){
        val N = 5
        val K = 2

        val requests = arrayOf(
            arrayOf(300, 200),
            arrayOf(100, 400),
            arrayOf(500, 0),
            arrayOf(130, 370),
            arrayOf(400, 100)
        )

        val samples = arrayOf(
            arrayOf(20, 30),
            arrayOf(5, 45),
            arrayOf(50, 0),
            arrayOf(39, 11),
            arrayOf(37, 13)
        )

        val result = simulateCircuitBreaker(N, K, requests, samples)
        println("\n최종 답: $result")
    }

    fun simulateCircuitBreaker(N: Int, K: Int, requests: Array<Array<Int>>, samples: Array<Array<Int>>): Int {
        var lp=0
        var rp = 0
        var preventFailures = 0
        var state = CircuitState.CLOSED
        val slidingWindow = SlidingWindow()

        var openStartedAt = 0

        while(rp < N) {
            if(rp - lp >= K){
                slidingWindow.pop()
                lp++
            }

            when(state){
                CircuitState.OPEN -> slidingWindow.push(0,0)
                CircuitState.HALF_OPEN -> slidingWindow.push(samples[rp][0], samples[rp][1])
                CircuitState.CLOSED -> slidingWindow.push(requests[rp][0], requests[rp][1])
            }


            when (state) {
                CircuitState.CLOSED -> {
                     val failureRate = slidingWindow.failureRate()
                     if(failureRate > failureRateThreshold) {
                        openStartedAt = rp
                        state = CircuitState.OPEN
                    }
                }
                CircuitState.OPEN -> {
                    if (rp - openStartedAt >= openDurationSeconds) {
                        state = CircuitState.HALF_OPEN
                    }

                    preventFailures += requests[rp][1]
                }
                CircuitState.HALF_OPEN -> {
                    preventFailures += (requests[rp][1] - samples[rp][1])
                    state = if(samples[rp][1] > halfOpenThreshold){
                        CircuitState.OPEN
                    }else{
                        slidingWindow.clear()
                        CircuitState.CLOSED
                    }
                }
            }
            rp++
        }
        return preventFailures
    }

    class SlidingWindow{
        private val successWindows = ArrayDeque<Int>()
        private val failureWindows = ArrayDeque<Int>()

        fun pop() {
            successWindows.removeFirst()
            failureWindows.removeFirst()
        }

        fun push(success: Int, failure: Int) {
            successWindows.addLast(success)
            failureWindows.addLast(failure)
        }

        fun size(): Int{
            return successWindows.size
        }

        fun failureRate(): Double{
            val successCount = successWindows.sum()
            val failureCount = failureWindows.sum()
            val total = successCount + failureCount
            return if (total > 0) {
                successCount.toDouble() / total
            } else {
                0.0
            }
        }

        fun clear(){
            successWindows.clear()
            failureWindows.clear()
        }
    }
    enum class CircuitState {
        CLOSED,
        OPEN,
        HALF_OPEN
    }
}