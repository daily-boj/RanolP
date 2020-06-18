fun main(args: Array<out String>) {
    (0 until readLine()!!.toInt()).joinToString("\n") {
        val (a, b) = readLine()!!.split(" ").map { it.toInt().toString(2) }
        val buffer = StringBuilder()
        for (i in 0 until minOf(a.length, b.length)) {
            if (a[i] == b[i]) {
                buffer.append(a[i])
            } else {
                break
            }
        }
        buffer.toString().toInt(2).toString() + "0"
    }.let(::println)
}
