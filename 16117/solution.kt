fun main(args: Array<out String>) {
    val (height, width) = readLine()!!.split(" ").map { it.toInt() }
    val realMap = List(height * 2) {
        if (it % 2 == 0) {
            List(width * 2) { 0L }
        } else {
            readLine()!!.split(" ").flatMap { listOf(0L, it.toLong()) }
        }
    }

    fun getSafe(map: List<List<Long>>, x: Int, y: Int): Long =
        if (y in 0 until 2 * height && x in 0 until 2 * width) map[y][x]
        else 0

    val intDP = List(height * 2) {
        MutableList(width * 2) { 0L }
    }

    for (x in (0 until width * 2).reversed()) {
        for (y in (0 until height * 2).reversed()) {
            val here = realMap[y][x]
            val best = maxOf(
                getSafe(realMap, x + 1, y - 1) + getSafe(intDP, x + 2, y - 2),
                getSafe(realMap, x + 2, y) + getSafe(intDP, x + 4, y),
                getSafe(realMap, x + 1, y + 1) + getSafe(intDP, x + 2, y + 2)
            )
            intDP[y][x] = here + best
        }
    }

    val max = (0 until height * 2).fold(0L) { acc, y -> maxOf(acc, getSafe(intDP, 0, y), getSafe(intDP, 1, y)) }

    println(max)
}
