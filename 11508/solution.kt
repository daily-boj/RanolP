fun main(args: Array<out String>) {
    List(readLine()!!.toInt()) { 
        readLine()!!.toInt()
    }.sortedDescending().chunked(3).sumBy {
        if (it.size == 3) {
            it[0] + it[1]
        } else {
            it.sum()
        }
    }.let(::println)
}