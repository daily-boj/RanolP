fun main(args: Array<out String>) {
    val input = readLine()!!
    ('a'..'z').joinToString(" ") { input.indexOf(it).toString() }.let(::println)
}