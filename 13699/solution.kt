import java.math.BigInteger

fun main() {
    System.setOut(java.io.PrintStream(System.`out`, false, "UTF-8"))

    val n = readLine()!!.toInt()

    val dp = mutableListOf(BigInteger.ONE)

    for (i in 1..n) {
        dp.add((1..i).map { dp[it - 1] * dp[i - it] }.reduce { acc, curr -> acc + curr })
    }

    println(dp[n])
}
