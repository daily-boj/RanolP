fun main(args: Array<out String>) {
    var (n, m) = readLine()!!.split(" ").map { it.toInt() }

    var result = 0

    while (n > 0) {
        result += n
        n /= m
    }

    result += n

    println(result)
}