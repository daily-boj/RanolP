import kotlin.math.*
import java.util.*

class ChessBoard(n: Int) {
    val queens = IntArray(n) { 0 }
    var currentY = 0
    
    fun canKill(thisY: Int, otherY: Int): Boolean {
        val crossX = abs(queens[thisY] - queens[otherY])
        val crossY = abs(thisY - otherY)

        return queens[thisY] == queens[otherY] || thisY == otherY || crossX == crossY
    }

    inline fun canPlace(x: Int, f: (ChessBoard) -> Unit) {
        queens[currentY] = x
        if ((0 until currentY).all { !canKill(it, currentY) }) {
            currentY += 1
            f(this)
            currentY -= 1
        }
        queens[currentY] = 0
    }
}

fun solve(n: Int, y: Int, board: ChessBoard): Int {
    if (y >= n) { 
        return 1
    }
    var result = 0
    for (x in 0 until n) {
        board.canPlace(x) {
            result += solve(n, y + 1, board)
        }
    }
    return result
}

fun main(args: Array<out String>) {
    val n = readLine()!!.toInt()
    println(solve(n, 0, ChessBoard(n)))
}
