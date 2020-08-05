fun main() {
    System.setOut(java.io.PrintStream(System.`out`, false, "UTF-8"))

    readLine()
    val cards = readLine()!!.split(" ").map { it.toInt() }.sorted()
    val max = cards.last()

    println(max * (cards.size - 1) + cards.dropLast(1).sum())
}