fun main(args: Array<out String>) {
    val memo = mutableListOf<Long>()
    val (a, b, c) = readLine()!!.split(" ").map { it.toLong() }

    memo.add(a % c)

    for (i in 0 until 31) {
        memo.add((memo.last() * memo.last()) % c)
    }

    var answer = 1L
    var remains = b
    var currTwoPower = 2147483648L
    var currIndex = 31
    while (remains > 0) {
        if (remains < currTwoPower) {
            currTwoPower /= 2L
            currIndex -= 1
            continue
        }
        remains -= currTwoPower
        answer = (answer * memo[currIndex]) % c
    }

    println(answer)
}