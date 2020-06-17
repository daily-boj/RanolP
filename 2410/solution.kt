val DIVISOR = 1_000_000_000

fun main(args: Array<out String>) {
    println(solve(readLine()!!.toInt()))
}

val dp = mutableMapOf<Int, Int>(0 to 0, 1 to 1, 2 to 2)

fun solve(n: Int): Int {
    if (n !in dp) {
        dp[n] = if (n % 2 != 0) {
             solve(n - n % 2)
        } else {
            ((solve(n - 2) % DIVISOR) + (solve(n / 2) % DIVISOR)) % DIVISOR
        }
    }
    return dp[n]!!
}
