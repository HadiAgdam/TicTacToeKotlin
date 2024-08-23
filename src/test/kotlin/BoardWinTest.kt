import board.Board
import board.Mark
import board.Position
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BoardWinTest {
    
    @Test
    fun horizontalTest() {
        val b = Board(3)
        
        b.set(Position(0, 0), Mark.X)
        b.set(Position(1, 0), Mark.X)
        b.set(Position(2, 0), Mark.X)

        Assertions.assertEquals(Mark.X, b.checkWin())

        b.set(Position(2, 0), Mark.BLANK)
        Assertions.assertNull(b.checkWin())
    }
    
    
    @Test
    fun verticalTest() {
        val b = Board(3)

        b.set(Position(0, 0), Mark.X)
        b.set(Position(0, 1), Mark.X)
        b.set(Position(0, 2), Mark.X)

        Assertions.assertEquals(Mark.X, b.checkWin())
    }
    
    
    @Test
    fun diagonalTest1(){
        val b = Board(3)

        b.set(Position(2, 0), Mark.X)
        b.set(Position(1, 1), Mark.X)
        b.set(Position(0, 2), Mark.X)

        Assertions.assertEquals(Mark.X, b.checkWin())
    }
}