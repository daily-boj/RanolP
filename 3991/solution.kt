fun main() {
    System.setOut(java.io.PrintStream(System.`out`, false, "UTF-8"))

    val (h, w, c) = readLine()!!.split(" ").map { it.toInt() }
    val beads = readLine()!!.split(" ").map { it.toInt() }

    val board = beads.withIndex().flatMap { (index, count) -> List(count) { index + 1 } }.chunked(w)

    board.withIndex().forEach { (index, row) ->
        println(row.joinToString("").let {
            if (index % 2 == 0) {
                it.reversed()
            } else {
                it
            }
        })
    }
}
