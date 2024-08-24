package algorithms.minimax

import board.Board
import board.Mark
import board.Position


fun minimax(): Int {
    TODO()
}



fun play(board: Board, c: Mark): Position {
    val blanks = board.getBlanks()

    var highestVal = Int.MIN_VALUE
    var highestPosition: Position? = null

    for (blank in blanks) {
        board.set(blank, c)

        val m = minimax()
        if (m > highestVal) {
            highestPosition = blank
            highestVal = m
        }
    }


    return highestPosition!!

}
