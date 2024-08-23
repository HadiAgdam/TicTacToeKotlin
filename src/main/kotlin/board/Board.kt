package board

class Board(private val size: Int) {

    private val winSize = when (size) {
        3 -> 3
        else -> 3 // TEMP
    }

    private val board = Array(size) { Array(size) { Mark.BLANK } }

    fun set(position: Position, mark: Mark) {
        board[position.x][position.y] = mark
    }

    fun get(position: Position): Mark {
        return board[position.x][position.y]
    }

    fun clear() {
        for (i in 0 until size)
            board[i] = Array(size) { Mark.BLANK }
    }

    private fun checkWin(position: Position): Boolean {

        var j = 0
        val m = get(position)

        if (winSize <= size - position.x)
            for (x in position.x + 1 until size)
                if (get(position.copy(x = x)) == m)
                    j++
                else break
        if (j >= winSize - 1) return true


        j = 0
        if (winSize <= size - position.y)
            for (y in position.y + 1 until size)
                if (get(position.copy(y = y)) == m)
                    j++
                else break

        if (j >= winSize - 1) return true

        j = 0
        if (winSize <= size - position.x && winSize <= size - position.y)
            for (i in 1 until winSize)
                if (position.x < size && position.y < size && get(
                        position.copy(
                            x = position.x + 1,
                            y = position.y + 1
                        )
                    ) == m
                )
                    j++
                else break
        if (j >= winSize - 1) return true


        // TODO from top right to bottom left


        return false
    }

    fun checkWin(): Mark? {

        for (x in 0 until size) for (y in 0 until size) {
            val p = Position(x, y)
            if (get(p) == Mark.BLANK) continue
            if (checkWin(p))
                return get(p)

        }

        return null
    }

}