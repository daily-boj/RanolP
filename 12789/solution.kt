fun main(args: Array<out String>) {
    readLine()
    val studentList = readLine()!!.split(" ").map { it.toInt() }
    val stack = java.util.ArrayDeque<Int>()
    var acceptableId = 1
    for (i in studentList) {
        if (i == acceptableId) {
            acceptableId += 1
            continue
        }
        while (stack.peekLast() == acceptableId) {
            acceptableId += 1
            stack.pollLast()
        }
        stack.addLast(i)
    }
    for (i in stack.reversed()) {
        if (i == acceptableId) {
            acceptableId += 1
        } else {
            println("Sad")
            return
        }
    }
    println("Nice")
}
