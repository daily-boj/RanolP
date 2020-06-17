data class Variable(val wordList: List<String>) {
    companion object {
        fun parse(id: String, line: String): Variable {
            if (id == "2") {
                return Variable(line.split("_"))
            }
            val wordList = mutableListOf<String>()
            val buffer = StringBuilder()
            for (c in line) {
                if (c.isUpperCase()) {
                    if (buffer.isNotEmpty()) {
                        wordList.add(buffer.toString())
                        buffer.clear()
                    }
                } 
                buffer.append(c.toLowerCase())
            }
            if (buffer.isNotEmpty()) {
                wordList.add(buffer.toString())
            }
            return Variable(wordList)
        }
    }

    fun toSnakeCase(): String = wordList.joinToString("_")

    fun toPascalCase(): String = wordList.joinToString("") { it.capitalize() }
    
    fun toCamelCase(): String = wordList[0] + wordList.drop(1).joinToString("") { it.capitalize() }
}

fun main(args: Array<out String>) {
    val (id, line) = readLine()!!.split(" ")
    val variable = Variable.parse(id, line)
    println(variable.toCamelCase())
    println(variable.toSnakeCase())
    println(variable.toPascalCase())
}