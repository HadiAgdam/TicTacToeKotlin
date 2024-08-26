package board

data class Board(private val size: Int) {

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

    fun getBlanks(): List<Position> {
        val result = ArrayList<Position>()

        for (x in 0 until size) for (y in 0 until size)
//            if (get(Position(x, y)) == Mark.BLANK) result.add(Position(x, y))
            Position(x, y).apply {
                if (get(this) == Mark.BLANK) result.add(this)
            }


        return result
    }

    private fun checkWin(position: Position): Boolean {

        val m = get(position)

        var hw = 0
        var vw = 0

        for (i in 1 until winSize) {
            if (hw == -1 && vw == -1) break
            if (i + position.x < size && get(position.copy(x = position.x + i)) == m)
                hw++
            else hw = -1
            if (i + position.y < size && get(position.copy(y = position.y + i)) == m)
                vw++
            else vw = -1
        }

        if (vw >= winSize - 1 || hw >= winSize - 1) return true

        var j = 0
        if (winSize <= size - position.x && winSize <= size - position.y)
            for (i in 1 until winSize)
                if (position.x + i < size && position.y + i < size && get(
                        position.copy(
                            x = position.x + i,
                            y = position.y + i
                        )
                    ) == m
                )
                    j++
                else break
        if (j >= winSize - 1) return true


        j = 0
        if (position.y + winSize - 1 < size && position.x - winSize >= -1)
            for (i in 1 until winSize) {
                if (position.x - i >= 0 && position.y + i < size &&
                    get(
                        position.copy(
                            x = position.x - i,
                            y = position.y + i
                        )
                    ) == m
                ) j++
                else break
            }


        return j >= winSize - 1
    }

    // returns the mark of winner if there is any
    fun checkWin(): Mark? {

        for (x in 0 until size) for (y in 0 until size) {
            val p = Position(x, y)
            if (get(p) == Mark.BLANK) continue
            if (checkWin(p))
                return get(p)

        }

        return null
    }


    fun print() {
        for (y in 0 until size) {
            print("|\t")
            for (x in 0 until size)
                print("${board[x][y].toString().replace("BLANK", " ")}\t|\t")
            println("\n-------------------------")
        }

    }

}