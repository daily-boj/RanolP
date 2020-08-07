fun main() {
    System.setOut(java.io.PrintStream(System.`out`, false, "UTF-8"))

    val lines = System.`in`.bufferedReader().readLines().iterator()
    while (lines.hasNext()) {
        val count = lines.next().toInt()
        val list = List(count) {
            lines.next().toCharArray().distinct().sorted()
        }.distinct()

        println(list.size)
    }
}
