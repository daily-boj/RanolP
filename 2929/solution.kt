fun main() {
    System.setOut(java.io.PrintStream(System.`out`, false, "UTF-8"))

    var answer = 0
    var before = 0
    for (c in readLine()!!) {
        if (c.isUpperCase()) {
            val toAdd = (4 - before % 4) % 4
            answer += toAdd
            before = 1
        } else {
            before += 1
        }
    }

    println(answer)
}
