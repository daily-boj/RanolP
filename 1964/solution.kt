fun main(args: Array<out String>) {
    val x = readLine()!!.toLong() % 45678L
    println((1 + 3 * (x * (x + 1) / 2) + x) % 45678L)
}