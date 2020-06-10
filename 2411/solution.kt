val EMPTY = null
val BLOCKED = false
val ITEM = true

fun main(args: Array<out String>) {
    val (n, m, a, b) = readLine()!!.split(" ").map { it.toInt() }
    val map = MutableList(n) { MutableList<Boolean?>(m) { EMPTY } }
    repeat(a) {
        val (x, y) = readLine()!!.split(" ").map { it.toInt() }
        map[x - 1][y - 1] = ITEM
    }
    repeat(b) {
        val (x, y) = readLine()!!.split(" ").map { it.toInt() }
        map[x - 1][y - 1] = BLOCKED
    }

    data class Walk(val value: Int, val branch: Int)
    val visit = MutableList(n) { MutableList(m) { Walk(0, 1) } }
    for (y in (0 until m).reversed()) {
        for (x in (0 until n).reversed()) {
            val right = if (x + 1 < n && map[x + 1][y] != BLOCKED) {
                visit[x + 1][y]
            } else {
                null
            }
            val top = if (y + 1 < m && map[x][y + 1] != BLOCKED) {
                visit[x][y + 1]
            } else {
                null
            }
            val mod = if (map[x][y] == ITEM) -1 else 0
            visit[x][y] = if (right != null && top != null) {
                if (right.value == top.value) {
                    Walk(right.value + mod, right.branch + top.branch)
                } else if (right.value < top.value) {
                    Walk(right.value + mod, right.branch)
                } else {
                    Walk(top.value, top.branch)
                }
            } else if (right != null) {
                Walk(right.value + mod, right.branch)
            } else if (top != null) {
                Walk(top.value + mod, top.branch)
            } else {
                Walk(a + mod, 0)
            }
        }
    }

    println(visit[0][0].branch)
}