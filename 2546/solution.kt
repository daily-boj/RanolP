fun main() {
    System.setOut(java.io.PrintStream(System.`out`, false, "UTF-8"))
    val tc = readLine()!!.toInt()

    repeat(tc) {
        readLine()
        readLine()
        val clang = readLine()!!.split(" ").map { it.toDouble() }
        val economy = readLine()!!.split(" ").map { it.toDouble() }

        val clangIqAverage = clang.sum() / clang.size.toDouble()
        val economyIqAverage = economy.sum() / economy.size.toDouble()
        val smartEnough = clang.filter { economyIqAverage < it && it < clangIqAverage }

        println(smartEnough.size)
    }
}
