import java.util.*

class KeyLogger(val log: String) {
    var cursor = 0
    var buffer = LinkedList<Char>()

    fun cursorLeft() {
        cursor = maxOf(0, cursor - 1)
    }
    fun cursorRight() {
        cursor = minOf(buffer.size, cursor + 1)
    }
    fun backspace() {
        if (cursor == 0 || buffer.isEmpty()) {
            return
        }
        buffer.removeAt(cursor - 1)
        cursor -= 1
    }
    fun press(c: Char) {
        buffer.add(cursor, c)
        cursor += 1
    }

    fun evaluate(): String {
        for (c in log) {
            when (c) {
                '<' -> cursorLeft()
                '>' -> cursorRight()
                '-' -> backspace()
                else -> press(c)
            }
        }
        return buffer.joinToString("")
    }
}

fun main(args: Array<out String>) {
    List(readLine()!!.toInt()) {
        KeyLogger(readLine()!!).evaluate()
    }.joinToString("\n").let(::println)
}