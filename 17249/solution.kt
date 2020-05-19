fun main(args: Array<out String>) {
    var left = 0
    var right = 0
    var metFace = false
    for (c in readLine()!!) {
        when (c) {
            '0' -> metFace = true
            '@' -> if (!metFace) {
                left += 1
            } else {
                right += 1
            }
        }
    }
    println("$left $right")
}