fun main(args: Array<out String>) = ((1..30).toSet() - System.`in`.bufferedReader().lineSequence().map { it.toInt() }.toSet()).toList().sorted().forEach(::println)
