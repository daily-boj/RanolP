fun main(args: Array<out String>) {
    System.setOut(java.io.PrintStream(System.`out`, false, "UTF-8"))
    val a = (readLine()!!.toInt() - 1) % 8
    println(if (a > 4) 9 - a else a+1)
}