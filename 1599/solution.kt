// Mapping Table, empty if same.
// a  b  k  d  e  g  h  i  l  m  n  ng  o  p  r  s  t  u  w  y
//       c                 j  l  m   n                        


fun parse(text: String): String {
    val result = StringBuilder()
    var beforeN = false
    for (c in text) {
        if (beforeN) {
            beforeN = false
            if (c == 'g') {
                result.append('n')
                continue
            } else {
                result.append('m')
            }
        }
        when (c) {
            'n' -> {
                beforeN = true
            }
            'k' -> {
                result.append('c')
            }
            'l' -> {
                result.append('j')
            }
            'm' -> {
                result.append('l')
            }
            else -> {
                result.append(c)
            }
        }
    }
    if (beforeN) result.append('m')

    return result.toString()
}

fun decrypt(input: String): String {
    val result = StringBuilder()
    for (c in input) {
        when (c) {
            'c' -> {
                result.append('k')
            }
            'j' -> {
                result.append('l')
            }
            'l' -> {
                result.append('m')
            }
            'm' -> {
                result.append('n')
            }
            'n' -> {
                result.append("ng")
            }
            else -> {
                result.append(c)
            }
        }
    }
    return result.toString()
}

fun main(args: Array<out String>) {
    List(readLine()!!.toInt()) { parse(readLine()!!) }.sorted().forEach {
        println(decrypt(it))
    }
}