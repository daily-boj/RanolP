import java.io.*

fun main(args: Array<out String>) {
    var s = 0
    BufferedReader(InputStreamReader(System.`in`)).lines().iterator().asSequence().take(readLine()!!.toInt()).mapNotNull { line ->
        val split = line.split(" ")
        val command = split[0]
        val arg = if (split.size > 1) 1 shl (split[1].toInt() - 1) else 0
        when (command) {
            "add" -> {
                s = s or arg
            }
            "remove" -> {
                s = s and arg.inv()
            }
            "check" -> {
                return@mapNotNull if(arg and s != 0) "1" else "0"
            }
            "toggle" -> {
                s = s xor arg
            }
            "all" -> {
                s = 0xFFFFF
            }
            "empty" -> {
                s = 0
            }
        }
        null
    }.joinToString("\n").let(::println)
}
