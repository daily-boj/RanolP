fun main() {
    System.setOut(java.io.PrintStream(System.`out`, false, "UTF-8"))
    repeat(readLine()!!.toInt()) {
        val (a, b, s) = readLine()!!.split(" ").map { it.toInt() }
        val min = minOf(a, b)
        val max = maxOf(a, b)
        val requireReverse = a > b

        for (maxCount in (0..(s / max + 1)).reversed()) {
            val minMultMinCount = s - max * maxCount
            if (minMultMinCount >= 0 && minMultMinCount % min == 0) {
                if (requireReverse) {
                    println("$maxCount ${(minMultMinCount / min)}")
                } else {
                    println("${(minMultMinCount / min)} $maxCount")
                }
                return@repeat
            }
        }

        println("Impossible")
    }
}
