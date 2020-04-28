fun main(args: Array<out String>) {
    var opened = 0
    var result = 0
    var lastOpened = false
    for (char in readLine()!!) {
        when (char) {
            '(' -> {
                opened += 1
                lastOpened = true
            }
            ')' -> {
                opened -= 1
                if (lastOpened) {
                    result += opened
                } else {
                    result += 1
                }
                lastOpened = false
            }
            else -> {}
        }
    }
    println(result)
}