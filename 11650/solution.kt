data class Pos(val x: Int, val y: Int) : Comparable<Pos> {
    override operator fun compareTo(other: Pos): Int {
        val xDiff = this.x.compareTo(other.x)
        return if (xDiff != 0) {
            xDiff
        } else {
            this.y.compareTo(other.y)
        }
    }
}

fun main(args: Array<out String>) {
    List(readLine()!!.toInt()) {
        val (x, y) = readLine()!!.split(" ").map { it.toInt() }
        Pos(x, y)
    }
    .sorted()
    .joinToString("\n") { "${it.x} ${it.y}" }
    .let(::println)
}