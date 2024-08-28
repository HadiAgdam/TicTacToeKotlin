package algorithms

import board.Board
import board.Mark
import board.Position

abstract class Algorithm {


    abstract fun play(board: Board, c: Mark): Position

}