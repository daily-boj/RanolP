fun main(args: Array<out String>) {
    val n = readLine()!!.toInt()

    val MOD = 1_000_000_000
    val FULL = (1 shl 10) - 1
    val dp = Array(100 + 1) { Array(10) { Array(FULL + 1) { 0 } } }

    for (j in 1..9) {
        dp[1][j][1 shl j] = 1
    }

    for (i in 2..n) {
        for (j in 0..9) {
            for (k in 0..FULL) {
                val next = listOfNotNull(
                    if (j > 0) j - 1
                    else null,
                    if (j < 9) j + 1
                    else null
                )
                val key = k or (1 shl j)
                dp[i][j][key] = (dp[i][j][key] + next.fold(0) { acc, curr -> (acc + dp[i - 1][curr][k]) % MOD }) % MOD
            }
        }
    }

    var result = 0
    for (j in 0..9) {
        result = (result + dp[n][j][FULL]) % MOD
    }

    println(result)
}
