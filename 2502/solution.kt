fun main() {
    System.setOut(java.io.PrintStream(System.`out`, false, "UTF-8"))

    val (d, k) = readLine()!!.split(" ").map { it.toInt() }

    val fiboPrecomputed = listOf(
        0, 0, 1, 1, 2, 3, 5, 8, 13, 21,
        34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584,
        4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811
    )

    for (a in 0..50000) {
        val b = k - a * fiboPrecomputed[d - 1]
        if (b % fiboPrecomputed[d] == 0) {
            println(a)
            println(b / fiboPrecomputed[d])
            return
        }
    }
}
