fun main(args: Array<out String>) {
    readLine()
    val arr = readLine()!!.split(" ").map { it.toInt() } + 2147483647
    var maxKills = 0
    val map = mutableMapOf<Int, Int>()
    var last = -1
    for (player in arr) {
        for (killer in map.keys.toList()) {
            val kills = map[killer]!!
            if (killer > player) {
                map[killer] = kills + 1
            } else {
                map.remove(killer)
                maxKills = maxOf(maxKills, kills)
            }
        }
        if (last < player) {
            map[player] = 0
        }
        last = player
    }
    println(maxKills)
}