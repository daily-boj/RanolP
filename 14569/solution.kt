fun main() {
    System.setOut(java.io.PrintStream(System.`out`, false, "UTF-8"))

    val lectures = List(readLine()!!.toInt()) {
        val list = readLine()!!.split(" ").map { it.toInt() }.drop(1)

        var bitset = 0L
        for (i in list) {
            bitset = bitset or (1L shl i)
        }

        bitset
    }

    List(readLine()!!.toInt()) {
        val list = readLine()!!.split(" ").map { it.toInt() }.drop(1)
        var bitset = 0L
        for (i in list) {
            bitset = bitset or (1L shl i)
        }

        lectures.count { (bitset and it) == it }
    }.joinToString("\n").let(::println)
}
