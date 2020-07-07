fun main(args: Array<out String>) {
    System.setOut(java.io.PrintStream(System.`out`, false, "UTF-8"))

    var n = readLine()!!.toInt()
    var check = 10
    while (n > check) {
        if (n % check < check / 10 * 5) {
            n -= n % check
        } else {
            n = n - (n % check) + check
        }
        check *= 10
    }

    println(n)
}
