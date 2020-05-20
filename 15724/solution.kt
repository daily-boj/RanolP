fun main(args: Array<out String>) {
    val (height, width) = readLine()!!.split(" ").map { it.toInt() }
    val acc = MutableList(width + 1) {
        MutableList(height + 1) { 0 }
    }
    for (y in 1..height) {
        var x = 1
        for (v in readLine()!!.split(" ").map { it.toInt() }) {
            acc[x][y] = v + acc[x - 1][y] + acc[x][y - 1] - acc[x - 1][y - 1]
            x += 1
        }
    }

    (1..readLine()!!.toInt()).joinToString("\n") { 
        val (y1, x1, y2, x2) = readLine()!!.split(" ").map { it.toInt() }
        (acc[x2][y2] + acc[x1 - 1][y1 - 1] - acc[x1 - 1][y2] - acc[x2][y1 - 1]).toString()
    }.let(::println)
}