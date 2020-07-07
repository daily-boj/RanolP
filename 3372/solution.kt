import java.math.BigInteger

fun main(args: Array<out String>) {
    System.setOut(java.io.PrintStream(System.`out`, false, "UTF-8"))

    val size = readLine()!!.toInt()
    val board = List(size) {
        readLine()!!.split(" ").map { it.toInt() }
    }

    val dp = List(size) {
        MutableList(size) {
            BigInteger.ZERO
         }
    }

    dp[size - 1][size - 1] = BigInteger.ONE

    val NO_WAY = -BigInteger.ONE

    for (x in (0 until size).reversed()) {
        for (y in (0 until size).reversed()) {
            if (x == size - 1 && y == size - 1) {
                continue
            }
            val v = board[x][y]
            if (v == 0) {
                dp[x][y] = NO_WAY
                continue
            }
            val way = listOf(
                if (x + v < size) {
                    dp[x + v][y]
                } else {
                    NO_WAY
                },
                if (y + v < size) {
                    dp[x][y + v]
                } else {
                    NO_WAY
                }
            ).filter { it != NO_WAY }
            dp[x][y] = if (way.isEmpty()) {
                NO_WAY
            } else {
                way.reduce { l, r -> l + r }
            }
        }
    }

    println(maxOf(BigInteger.ZERO, dp[0][0]))
}
