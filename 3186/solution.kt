fun main(args: Array<out String>) {
    class FlyingSpaghettiMonster(val k: Int, val l: Int) {
        var time = 0
        var counter = 0
        var isUsingMode = false
        var isCompleted: Boolean
            get() = !isUsingMode
            set(value) {
                isUsingMode = !value
            }
        val flushes = mutableListOf<Int>()

        fun manFound() {
            time += 1
            if (isCompleted) {
                counter += 1
                if (counter >= k) {
                    isUsingMode = true
                    counter = 0
                }
            } else {
                counter = 0
            }
        }

        fun manNotFound() {
            time += 1
            if (isUsingMode) {
                counter += 1
                if (counter >= l) {
                    isUsingMode = false
                    flushes.add(time)
                    counter = 0
                }
            } else {
                counter = 0
            }
        }

        fun complete() {
            if (isUsingMode) {
                time += l - counter
                flushes.add(time)
            }
        }
    }

    val (k, l) = readLine()!!.split(" ").map { it.toInt() }
    val men = readLine()!!.toCharArray().map { it == '1' }

    val fsm = FlyingSpaghettiMonster(k, l)
    for (man in men) {
        if (man) {
            fsm.manFound()
        } else {
            fsm.manNotFound()
        }
    }
    fsm.complete()
    fsm.flushes
        .map { it.toString() }
        .ifEmpty { listOf("NIKAD") }
        .joinToString("\n")
        .let(::println)
}
