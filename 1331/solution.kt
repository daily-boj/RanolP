import kotlin.math.abs

val A = 'A'.toInt()
val ZERO = '0'.toInt()

typealias Pos = Pair<Int, Int>

fun Pos.knight(other: Pos): Boolean =
    when(Pair(abs(this.first - other.first), abs(this.second - other.second))) {
        Pair(1, 2), Pair(2, 1) -> true
        else -> false
    }

fun main(args: Array<out String>) {
    var first: Pos? = null
    var last: Pos? = null
    var before: Pos? = null
    val visited = mutableSetOf<Pos>()
    repeat(36) {
        val current = readLine()!!.let { Pair(it[0].toInt() - A, it[1].toInt() - ZERO) }
        if (current in visited) {
            println("Invalid")
            return
        }
        visited += current
        last = current
        if (before == null) {
            first = current
            before = current
            return@repeat
        }
        if (!current.knight(before!!)) {
            println("Invalid")
            return
        }
        before = current
    }
    if (last!!.knight(first!!)) {
        println("Valid")
    } else {
        println("Invalid")
    }
}