fun main(args: Array<out String>) {
    for (index in generateSequence(1, Int::inc)) {
        val line = readLine()!!
        if (line == "0") {
            break
        }

        var isValid = true

        var acceptable = "1"
        var isLast2 = false
        for (c in line) {
            if (c !in acceptable) {
                isValid = false
                break
            }
            isLast2 = c == '2'
            
            acceptable = when (c) {
                '1', '3' -> "45"
                '2' -> ""
                '4', '6' -> "23"
                '5', '7' -> "8"
                '8' -> "67"
                else -> return
            }
        }

        if (isValid && isLast2) {
            "VALID"
        } else {
            "NOT"
        }.let { println("$index. $it") }
    }
}