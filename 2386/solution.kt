fun main(args: Array<out String>) {
    System.`in`
        .bufferedReader()
        .lineSequence()
        .takeWhile { it != "#" }
        .joinToString("\n") {
            val toCheck = it[0]
            val count = it.drop(2).filter { it.toLowerCase() == toCheck }.count()
            "$toCheck $count"
        }
        .let(::println)
}