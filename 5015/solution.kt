fun main() {
    System.setOut(java.io.PrintStream(System.`out`, false, "UTF-8"))

    class LsPattern(val pattern: List<String?>) {
        fun matches(dp: MutableMap<Int, Boolean>, str: String, patternIndex: Int, strIndex: Int): Boolean {
            val dpKey = patternIndex * 1000 + strIndex
            return dp.getOrPut(dpKey) {
                if (patternIndex == pattern.size) {
                    strIndex == str.length
                } else {
                    val patternPart = pattern[patternIndex]
                    if (patternPart != null) {
                        strIndex + patternPart.length <= str.length &&
                        str.substring(strIndex, strIndex + patternPart.length) == patternPart &&
                        matches(dp, str, patternIndex + 1, strIndex + patternPart.length)
                    } else {
                        (strIndex..str.length).any { matches(dp, str, patternIndex + 1, it) }
                    }
                }
            }
        }

        fun matches(str: String): Boolean {
            val dp = mutableMapOf<Int, Boolean>()
            val res = matches(dp, str, 0, 0)
            return res
        }
    }

    fun parsePattern(s: String): LsPattern {
        val result = mutableListOf<String?>()

        val buffer = StringBuilder()
        var isConstant = s[0] != '*'

        fun flush() {
            if (buffer.isEmpty()) {
                return
            }
            if (isConstant) {
                result.add(buffer.toString())
            } else {
                result.add(null)
            }
            buffer.setLength(0)
        }

        for (c in s) {
            if (c == '*') {
                if (isConstant) {
                    flush()
                }
                isConstant = false
            } else {
                if (!isConstant) {
                    flush()
                }
                isConstant = true
            }
            buffer.append(c)
        }
        flush()

        return LsPattern(result)
    }

    val pattern = parsePattern(readLine()!!)
    val words = List(readLine()!!.toInt()) {
        readLine()!!
    }.filter { pattern.matches(it) }

    words.forEach(::println)
}
