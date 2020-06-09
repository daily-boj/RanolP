fun main(args: Array<out String>) {
    readLine()
    val numbers = readLine()!!.split(" ").map { it.toInt() }
    val toCreate = readLine()!!.toInt()

    val map = numbers.withIndex().groupBy(
        { it.value },
        { it.index }
    )
    var answer = 0

    for ((i, n) in numbers.withIndex()) {
        if (n >= toCreate) {
            continue
        }
        val others = map[toCreate - n]
        if (others == null) {
            continue
        }
        answer += others.dropWhile { it <= i }.size
    }

    println(answer)
}