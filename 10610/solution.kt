fun main(args: Array<out String>) {
    val input = readLine()!!
    val hasZero = input.any { it == '0' }
    val sumModThreeIsZero = input.sumBy { it.toInt() } % 3 == 0
    if (!hasZero || !sumModThreeIsZero) {
        println("-1")
    } else {
        println(input.toCharArray().sortedDescending().joinToString(""))
    }
}