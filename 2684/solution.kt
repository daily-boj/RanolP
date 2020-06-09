fun main(args: Array<out String>) {
    (0 until readLine()!!.toInt()).joinToString("\n") {
        val result = MutableList(8) { 0 }
        val lineInBinary = readLine()!!.map { if (it == 'H') 1 else 0 }
        for ((first, second, third) in lineInBinary.windowed(3)) {
            val index = (first shl 2) or (second shl 1) or third
            result[index] += 1
        }
        result.joinToString(" ")
    }.let(::println)
}