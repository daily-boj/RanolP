fun main(args: Array<out String>) {
    var index = 0
    while (true) {
        index += 1
        val line = readLine()!!
        if (line == "0") {
            break
        }

        var isValid = true

        var piece5Count = 0
        var acceptable = "1"
        var isLast2 = false
        loop@for (c in line) {
            if (c !in acceptable) {
                isValid = false
                break
            }
            isLast2 = c == '2'
            
            acceptable = when (c) {
                '1' -> "45"
                '2' -> ""
                '3' -> "45"
                '4' -> "23"
                '5' -> {
                    piece5Count += 1
                    "8"
                }
                '6' -> {
                    if (piece5Count == 0) {
                        isValid = false
                        break@loop
                    }
                    piece5Count -= 1
                    "23"
                }
                '7' -> "8"
                '8' -> "67"
                else -> return
            }
        }

        if (isValid && isLast2 && piece5Count == 0) {
            println("$index. VALID")
        } else {
            println("$index. NOT")
        }
    }
}