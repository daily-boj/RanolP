fun main(args: Array<out String>) {
    val n = readLine()!!
    println(solve(n.toInt(), "", n.toList()) ?: 0)
}

fun solve(n: Int, built: String, usable: List<Char>): Int? {
    if (usable.size == 0) {
        val i = built.toInt()
        return if (i > n) {
            i
        } else {
            null
        }
    }
    return (0 until usable.size).mapNotNull {
        solve(n, built + usable[it], usable.subList(0, it) + usable.subList(it + 1, usable.size))
    }.min()
}