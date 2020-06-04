fun gcd(a: Long, b: Long): Long =
    if (a % b == 0L) {
        b
    } else {
        gcd(b, a%b)
    }

fun main(args: Array<out String>) {
    val (a, b) = readLine()!!.split(" ").map { it.toLong() }
    var answer = 0L
    for (i in 1L..1073741824L) {
        val square = i * i
        if (square > b) {
            break
        }
        if (a < square && square <= b) {
            answer += 1L
        }
    }
    val diff = b - a
    val gcdResult = gcd(answer, diff)
    val denominator = answer / gcdResult
    val numerator = diff / gcdResult
    if (denominator == 0L) {
        println("0")
    } else {
        println("$denominator/$numerator")
    }
}