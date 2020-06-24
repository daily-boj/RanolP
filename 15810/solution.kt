fun main(args: Array<out String>) {
    val (staffs, balloons) = readLine()!!.split(" ").map { it.toLong() }
    val balloonTimeList = readLine()!!.split(" ").map { it.toLong() }

    fun simulate(times: Long): Long = balloonTimeList.map { times / it }.sum()

    var low = 0L
    var high = 1_000_000_000_001L
    while (low < high) {
        val mid = (low + high) / 2
        val result = simulate(mid)
        if (result >= balloons) {
            high = mid
        } else {
            low = mid + 1
        }
    }

    println(low)
}
