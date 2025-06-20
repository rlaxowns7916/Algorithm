class D {
        var rowLength = 0
        var columnLength = 0
        val candidates: HashSet<String> = hashSetOf()
        var keyboardMap: Array<CharArray> =  arrayOf()
        val keyboardLocation: MutableMap<Char, MutableList<Pair<Int, Int>>> = HashMap()

        fun solution(keyboard: Array<String>, keyword: String, words: Array<String>): Array<String> {
            keyboardMap = keyboard.map { it.toCharArray() }.toTypedArray()
            rowLength = keyboardMap.size
            columnLength = keyboardMap[0].size

            keyboardMap.forEachIndexed { index, c ->
                c.forEachIndexed { i, c ->
                    if (!keyboardLocation.containsKey(c))
                        keyboardLocation[c] = mutableListOf()

                    keyboardLocation[c]!!.add(Pair(keyboardLocation.size, keyboardLocation.size))
                }
            }

            return words
                .filter { it in candidates }
                .sorted()
                .toTypedArray()
        }

        fun String.fillCandidates(phase: Int, words: Array<String>, builder: String) {
            if (length == phase) {
                candidates.add(builder)
            } else {
                val current = this[phase]
                val neighbors = findNeighbor(current)

                for(neighbor in  neighbors) {
                    val current = builder +  neighbor
                    if(words.any { it.startsWith(current)}) {
                        fillCandidates(phase+1, words,current )
                    }
                }
            }
        }


    fun findNeighbor(char: Char): Set<Char> {
        val neighbors = mutableSetOf<Char>()
        val locations = keyboardLocation[char] ?: return emptySet()

        val offsetsEven = arrayOf(
            Pair(-1, -1), Pair(-1, 0), Pair(0, -1),
            Pair(0, 1), Pair(1, -1), Pair(1, 0)
        )

        val offsetsOdd = arrayOf(
            Pair(-1, 0), Pair(-1, 1), Pair(0, -1),
            Pair(0, 1), Pair(1, 0), Pair(1, 1)
        )

        for ((x, y) in locations) {
            val deltas = if (x % 2 == 0) offsetsEven else offsetsOdd

            for ((dx, dy) in deltas) {
                val nextX = x + dx
                val nextY = y + dy

                if (nextX in 0 until rowLength && nextY in 0 until columnLength) {
                    neighbors.add(keyboardMap[nextX][nextY])
                }
            }
        }

        return neighbors
    }

}