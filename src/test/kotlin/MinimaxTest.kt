import algorithms.minimax.Minimax
import board.Board
import board.Mark
import board.Position
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MinimaxTest {

    private val algorithm = Minimax


    @Test
    fun testPlay() {
        val board = Board(3)

        board.set(Position(0, 0), Mark.X)
        board.set(Position(1, 1), Mark.X)
        Assertions.assertEquals(Position(2, 2), algorithm.play(board, Mark.O))
        board.clear()

    }

    @Test
    fun blockOpponentWinningMove() {
        val board = Board(3)
        board.set(Position(0, 0), Mark.X)
        board.set(Position(0, 1), Mark.X)
        board.set(Position(1, 0), Mark.O)
        Assertions.assertEquals(Position(0, 2), algorithm.play(board, Mark.O))
        board.clear()
    }


    @Test
    fun chooseWinningMove() {
        val board = Board(3)
        board.set(Position(0, 0), Mark.X)
        board.set(Position(1, 0), Mark.X)
        board.set(Position(1, 1), Mark.O)
        board.set(Position(2, 1), Mark.O)
        Assertions.assertEquals(Position(0, 1), algorithm.play(board, Mark.O))
        board.clear()
    }


    @Test
    fun createForkOpportunity() {
        val board = Board(3)
        board.set(Position(0, 0), Mark.O)
        board.set(Position(2, 2), Mark.O)
        board.set(Position(1, 1), Mark.X)
        println()
        board.print()
        println()
        Assertions.assertEquals(Position(0, 2), algorithm.play(board, Mark.O))
        board.clear()
    }


    @Test
    fun avoidOpponentFork() {
        val board = Board(3)
        board.set(Position(0, 0), Mark.X)
        board.set(Position(2, 2), Mark.X)
        board.set(Position(1, 0), Mark.O)
        Assertions.assertNotEquals(Position(0, 2), algorithm.play(board, Mark.O))
        board.clear()
    }


    @Test
    fun takeEmptyCorner() {
        val board = Board(3)
        board.set(Position(1, 1), Mark.X)
        board.set(Position(0, 1), Mark.O)
        val move = Minimax.play(board, Mark.X)
        Assertions.assertTrue(
            move == Position(0, 0) || move == Position(0, 2) ||
                    move == Position(2, 0) || move == Position(2, 2)
        )
        board.clear()
    }


    @Test
    fun takeEmptySide() {
        val board = Board(3)
        board.set(Position(0, 0), Mark.X)
        board.set(Position(1, 1), Mark.X)
        board.set(Position(2, 2), Mark.O)
        board.set(Position(0, 2), Mark.O)
        val move = Minimax.play(board, Mark.X)
        Assertions.assertTrue(
            move == Position(0, 1) || move == Position(1, 0) ||
                    move == Position(1, 2) || move == Position(2, 1)
        )
        board.clear()
    }


    fun passTests() {
        testPlay()
        blockOpponentWinningMove()
        chooseWinningMove()
        createForkOpportunity()
        avoidOpponentFork()
        takeEmptyCorner()
        takeEmptySide()
    }


}