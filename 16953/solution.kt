fun main(args: Array<out String>) {
    var (a, b) = readLine()!!.split(" ").map { it.toInt() }

    var operationPermitted = 1
    while (a != b && a < b) {
        if (b % 2 == 0) {
            b /= 2
        } else if (b % 10 == 1) {
            b /= 10
        } else {
            break
        }
        operationPermitted += 1
    }

    if (a == b) {
        println(operationPermitted)
    } else {
        println(-1)
    }
}
