fun main(args: Array<out String>) {
    val n = readLine()!!.toInt()
    System.`in`.bufferedReader().lineSequence().take(n).joinToString("\n") {
        "god" + it.split(" ").drop(1).joinToString("")
    }.let(::println)
}
