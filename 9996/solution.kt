fun main(args: Array<out String>) {
    val n = readLine()!!.toInt()
    val (begin, end) = readLine()!!.split("*")
    repeat(n) { 
        val line = readLine()!!
        if (line.length >= begin.length + end.length && line.startsWith(begin) && line.endsWith(end)) {
            println("DA")
        } else {
            println("NE")
        }
    }
}