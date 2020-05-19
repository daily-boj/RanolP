class ShiftArray(val size: Int) {
    private var shift = 0
    private val real = IntArray(size)

    fun evaluateIndex(index: Int): Int = (shift + index) % size

    fun shiftLeft(v: Int) {
        shift = (shift + size - v) % size
    }
    fun shiftRight(v: Int) {
        shift = (shift + v) % size
    }

    operator fun get(index: Int): Int = real[evaluateIndex(index)]

    operator fun set(index: Int, value: Int) {
        real[evaluateIndex(index)] = value
    }

    fun toIntArray(): IntArray =
        (real.drop(evaluateIndex(0)) + real.take(evaluateIndex(0))).toIntArray()
}

fun main(args: Array<out String>) {
    val (n, q) = readLine()!!.split(" ").map { it.toInt() }
    val arr = ShiftArray(n)
    readLine()!!.split(" ").asSequence().map { it.toInt() }.withIndex().forEach { (i, v) ->
        arr[i] = v
    }
    repeat(q) { 
        val query = readLine()!!.split(" ").map { it.toInt() }
        when (query[0]) {
            1 -> arr[query[1] - 1] += query[2]
            2 -> arr.shiftLeft(query[1])
            3 -> arr.shiftRight(query[1])
        }
    }
    arr.toIntArray().joinToString(" ").let(::println)
}