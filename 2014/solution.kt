import java.util.*

fun main() {
    System.setOut(java.io.PrintStream(System.`out`, false, "UTF-8"))

    val (k, n) = readLine()!!.split(" ").map { it.toInt() }
    val primes = readLine()!!.split(" ").map { it.toLong() }
    val q = PriorityQueue<Long>(100_000)
    val s = HashSet<Long>(100_000)
    q.addAll(primes)
    s.addAll(primes)

    var answer = -1L

    for (i in 0 until n) {
        answer = q.poll()
        for (number in primes) {
            val v = answer * number
            if (v !in s) {
                q.add(v)
                s.add(v)
            }
            if (answer % number == 0L) {
                break
            }
        }
    }

    println(answer)
}
