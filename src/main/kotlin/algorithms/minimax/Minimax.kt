package algorithms.minimax

import board.Board
import board.Mark
import board.Position


fun minimax(board: Board, c: Mark, depth: Int = 10): Int {
    return 0
}


fun play(board: Board, c: Mark): Position {

    val b = board.copy()
    val blanks = b.getBlanks()

    var highestVal = Int.MIN_VALUE
    var highestPosition: Position? = null

    for (blank in blanks) {
        board.set(blank, c)

        val m = minimax(b, c)
        if (m > highestVal) {
            highestPosition = blank
            highestVal = m
        }
    }


    return highestPosition!!
}
