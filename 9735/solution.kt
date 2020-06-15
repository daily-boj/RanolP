import kotlin.math.*

data class QuadraticEquation(val a: Long, val b: Long, val c: Long) {
    fun solve(): Set<Double> {
        val discriminant = b.toDouble() * b.toDouble() - 4.0 * a.toDouble() * c.toDouble()
        if (discriminant < 0) {
            return emptySet()
        }
        val sqrtedDiscriminant = sqrt(discriminant)
        return setOf((-b + sqrtedDiscriminant) / 2 / a, (-b - sqrtedDiscriminant) / 2 / a)
    }
}

fun syntheticDivision(a: Long, b: Long, c: Long, d: Long): Set<Double> {
    if (d == 0L) {
        return setOf(0.0) + QuadraticEquation(a, b, c).solve()
    }
    for (i in 1..sqrt(abs(d.toDouble())).toLong()) {
        if (d % i != 0L) {
            continue
        }
        for (e in listOf(i, -i, d / i, -d / i)) {
            val newA = a
            val newB = e * newA + b
            val newC = e * newB + c
            val newD = e * newC + d
            if (newD == 0L) {
                return setOf(e.toDouble()) + QuadraticEquation(newA, newB, newC).solve()
            }
        }
    }
    return emptySet()
}

fun gcd(a: Long, b: Long): Long =
    if (b == 0L) a
    else gcd(b, a % b)

fun main(args: Array<out String>) {
    (0 until readLine()!!.toLong()).joinToString("\n") {
        val (a, b, c, d) = readLine()!!.split(" ").map { it.toLong() }
        syntheticDivision(a, b, c, d).toList().sorted().joinToString(" ") { String.format("%f", it) }
    }.let(::println)
}