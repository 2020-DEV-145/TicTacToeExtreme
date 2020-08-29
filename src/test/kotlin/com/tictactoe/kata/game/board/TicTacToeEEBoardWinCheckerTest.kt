package com.tictactoe.kata.game.board

import com.tictactoe.kata.game.Player
import org.junit.jupiter.api.Test

internal class TicTacToeEEBoardWinCheckerTest {

    @Test
    fun `Player wins with N pieces in a row - horizontally`() {
        val winChecker = TicTacToeEEBoardWinChecker(3)
        val content = arrayOf(
                arrayOf(Square(Player.X), Square(Player.O), Square(Player.X)),
                arrayOf(Square(Player.X), Square(Player.X), Square(Player.X)),
                arrayOf(Square(Player.O), Square(Player.O), Square(Player.O)
                ))

        assert(winChecker.checkRow(content, 0, 0) == null)
        assert(winChecker.checkRow(content, 1, 0) == Player.X)
        assert(winChecker.checkRow(content, 2, 0) == Player.O)
        assert(winChecker.checkRow(content, 1, 1) == null)
    }

    @Test
    fun `Player wins with N pieces in a row - vertically`() {
        val winChecker = TicTacToeEEBoardWinChecker(3)
        val content = arrayOf(
                arrayOf(Square(Player.X), Square(Player.O), Square(Player.X)),
                arrayOf(Square(Player.X), Square(Player.O), Square(Player.X)),
                arrayOf(Square(Player.X), Square(Player.O), Square(Player.O)
                ))

        assert(winChecker.checkColumns(content, 0, 0) == Player.X)
        assert(winChecker.checkColumns(content, 0, 1) == Player.O)
        assert(winChecker.checkColumns(content, 0, 2) == null)
        assert(winChecker.checkColumns(content, 1, 0) == null)
        assert(winChecker.checkColumns(content, 2, 0) == null)
        assert(winChecker.checkColumns(content, 1, 1) == null)
    }

    @Test
    fun `Player wins with N pieces in a row - right diagonaly`() {
        val winChecker = TicTacToeEEBoardWinChecker(3)
        val content = arrayOf(
                arrayOf(Square(Player.X), Square(Player.O), Square(Player.X)),
                arrayOf(Square(Player.X), Square(Player.X), Square(Player.X)),
                arrayOf(Square(Player.X), Square(Player.O), Square(Player.X)
                ))

        assert(winChecker.checkRightDiagonals(content, 0, 0) == Player.X)
        assert(winChecker.checkRightDiagonals(content, 0, 1) == null)
    }

    @Test
    fun `Player wins with N pieces in a row - left diagonaly`() {
        val winChecker = TicTacToeEEBoardWinChecker(3)
        val content = arrayOf(
                arrayOf(Square(Player.X), Square(Player.O), Square(Player.O)),
                arrayOf(Square(Player.X), Square(Player.O), Square(Player.X)),
                arrayOf(Square(Player.O), Square(Player.O), Square(Player.X)
                ))

        assert(winChecker.checkLeftDiagonals(content, 0, 0) == null)
        assert(winChecker.checkLeftDiagonals(content, 2, 0) == null)
        assert(winChecker.checkLeftDiagonals(content, 0, 2) == Player.O)
    }

    @Test
    fun `Player wins with N pieces in a row - all orientation`() {
        val winChecker = TicTacToeEEBoardWinChecker(3)
        val content = arrayOf(
                arrayOf(Square(Player.X), Square(Player.X), Square(Player.X)),
                arrayOf(Square(Player.X), Square(Player.O), Square(Player.X)),
                arrayOf(Square(Player.O), Square(Player.O), Square(Player.O)
                ))

        assert(winChecker.checkSquare(content, 0, 0) == Player.X)
        assert(winChecker.checkSquare(content, 2, 0) == Player.O)
        assert(winChecker.checkSquare(content, 0, 2) == null)
    }

    @Test
    fun `Player wins with N pieces in a row - all mixed`() {
        val winChecker = TicTacToeEEBoardWinChecker(3)
        assert(winChecker.checkForWinner(arrayOf(
                arrayOf(Square(Player.X), Square(), Square()),
                arrayOf(Square(), Square(Player.X), Square()),
                arrayOf(Square(), Square(), Square())
        )) == null)


        assert(winChecker.checkForWinner(arrayOf(
                arrayOf(Square(Player.X), Square(), Square()),
                arrayOf(Square(), Square(Player.X), Square()),
                arrayOf(Square(), Square(), Square(Player.X))
        )) == Player.X)

        assert(winChecker.checkForWinner(arrayOf(
                arrayOf(Square(), Square(), Square(Player.X)),
                arrayOf(Square(), Square(), Square(Player.X)),
                arrayOf(Square(), Square(), Square(Player.X))
        )) == Player.X)

        assert(winChecker.checkForWinner(arrayOf(
                arrayOf(Square(), Square(), Square(Player.X)),
                arrayOf(Square(), Square(Player.X), Square()),
                arrayOf(Square(Player.X), Square(), Square())
        )) == Player.X)

        assert(winChecker.checkForWinner(arrayOf(
                arrayOf(Square(), Square(), Square(Player.X)),
                arrayOf(Square(), Square(), Square()),
                arrayOf(Square(Player.X), Square(), Square())
        )) == null)
    }

    @Test
    fun `Player needs the right total of pieces in a row`() {
        val winChecker = TicTacToeEEBoardWinChecker(4)
        assert(winChecker.checkForWinner(arrayOf(
                arrayOf(Square(Player.X), Square(), Square()),
                arrayOf(Square(Player.X), Square(), Square()),
                arrayOf(Square(Player.X), Square(), Square()),
                arrayOf(Square(), Square(), Square())
        )) == null)
        assert(winChecker.checkForWinner(arrayOf(
                arrayOf(Square(Player.X), Square(), Square()),
                arrayOf(Square(Player.X), Square(), Square()),
                arrayOf(Square(Player.X), Square(), Square()),
                arrayOf(Square(Player.X), Square(), Square())
        )) == Player.X)

        assert(winChecker.checkForWinner(arrayOf(
                arrayOf(Square(), Square(), Square(), Square()),
                arrayOf(Square(), Square(), Square(), Square()),
                arrayOf(Square(), Square(), Square(), Square()),
                arrayOf(Square(Player.X), Square(Player.X), Square(), Square(Player.X))
        )) == null)

        assert(winChecker.checkForWinner(arrayOf(
                arrayOf(Square(), Square(), Square(), Square()),
                arrayOf(Square(), Square(), Square(), Square()),
                arrayOf(Square(), Square(), Square(), Square()),
                arrayOf(Square(Player.X), Square(Player.X), Square(Player.X), Square(Player.X))
        )) == Player.X)
    }

}