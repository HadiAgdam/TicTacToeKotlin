package algorithms.minimax_storage

import algorithms.Algorithm
import algorithms.minimax.Minimax
import board.Board
import board.Mark
import board.Position
import kotlin.math.abs

object MinimaxStorage : Algorithm() {

    private fun minimax(board: Board, mark: Mark, depth: Int = 10): Int {

        val blanks = board.getBlanks()

        var highestValue = 0

        for (blank in blanks) {
            board.set(blank, mark)

            if (board.checkWin() == mark) {
                board.set(blank, Mark.BLANK)
                return depth
            }

            val v = -minimax(board, mark.opponent(), depth - 1)
            if (abs(v) > highestValue)
                highestValue = v

            board.set(blank, Mark.BLANK)
        }


        return highestValue

    }


    override fun play(board: Board, c: Mark): Position {

        val blanks = board.getBlanks()

        var highestVal = Int.MIN_VALUE
        var highestPosition: Position? = null


        for (blank in blanks) {

            board.set(blank, c.opponent())
            if (board.checkWin() == c.opponent()) {
                println()
                board.print()
                println()
                return blank
            }

            board.set(blank, c)
            if (board.checkWin() == c) {
                println("returned win ${blank.x} ${blank.y}")
                return blank
            }

            val m = -minimax(board, c.opponent())

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