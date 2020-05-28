fun main(args: Array<out String>) {
    val days = MutableList(32) { 0 }
    repeat(readLine()!!.toInt()) {
        val (borrow, drop) = readLine()!!.split(" ").map { it.toInt() }
        days[borrow] -= 1
        days[drop] += 1
    }
    var k = readLine()!!.toInt()
    for (modification in days) {
        k += modification
        if (k < 0) {
            println("0")
            return
        }
    }
    println("1")
}