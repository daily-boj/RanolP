data class Node(val distance: Int, val id: Int)

fun main(args: Array<out String>) {
    val n = readLine()!!.toInt()
    val edges = MutableList(n) { mutableListOf<Pair<Int, Long>>() }
    repeat(readLine()!!.toInt()) {
        val (start, end, price) = readLine()!!.split(" ").map { it.toInt() }
        edges[start - 1].add(Pair(end - 1, price.toLong()))
    }
    val (start, end) = readLine()!!.split(" ").map { it.toInt() }

    val shortest = MutableList(n) { 1000_000_000L }
    shortest[start - 1] = 0
    val toVisit = edges.indices.toMutableSet()
    var current: Int? = start - 1
    while (current != null) {
        for ((id, distance) in edges[current]) {
            shortest[id] = minOf(shortest[current] + distance, shortest[id])
        }
        toVisit.remove(current)
        current = toVisit.minBy { shortest[it] }
    }

    println(shortest[end - 1])
}