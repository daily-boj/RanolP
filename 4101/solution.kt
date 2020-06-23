fun main(args: Array<out String>) {
    System.`in`
        .bufferedReader()
        .lineSequence()
        .takeWhile { it != "0 0" }
        .joinToString("\n") {
            val (a, b) = it.split(" ").map { it.toInt() }
            if (a > b) {
                "Yes"
            } else {
                "No"
            }
        }.let(::println)
}