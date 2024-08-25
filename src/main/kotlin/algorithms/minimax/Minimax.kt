package algorithms.minimax

import board.Board
import board.Mark
import board.Position
import kotlin.math.abs

object Minimax {
    private fun minimax(board: Board, mark: Mark, depth: Int = 10): Int {
        if (depth == 0) return 0

        when (board.checkWin()) {
            mark -> return depth
            mark.opponent() -> return -depth
            else -> {}
        }

        var highest = 0

        for (blank in board.getBlanks()) {
            board.set(blank, mark.opponent())
            val l = -minimax(board, mark.opponent(), depth - 1)


            if (abs(l) > highest) highest = l

            board.set(blank, Mark.BLANK)
        }

        return highest
    }


    fun play(board: Board, c: Mark): Position {

        val blanks = board.getBlanks()

        var highestVal = Int.MIN_VALUE
        var highestPosition: Position? = null


        for (blank in blanks) {
            board.set(blank, c)

            val m = minimax(board, c)

            println("${blank.x} ${blank.y} : $m")

            if (m > highestVal) {
                highestPosition = blank
                highestVal = m
            }
            board.set(blank, Mark.BLANK)
        }




        return highestPosition!!
    }
}