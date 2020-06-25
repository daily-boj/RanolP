fun main(args: Array<out String>) {
    val count = readLine()!!.toInt()
    val numbers = readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }.sorted()

    var answer = 0
    for (i in 0 until count) {
        loop@for (j in 0 until count) {
            if (j == i) {
                continue
            }

            val toFind = numbers[i] - numbers[j]

            var low = 0
            var high = count
            while (low < high) {
                val mid = (low + high) / 2
                if (toFind >= numbers[mid]) {
                    low = mid + 1
                } else {
                    high = mid
                }
            }

            var currentIndex = low - 1
            while (currentIndex > 0 && numbers[currentIndex] == toFind) {
                if (currentIndex != i && currentIndex != j) {
                    answer += 1
                    break@loop
                }
                currentIndex -= 1
            }
        }
    }

    println(answer)
}
