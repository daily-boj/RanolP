fun main(args: Array<out String>) {
    val n = readLine()!!.toInt()
    val numbers = readLine()!!.split(" ").map { it.toInt() }
    val accu = mutableListOf<Int>()
    for (i in numbers) {
        accu += i + (accu.lastOrNull() ?: 0)
    }
    
    val allSum = accu[n - 1]

    var result = allSum
    for (i in 0 until n) {
        result = maxOf(allSum - accu[i] + if(i > 0) accu[i - 1] else 0, result)
    }

    println(result)
}