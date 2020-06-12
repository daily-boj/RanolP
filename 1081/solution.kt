fun main(args: Array<out String>) {
    val (begin, end) = readLine()!!.split(" ").map { it.toLong() }
    println(solve(end) - solve(begin - 1))
}

fun solve(n: Long): Long {
    if (n < 10L) {
        return n * (n + 1L) / 2L
    }

    var k = 0L
    var t = 1L
    while (t * 10L <= n) {
        t *= 10L
        k += 1L
    }
    val i = n / t
    return i * (45L * k * t / 10L + 1L + n % t + (i - 1) * t / 2) + solve(n % t)
}