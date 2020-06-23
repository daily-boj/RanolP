fun main(args: Array<out String>) {
    fun makeWParam(a: Int, b: Int, c: Int): Int = (a * 100 + b) * 100 + c
    val dp = mutableMapOf<Int, Int>()

    fun w(a: Int, b: Int, c: Int): Int {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1
        }
        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20)
        }
        val key = makeWParam(a, b, c)
        if (key !in dp) {
            dp[key] = if (a < b && b < c) {
                w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c)
            } else {
                w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1)
            }
        }
        return dp[key]!!
    }

    System.`in`
        .bufferedReader()
        .lineSequence()
        .takeWhile { it != "-1 -1 -1" }
        .joinToString("\n") {
            val (a, b, c) = it.split(" ").map { it.toInt() }
            "w($a, $b, $c) = ${w(a, b, c)}"
        }.let(::println)
}
