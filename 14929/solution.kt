fun main(args: Array<out String>) {
    readLine()
    val x = readLine()!!.split(" ").map { it.toLong() }
    var answer: Long = 0
    var sum: Long = 0
    for (i in x.reversed()) {
        answer += i*sum
        sum += i
    }
    println(answer)
}