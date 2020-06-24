fun main(args: Array<out String>) {
    System.`in`
        .bufferedReader()
        .lineSequence()
        .takeWhile { it != "END" }
        .chunked(2)
        .withIndex()
        .joinToString("\n") { (i, chunk) ->
            if (chunk[0].toCharArray().sorted() == chunk[1].toCharArray().sorted()) {
                "Case ${i + 1}: same"
            } else {
                "Case ${i + 1}: different"
            }
        }.let(::println)
}
