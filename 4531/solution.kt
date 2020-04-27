val regex = Regex("""(IV|IX|XL|XC|CD|CM)""")

fun main(args: Array<out String>) {
    var count = readLine()!!.toInt()
    while(count --> 0) {
        val result = readLine()!!.replace(regex) {
            when (it.groupValues[0]) {
                "IV" -> "a"
                "IX" -> "b"
                "XL" -> "c"
                "XC" -> "d"
                "CD" -> "e"
                "CM" -> "f"
                else -> "?"
            }
        }.sumBy {
            when (it) {
                'I' -> 1
                'a' -> 4
                'V' -> 5
                'b' -> 9
                'X' -> 10
                'c' -> 40
                'L' -> 50
                'd' -> 90
                'C' -> 100
                'e' -> 400
                'D' -> 500
                'f' -> 900
                'M' -> 1000
                else -> 0
            }
        }
        println(result)
    }
}