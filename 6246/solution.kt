data class Query(val begin: Int, val step: Int) {
    fun hasBalloon(n: Int): Boolean =
        n >= begin && (n - begin) % step == 0
}

fun main(args: Array<out String>) {
    val (n, q) = readLine()!!.split(" ").map { it.toInt() }
    val queries = List(q) {
        val (begin, step) = readLine()!!.split(" ").map { it.toInt() }
        Query(begin, step)
    }
    var answer = 0
    for (i in 1..n) {
        if (queries.all { !it.hasBalloon(i) }) {
            answer += 1
        }
    }
    println(answer)
}