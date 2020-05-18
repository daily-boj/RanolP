enum class InequationType {
    LT, // <
    GT, // >
    KT, // Nothing
}

data class Minmax(val min: Long, val max: Long)

fun solve(previous: Int, choice: Long, seq: List<InequationType>, available: Set<Int>): Minmax {
    var min = 9999999999L
    var max = 0L
    if (seq.isEmpty()) {
        return Minmax(choice, choice)
    }
    for (i in available) {
        val canUse = when (seq[0]) {
            InequationType.KT -> true
            InequationType.LT -> previous < i
            InequationType.GT -> previous > i
        }
        if (!canUse) {
            continue
        }
        val result = solve(i, choice * 10 + i, seq.subList(1, seq.size), available - i)
        min = minOf(min, result.min)
        max = maxOf(max, result.max)
    }
    return Minmax(min, max)
}

fun main(args: Array<out String>) {
    val k = readLine()!!.toInt()
    val a = listOf(InequationType.KT) + readLine()!!.split(' ')
        .asSequence()
        .filter { it.isNotEmpty() }
        .map { if (it == "<") InequationType.LT else InequationType.GT }
        .toList()

    val (min, max) = solve(0, 0L, a, (0..9).toSet())
    println(max.toString().padStart(k + 1, '0'))
    println(min.toString().padStart(k + 1, '0'))
}