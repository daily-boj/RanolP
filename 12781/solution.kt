data class Vector2(val x: Double, val y: Double) : Comparable<Vector2> {
    fun cross(other: Vector2): Double = this.x * other.y - this.y * other.x
    
    operator fun times(r: Double): Vector2 = Vector2(this.x * r, this.y * r)

    operator fun plus(other: Vector2): Vector2 = Vector2(this.x + other.x, this.y + other.y)
    operator fun minus(other: Vector2): Vector2 = Vector2(this.x - other.x, this.y - other.y)

    override fun compareTo(other: Vector2): Int {
        val xCompared = this.x.compareTo(other.x)

        return if (xCompared != 0) {
            xCompared
        } else {
            this.y.compareTo(other.y)
        }
    }
}

fun ccw(p: Vector2, a: Vector2, b: Vector2): Double = (a - p).cross(b - p)

fun lineIntersection(a: Vector2, b: Vector2, c: Vector2, d: Vector2): Boolean {
    val ab = ccw(a, b, c) * ccw(a, b, d)
    val cd = ccw(c, d, a) * ccw(c, d, b)

    return ab < 0 && cd < 0
}

fun main(args: Array<out String>) {
    val (a, b, c, d) =
        readLine()!!
            .split(" ")
            .filter { it.isNotEmpty() }
            .map { it.toDouble() }
            .chunked(2)
            .map { (x, y) -> Vector2(x, y) }

    if (lineIntersection(a, b, c, d)) {
        println(1)
    } else {
        println(0)
    }
}