fun main() {
    System.setOut(java.io.PrintStream(System.`out`, false, "UTF-8"))

    val lines = System.`in`.bufferedReader().lines().iterator()

    while (lines.hasNext()) {
        val (n, m) = lines.next().split(" ").map { it.toInt() }
        if (n == 0 && m == 0) {
            break
        }
        val calls = List(n) {
            val (src, dest, start, dur) = lines.next().split(" ").map { it.toLong() }
            Pair(start, start + dur)
        }
        List(m) {
            val (start, dur) = lines.next().split(" ").map { it.toLong() }
            val end = start + dur
            calls.asSequence().count { (cStart, cEnd) -> minOf(end, cEnd) - maxOf(cStart, start) >= 1 }
        }.joinToString("\n").let(::println)
    }
}
