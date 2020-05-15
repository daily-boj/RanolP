val dp = mutableMapOf<String, Int>()

fun solve(line: String): Int {
    if (line.length == 0) {
        return 1
    }
    if (line.length == 1 && line[0] != '0') {
        return 1
    }
    if (line !in dp) {
        if (line[0] == '0') {
            throw Exception("Unexpected 0")
        }
        if (line[0] == '1' || (line[0] == '2' && line[1] in '0'..'6')) {
            var sum = 0
            try {
                sum += solve(line.substring(1)) % 1000000
            } catch (e: Exception) {}
            try {
                sum += solve(line.substring(2)) % 1000000
            } catch (e: Exception) {}
            if (sum == 0) {
                throw Exception("Unexpected 0")
            }
            dp[line] = sum % 1000000
        } else {
            dp[line] = solve(line.substring(1))
        }
    }
    return dp[line]!!
}

fun main(args: Array<out String>) {
    val line = readLine()!!
    try {
        println(solve(line))
    } catch (e: Exception) {
        println(0)
    }
}