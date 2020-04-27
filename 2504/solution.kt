sealed class Node {
    abstract fun evaluate(): Int

    data class RoundBracket(val child: Node) : Node() {
        override fun evaluate(): Int = 2 * child.evaluate()
    }
    data class SquareBracket(val child: Node) : Node() {
        override fun evaluate(): Int = 3 * child.evaluate()
    }
    data class BracketSequence(val children: List<Node>) : Node() {
        override fun evaluate(): Int =
            children.sumBy { it.evaluate() }
    }
    object None : Node() {
        override fun evaluate(): Int = 1
    }
    object Error : Node() {
        override fun evaluate(): Int = 0
    } 
}

class Parser(private val source: String) {
    private var index = 0

    private fun peek(): Char? =
        if (hasNext()) {
            source[index]
        } else {
            null
        }

    private fun next(): Char? =
        if (hasNext()) {
            val result = source[index]
            index += 1
            result
        } else {
            null
        }

    private fun hasNext(): Boolean = index < source.length

    fun parse(): Node {
        val result = nextBracketSequence()
        if (hasNext()) {
            return Node.Error
        } else {
            return result
        }
    }

    fun nextBracketSequence(): Node {
        val nodeList = mutableListOf<Node>()
        loop@ while (hasNext()) {
            val current = when (peek()) {
                '(' -> nextRoundBracket()
                '[' -> nextSquareBracket()
                else -> {
                    if (nodeList.isEmpty()) {
                        return Node.None
                    } else {
                        break@loop
                    }
                }
            }
            if (current == Node.Error) {
                return Node.Error
            }
            nodeList.add(current)
        }
        return Node.BracketSequence(nodeList)
    }

    fun nextRoundBracket(): Node {
        next()
        val inner = nextBracketSequence()
        if (inner == Node.Error) {
            return Node.Error
        }
        if (next() != ')') {
            return Node.Error
        }
        return Node.RoundBracket(inner)
    }

    fun nextSquareBracket(): Node {
        next()
        val inner = nextBracketSequence()
        if (inner == Node.Error) {
            return Node.Error
        }
        if (next() != ']') {
            return Node.Error
        }
        return Node.SquareBracket(inner)
    }
}

fun main(args: Array<out String>) {
    println(Parser(readLine()!!).parse().evaluate())
}