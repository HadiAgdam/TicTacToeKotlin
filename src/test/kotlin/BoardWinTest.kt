import board.Board
import board.Mark
import board.Position
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BoardWinTest {

    @Test
    fun horizontalTest() {
        val b = Board(3)

        for (i in 0 until 3) {

            b.set(Position(0, i), Mark.X)
            Assertions.assertEquals(null, b.checkWin())

            b.set(Position(1, i), Mark.X)
            Assertions.assertEquals(null, b.checkWin())


            b.set(Position(2, i), Mark.X)
            Assertions.assertEquals(Mark.X, b.checkWin())
            b.clear()
        }
    }


    @Test
    fun verticalTest() {
        val b = Board(3)

        for (i in 0 until 3) {
            b.set(Position(i, 0), Mark.X)
            Assertions.assertEquals(null, b.checkWin())

            b.set(Position(i, 1), Mark.X)
            Assertions.assertEquals(null, b.checkWin())


            b.set(Position(i, 2), Mark.X)
            Assertions.assertEquals(Mark.X, b.checkWin())
            b.clear()
        }
    }


    @Test
    fun diagonalTest1() {
        val b = Board(3)

        b.set(Position(2, 0), Mark.X)
        b.set(Position(1, 1), Mark.X)
        b.set(Position(0, 2), Mark.X)

        Assertions.assertEquals(Mark.X, b.checkWin())
    }
}