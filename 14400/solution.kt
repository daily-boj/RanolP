import kotlin.math.abs

fun main() {
    System.setOut(java.io.PrintStream(System.`out`, false, "UTF-8"))

    val n = readLine()!!.trim().toInt()

    val customersX = mutableListOf<Long>()
    val customersY = mutableListOf<Long>()

    repeat(n) {
        val (x, y) = readLine()!!.split(" ").filter { it.isNotEmpty() }.map { it.toLong() }
        customersX.add(x)
        customersY.add(y)
    }

    customersX.sort()
    customersY.sort()

    var xDistanceSum = Long.MAX_VALUE
    var yDistanceSum = Long.MAX_VALUE

    var takenX = 0L
    var customerXSum = customersX.sum()
    var takenY = 0L
    var customerYSum = customersY.sum()

    for (i in 0 until n) {
        val x = customersX[i]
        xDistanceSum = minOf(xDistanceSum, abs(customerXSum - 2 * takenX - n * x + 2 * i * x))
        takenX += x

        val y = customersY[i]
        yDistanceSum = minOf(yDistanceSum, abs(customerYSum - 2 * takenY - n * y + 2 * i * y))
        takenY += y
    }

    println(xDistanceSum + yDistanceSum)
}
