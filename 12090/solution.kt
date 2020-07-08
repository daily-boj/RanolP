fun main() {
    System.setOut(java.io.PrintStream(System.`out`, false, "UTF-8"))
    System.`in`.bufferedReader().readLine().toCharArray().joinToString("") {
        "ㄱㄲㄴㄷㄸㄹㅁㅂㅃㅅㅆㅇㅈㅉㅊㅋㅌㅍㅎ"[(it.toInt() - 44032) / 588].toString()
    }.let(::println)
}
