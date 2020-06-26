import kotlin.math.*

fun main(args: Array<out String>) {
    val n = readLine()!!.toInt()

    val min = (1..Math.ceil(sqrt(n.toDouble())).toInt()).map {
        2 * it + 2 * Math.ceil(n / it.toDouble()).toInt() - 4
    }.min()!!

    if (min < 4) {
        println(4)
    } else {
        println(min)
    }
}
