fun main(args: Array<out String>) {
    System.setOut(java.io.PrintStream(System.`out`, false, "UTF-8"))

    readLine()
    val seq = readLine()!!.split(" ").map { it.toInt() }

    if (seq.size == 1) {
        println("A")
        return
    }
    if (seq.size == 2) {
        if (seq[0] == seq[1]) {
            println(seq[1])
        } else {
            println("A")
        }
        return
    }

    val (x, y, z) = seq
    val (a, b) = if (x == y) {
        Pair(1, 0)
    } else {
        val a = (y - z) / (x - y)
        val b = y - a * x
        Pair(a, b)
    }

    if (seq.windowed(2).all { (prev, curr) -> a * prev + b == curr }) {
        println(a * seq.last() + b)
    } else {
        println("B")
    }
}
