fun main() {
    System.setOut(java.io.PrintStream(System.`out`, false, "UTF-8"))

    List(readLine()!!.toInt()) {
        val (value, unit) = readLine()!!.split(" ")
        val valueReal = value.toDouble()

        when (unit) {
            "kg" -> String.format("%.4f lb", valueReal * 2.2046)
            "lb" -> String.format("%.4f kg", valueReal * 0.4536)
            "l" -> String.format("%.4f g", valueReal * 0.2642)
            "g" -> String.format("%.4f l", valueReal * 3.7854)
            else -> ""
        }
    }.joinToString("\n").let(::println)
}
