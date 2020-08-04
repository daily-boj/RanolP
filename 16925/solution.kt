fun main() {
    System.setOut(java.io.PrintStream(System.`out`, false, "UTF-8"))

    val lines = System.`in`.bufferedReader().lineSequence().toList()

    val length = lines.first().toInt()
    val substrings = lines.drop(1).take(2 * length - 2)
    val substringsGrouped = substrings.groupBy { it.length }

    val (a, b) = substringsGrouped[length - 1]!!

    val original = if (substringsGrouped.values.all { (x, y) ->
        (a.startsWith(x) && b.endsWith(y)) ||
        (a.startsWith(y) && b.endsWith(x))
    }) {
        a[0] + b
    } else {
        b[0] + a
    }

    println(original)

    val prefixes = mutableSetOf<String>()

    for (s in substrings) {
        if (original.startsWith(s) && s !in prefixes) {
            print("P")
            prefixes.add(s)
        } else {
            print("S")
        }
    }
    println()
}
