fun main(args: Array<out String>) {
    repeat(readLine()!!.toInt()) { 
        val nstr = readLine()!!
        val sum = (nstr.toInt() + nstr.reversed().toInt()).toString()
        for (i in 0 until (sum.length / 2 + 1)) {
            if (sum[i] != sum[sum.length - i - 1]) {
                println("NO")
                return@repeat
            }
        }
        println("YES")
    }
}