data class Balls(val count: Int, val isEnd: Boolean)

fun main(args: Array<out String>) {
    readLine()

    val redBalls = mutableListOf<Balls>()
    val blueBalls = mutableListOf<Balls>()

    var count = 0
    var isLastBlue: Boolean? = null
    var isBegin = true

    loop@for (c in readLine()!!) {
        val isCurrentBlue = c == 'B'
        if (isLastBlue == null) {
            isLastBlue = isCurrentBlue
        }
        when (isLastBlue) {
            isCurrentBlue -> {
                count += 1
                continue@loop
            }
            true -> {
                blueBalls += Balls(count, isBegin)
            }
            false -> {
                redBalls += Balls(count, isBegin)
            }
        }
        isBegin = false
        count = 1
        isLastBlue = isCurrentBlue
    }
    if (isLastBlue == true) {
        blueBalls += Balls(count, true)
    } else {
        redBalls += Balls(count, true)
    }
    
    val answer = listOf(
        redBalls.asSequence(),
        blueBalls.asSequence(),
        redBalls.reversed().asSequence(),
        blueBalls.reversed().asSequence()
    ).map {
        it.withIndex().sumBy { (i, v) -> if(i == 0 && v.isEnd) 0 else v.count }
    }.min()

    println(answer)
}