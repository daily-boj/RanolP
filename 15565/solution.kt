fun main(args: Array<out String>) {
    System.setOut(java.io.PrintStream(System.`out`, false, "UTF-8"))
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val dolls = readLine()!!.split(" ").withIndex().mapNotNull { (i, v) -> if (v == "1") i else null }
    val min = (0 until dolls.size - k + 1).map { dolls[it + k - 1] - dolls[it] + 1 }.min() ?: -1
    println(min)
}
