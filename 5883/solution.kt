fun main(args: Array<out String>) {
    val n = readLine()!!.toInt()
    val guests = List(n) { readLine()!!.toInt() }
    val unique = guests.toSet()
    var longest = 0
    for (delete in unique) {
        var last = -1
        var len = 0
        for (i in guests) {
            if (delete == i) {
                continue
            }
            if (last != i) {
                longest = maxOf(longest, len)
                len = 0
                last = i
            }
            len += 1
        }
        longest = maxOf(longest, len)
    }
    println(longest)
}