fun main(args: Array<out String>) {
    var (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val numbers = List(10) {
        mutableListOf<Int>()
    }
    val sequence = java.util.ArrayDeque<Int>(n)
    var removed = 0
    for ((i, ch) in readLine()!!.withIndex()) {
        val chnum = ch.toString().toInt()
        while (!sequence.isEmpty() && k > 0) {
            if (sequence.peekLast()!! >= chnum) {
                break
            }

            sequence.pollLast()
            k -= 1
            removed += 1
        }

        sequence.offerLast(chnum)
        numbers[chnum] += i - removed
    }
    numbers.forEach { it.sort() }
    val banned = numbers.flatten().take(k).toSet()
    val result = StringBuilder(n)

    for ((i, ch) in sequence.withIndex()) {
        if (i in banned) {
            continue
        }
        result.append(ch)
    }

    println(result.toString())
}