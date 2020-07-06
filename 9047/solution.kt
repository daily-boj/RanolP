fun main(args: Array<out String>) {
    System.setOut(java.io.PrintStream(System.`out`, false, "UTF-8"))
    System.`in`.bufferedReader().lineSequence().drop(1).joinToString("\n") {
        var curr = it.padStart(4, '0')
        var count = 0
        while (curr != "6174") {
            var min = curr.toCharArray().sorted().joinToString("")
            var max = min.reversed()

            curr = (max.toInt() - min.toInt()).toString().padStart(4, '0')
            count += 1
        }

        count.toString()
    }.let(::println)
}
