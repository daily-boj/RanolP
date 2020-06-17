val SPECIAL_CHARACTERS = Regex("""([()\[\]{}.,;:])""")
val NORMALIZE_SPACE = Regex("( +)")
val NORMALIZE_ALPHA = Regex("([A-Z]+)")
val NORMALIZE_BRACE_OPEN = Regex("""([(\[{])""")
val NORMALIZE_BRACE_CLOSE = Regex("""([)\]}])""")
val NORMALIZE_SEPARATOR = Regex("([,;])")

fun normalize(text: String): String =
    text.replace(SPECIAL_CHARACTERS) { " ${it.groupValues[1]} " }
        .replace(NORMALIZE_BRACE_OPEN, "(")
        .replace(NORMALIZE_BRACE_CLOSE, ")")
        .replace(NORMALIZE_SEPARATOR, ",")
        .replace(NORMALIZE_SPACE, " ")
        .replace(NORMALIZE_ALPHA) { it.groupValues[1].toLowerCase() }

fun main(args: Array<out String>) {
    (0 until readLine()!!.toInt()).joinToString("\n\n") { i ->
        val a = normalize(readLine()!!)
        val b = normalize(readLine()!!)

        if (a == b) {
            "Data Set ${i + 1}: equal"
        } else {
            "Data Set ${i + 1}: not equal"
        }
    }.let(::println)
}
