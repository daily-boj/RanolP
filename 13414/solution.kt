fun main(args: Array<out String>) {
    val map = mutableMapOf<String, Int>()
    val (k, l) = readLine()!!.split(" ").map { it.toInt() }
    repeat(l) {
        map[readLine()!!] = it
    }
    map.entries.asSequence().sortedBy { it.value }.take(k).joinToString("\n") { it.key }.let(::println)
}