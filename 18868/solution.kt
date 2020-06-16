class Universe(val value: List<Int>) {
    override fun equals(other: Any?): Boolean = other is Universe && sametypeEquals(other)

    fun sametypeEquals(other: Universe): Boolean =
        (0 until value.size).all { a ->
            (a until value.size).all { b -> 
                this.value[a].compareTo(this.value[b]) == other.value[a].compareTo(other.value[b])
            }
        }
}

fun main(args: Array<out String>) {
    val (m, n) = readLine()!!.split(" ").map { it.toInt() }
    val multiverse = List(m) {
        Universe(readLine()!!.split(" ").map { it.toInt() })
    }
    var count = 0
    for (i in 0 until m) {
        for (j in i + 1 until m) {
            if (multiverse[i] == multiverse[j]) {
                count += 1
            }
        }
    }
    println(count)
}