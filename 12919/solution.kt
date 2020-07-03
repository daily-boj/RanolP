fun main(args: Array<out String>) {
    System.setOut(java.io.PrintStream(System.`out`, false, "UTF-8"))
    val s = readLine()!!

    var t = readLine()!!
    fun findAnswer(isReversed: Boolean, chars: String): Boolean {
        if (s.length > chars.length) {
            return false
        }
        if (s.length == chars.length) {
            if (isReversed) {
                return s.reversed() == chars
            } else {
                return s == chars
            }
        }

        return if (isReversed) {
            listOfNotNull(
                if (chars.get(0) == 'A') {
                    findAnswer(isReversed, chars.substring(1, chars.length))
                } else {
                    null
                },
                if (chars.get(chars.length - 1) == 'B') {
                    findAnswer(!isReversed, chars.substring(0, chars.length - 1))
                } else {
                    null
                }
            )
        } else {
            listOfNotNull(
                if (chars.get(chars.length - 1) == 'A') {
                    findAnswer(isReversed, chars.substring(0, chars.length - 1))
                } else {
                    null
                },
                if (chars.get(0) == 'B') {
                    findAnswer(!isReversed, chars.substring(1, chars.length))
                } else {
                    null
                }
            )
        }.fold(false) { acc, ans -> acc || ans }
    }

    println(if (findAnswer(false, t)) 1 else 0)
}
