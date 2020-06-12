fun main(args: Array<out String>) {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    
    val rowPlaced = mutableSetOf<Int>()
    val columnPlaced = mutableSetOf<Int>()

    repeat(n) { rowIndex ->
        for ((columnIndex, c) in readLine()!!.withIndex()) {
            if (c == 'X') {
                rowPlaced += rowIndex
                columnPlaced += columnIndex
            }
        }
    }

    println(maxOf(n - rowPlaced.size, m - columnPlaced.size))
}