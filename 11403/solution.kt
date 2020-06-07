import java.util.*

fun main(args: Array<out String>) {
    val n = readLine()!!.toInt()
    val adjacencyMatrix = MutableList(n) {
        readLine()!!.split(" ").map { it == "1" }.toMutableList()
    }

    for (i in 0 until n) {
        val visited = HashSet<Int>()
        val toVisit = ArrayDeque<Int>()
        toVisit.addFirst(i)
        while (toVisit.isNotEmpty()) {
            val curr = toVisit.removeFirst()
            for (next in 0 until n) {
                if (next in visited) {
                    continue
                }
                if (!adjacencyMatrix[curr][next]) {
                    continue
                }
                toVisit.addFirst(next)
                adjacencyMatrix[i][next] = true
                visited.add(next)
            }
        }
    }

    adjacencyMatrix.joinToString("\n") {
        it.joinToString(" ") { if (it) "1" else "0" }
    }.let(::println)
}
