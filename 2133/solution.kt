val dpE = mutableMapOf<Int, Int>(1 to 1)
val dpL = mutableMapOf<Int, Int>(1 to 1)

fun solve(n: Int, isLShaped: Boolean): Int {
    if (n <= 0) {
        return 1
    }
    if(isLShaped) {
        if (n !in dpL) {
            dpL[n] = solve(n - 1, false) + solve(n - 2, true)
        }
        return dpL[n]!!
    } else {
        if (n !in dpE) {
            dpE[n] = solve(n - 2, false) + solve(n - 1, true) * 2
        }
        return dpE[n]!!
    }
}


fun main(args: Array<out String>) {
    val n = readLine()!!.toInt()
    if (n % 2 == 0) {
        println(solve(n, false))
    } else {
        println(0)
    }
}