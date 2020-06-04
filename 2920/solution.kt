enum class Direction {
    Ascending,
    Descending,
    Mixed,
    Unknown
}

fun main(args: Array<out String>) {
    val numbers = readLine()!!.split(" ").map { it.toInt() }
    var direction = Direction.Unknown
    for ((prev, curr) in numbers.windowed(2)) {
        if (prev < curr) {
            if (direction == Direction.Unknown || direction == Direction.Ascending) {
                direction = Direction.Ascending
            } else {
                direction = Direction.Mixed
                break
            }
        } else {
            if (direction == Direction.Unknown || direction == Direction.Descending) {
                direction = Direction.Descending
            } else {
                direction = Direction.Mixed
                break
            }
        }
    }

    when (direction) {
        Direction.Ascending -> "ascending"
        Direction.Descending -> "descending"
        Direction.Mixed -> "mixed"
        else -> ""
    }.let(::println)
}