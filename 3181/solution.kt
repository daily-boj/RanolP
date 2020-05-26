val ignores = listOf("i", "pa", "te", "ni", "niti", "a", "ali", "nego", "no", "ili")

fun main(args: Array<out String>) {
    readLine()!!.split(" ").withIndex().mapNotNull { (i, word) ->
        if (i != 0 && word in ignores) {
            null
        } else {
            word[0].toUpperCase().toString()
        }
    }.joinToString("").let(::println)
}