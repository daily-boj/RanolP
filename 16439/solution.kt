fun main(args: Array<out String>) {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val satisfaction = mutableListOf<List<Int>>()
    repeat(n) {
        satisfaction += readLine()!!.split(" ").map { it.toInt() }
    }

    var maximized = 0

    for(i in 0 until m) {
        j@for(j in 0 until m) {
            if (i == j) continue@j
            k@for(k in 0 until m) {
                if (i == k || j == k) continue@k
                var curr = satisfaction.map { maxOf(it[i], it[j], it[k]) }.sum()

                maximized = maxOf(curr, maximized)
            }
        } 
    }

    println(maximized)
}