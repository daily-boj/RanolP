fun main(args: Array<out String>) {
    fun pooling(matrix: List<List<Int>>): List<List<Int>> {
        if (matrix.size == 1) {
            return matrix
        }
        return List(matrix.size / 2) { i ->
            List(matrix.size / 2) { j ->
                listOf(
                    matrix[i * 2][j * 2],
                    matrix[i * 2 + 1][j * 2],
                    matrix[i * 2][j * 2 + 1],
                    matrix[i * 2 + 1][j * 2 + 1]
                ).sorted().dropLast(1).last()
            }
        }
    }

    val size = readLine()!!.toInt()
    var matrix = List(size) {
        readLine()!!.split(" ").map { it.toInt() }
    }
    while (matrix.size > 1) {
        matrix = pooling(matrix)
    }
    println(matrix[0][0])
}
