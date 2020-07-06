fun main(args: Array<out String>) {
    System.setOut(java.io.PrintStream(System.`out`, false, "UTF-8"))

    data class Row(val left: Int, val right: Int)

    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val table = List(n) {
        val (left, right) = readLine()!!.split(" ").map { it.toInt() }
        Row(left, right)
    }

    val dp = mutableMapOf<Int, Int>()
    fun solve(closes: Int, y: Int, acc: Int, isLeftBlocked: Boolean?): Int {
        if (y == n) {
            return if (closes == k) {
                 acc
            } else {
                -1
            }
        }
        val (left, right) = table[y]

        val dpKey = closes * 10000 + y * 10 + when (isLeftBlocked) {
            null -> 0
            false -> 1
            true -> 2
        }
        if (dpKey !in dp) {
            dp[dpKey] = listOfNotNull(
                solve(closes, y + 1, left + right, null),
                if (isLeftBlocked != false) solve(closes + 1, y + 1, left, true)
                else null,
                if (isLeftBlocked != true) solve(closes + 1, y + 1, right, false)
                else null
            ).max()!!
        }
        val value = dp[dpKey]!!
        return if (value != -1) {
            value + acc
        } else {
            -1
        }
    }

    println(solve(0, 0, 0, null))
}
