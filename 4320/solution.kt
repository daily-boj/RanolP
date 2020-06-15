import java.io.*

val eratostenes = ArrayList<Long>().also { primes ->
    for (i in 2L..65536L) { // from 2 to sqrt(2^32)
        if (primes.all { i % it != 0L }) {
            primes.add(i)
        }
    }
}

fun factor(n: Long): HashMap<Long, Long> {
    var nmut = n
    val result = HashMap<Long, Long>()
    for (prime in eratostenes) {
        if (nmut < prime) {
            break
        }
        while (nmut % prime == 0L) {
            result[prime] = 1L + (result[prime] ?: 0L)
            nmut = nmut / prime
        }
    }
    return result
}

fun gcd(a: Long, b: Long): Long =
    if (b == 0L) a
    else gcd(b, a % b)

fun main(args: Array<out String>) {
    BufferedReader(InputStreamReader(System.`in`))
        .lineSequence()
        .takeWhile { it != "0" }
        .joinToString("\n") {
            val x = it.toLong()
            val isMinus = x < 0L
            val factored = factor(kotlin.math.abs(x))

            var max =
                factored.values
                    .asSequence()
                    .ifEmpty { sequenceOf(1L) }
                    .reduce { a, b -> gcd(a, b) }

            if (isMinus) {
                while (max % 2L == 0L) {
                    max /= 2L
                }
            }
            max.toString()
        }.let(::println)
}