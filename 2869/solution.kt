import kotlin.math.ceil

fun main(args: Array<out String>) {
    val (a, b, v) = readLine()!!.split(" ").map { it.toDouble() }
    println(ceil((v - b) / (a - b)).toInt())
}
