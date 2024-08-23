package board

class Board(size: Int) {

    private val board = Array(size) { Array(size) { Mark.BLANK } }

    fun set(position: Position, mark: Mark) {

    }

    fun get(position: Position): Mark {
        return board[position.x][position.y]
    }

}