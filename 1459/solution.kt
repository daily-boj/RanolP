fun main(args: Array<out String>) {
    val (x, y, w, s) = readLine()!!.split(" ").map { it.toLong() }
    if (2 * w <= s) {
        println(x * w + y * w)
    } else {
        val (sMoves, allMoves) = listOf(x, y).sorted()
        val wMoves = allMoves - sMoves
        if (2 * w <= 2 * s) {
            println(s * sMoves + w * wMoves)
        } else {
            println(s * sMoves + s * (wMoves - (wMoves % 2)) + w * (wMoves % 2))
        }
    }
}
