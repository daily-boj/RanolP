fun main(args: Array<out String>) {
    System.`in`.bufferedReader().lineSequence().joinToString("\n") {
        val n = it.toLong()
        val notAppeared = "0123456789".toCharArray().toMutableSet()
        var curr = n
        var k = 0
        while (notAppeared.isNotEmpty()) {
            k += 1
            for (c in curr.toString()) {
                notAppeared -= c
            }
            curr += n
        }
        k.toString()
    }.let(::println)
}
