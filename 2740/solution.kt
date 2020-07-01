fun main(args: Array<out String>) {
    System.setOut(java.io.PrintStream(System.`out`, false, "UTF-8"))
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val a = List(n) {
        readLine()!!.split(" ").map { it.toInt() }
    }

    val k = readLine()!!.split(" ")[1].toInt()
    val b = List(m) {
        readLine()!!.split(" ").map { it.toInt() }
    }

    val newMatrix = List(n) { i ->
        List(k) { j ->
            (0 until m).sumBy { a[i][it] * b[it][j] }
        }
    }

    newMatrix.joinToString("\n") {
        it.joinToString(" ")
    }.let(::println)
}
