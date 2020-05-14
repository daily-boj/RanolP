val dpE = mutableMapOf<Int, Int>(0 to 1, 1 to 1)
val dpP = mutableMapOf<Int, Int>(0 to 0, 1 to 1)
val dpC = mutableMapOf<Int, Int>(0 to 0, 1 to 1)

var depth = 0

fun E(n: Int): Int {
    if (n !in dpE) {
        dpE[n] = E(n - 1) + E(n - 2) + 2 * P(n - 1) + C(n - 1)
    }
    return dpE[n]!!
}

fun P(n: Int): Int {
    if (n !in dpP) {
        dpP[n] = E(n - 1) + P(n - 1)
    }
    return dpP[n]!!
}

fun C(n: Int): Int {
    if (n !in dpC) {
        dpC[n] = E(n - 1) + C(n - 2)
    }
    return dpC[n]!!
}

fun main(args: Array<out String>) {
    List(readLine()!!.toInt()) {
        E(readLine()!!.toInt())
    }
        .joinToString("\n")
        .let(::println)
}