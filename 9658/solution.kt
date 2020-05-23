fun main(args: Array<out String>) {
    val n = readLine()!!.toInt()
    val dp = mutableListOf<Boolean>(false, false, true, false, true, true)
    for (i in 6..n) {
        dp.add(!dp[i - 1] || !dp[i - 3] || !dp[i - 4])
    }
    if (dp[n]) {
        println("SK")
    } else {
        println("CY")
    }
}