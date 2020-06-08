fun main(args: Array<out String>) {
    List(readLine()!!.toInt()) {
        val nstr = readLine()!!
        val n = nstr.toInt()
        if ((n * n).toString().endsWith(nstr)) {
            "YES"
        } else {
            "NO"
        }
    }.joinToString("\n").let(::println)
}