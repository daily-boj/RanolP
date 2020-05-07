sealed class Node {
    abstract fun evaluate(): String

    data class Word(private val inner: String) : Node() {
        override fun evaluate(): String = inner.reversed()
    }

    data class Raw(private val inner: String) : Node() {
        override fun evaluate(): String = inner
    }
}

enum class Type {
    TAG_OPENED,
    TEXT,
    WHITESPACE,
    UNSET
}

fun parse(text: String): List<Node> {
    val result = mutableListOf<Node>()

    val builder = StringBuilder()
    var type = Type.UNSET

    fun createNode(f: (String) -> Node) {
        result += f(builder.toString())
        builder.clear()
        type = Type.UNSET
    }

    var i = 0
    fun peek(): Char? = text.getOrNull(i)
    fun next() {
        builder.append(text[i])
        i += 1
    }

    loop@ while(true) {
        val ch = peek()
        when (type) {
            Type.TAG_OPENED -> {
                next()
                if (ch != '>' && ch != null) {
                    continue@loop
                }
                createNode(Node::Raw)
            }
            Type.TEXT -> {
                if (ch in 'a'..'z' || ch in '0'..'9' && ch != null) {
                    next()
                    continue@loop
                }
                createNode(Node::Word)
            }
            Type.WHITESPACE -> {
                if (ch == ' ') {
                    next()
                    continue@loop
                }
                createNode(Node::Raw)
            }
            Type.UNSET -> {
                if (ch == null) {
                    break@loop
                }
                next()
                type = when (ch) {
                    '<' -> Type.TAG_OPENED
                    in 'a'..'z', in '0'..'9' -> Type.TEXT
                    ' ' -> Type.WHITESPACE
                    else -> throw Error("NEVER")
                }
            }
        }
        if (ch == null) {
            break
        }
    }

    return result
}


fun main(args: Array<out String>) {
    parse(readLine() ?: "").joinToString("") { it.evaluate() }.let(::println)
}