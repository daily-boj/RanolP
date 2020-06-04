fun main(args: Array<out String>) {
    val count = mutableMapOf<Char, Int>()
    for (c in readLine()!!) {
        val key = c.toUpperCase()
        count[key] = 1 + (count[key] ?: 0)
    }

    val max = count.keys.maxBy { count[it]!! }!!
    val maxValue = count[max]!!
    if (count.keys.any { it != max && maxValue == count[it]!! }) {
        println("?")
    } else {
        println(max)
    }
}