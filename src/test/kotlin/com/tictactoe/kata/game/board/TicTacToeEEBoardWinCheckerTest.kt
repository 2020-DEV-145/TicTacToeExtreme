package com.tictactoe.kata.game.board

import com.tictactoe.kata.game.Player
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class TicTacToeEEBoardWinCheckerTest {

    @Test
    fun `Player wins with N pieces in a row - horizontally`() {
        val winChecker = TicTacToeEEBoardWinChecker(3)
        val content = listOf(
                listOf(Square(Player.X), Square(Player.O), Square(Player.X)),
                listOf(Square(Player.X), Square(Player.X), Square(Player.X)),
                listOf(Square(Player.O), Square(Player.O), Square(Player.O)
                ))

        assertTrue(winChecker.checkRow(content, 0, 0) == null)
        assertTrue(winChecker.checkRow(content, 1, 0) == Player.X)
        assertTrue(winChecker.checkRow(content, 2, 0) == Player.O)
        assertTrue(winChecker.checkRow(content, 1, 1) == null)
    }

    @Test
    fun `Player wins with N pieces in a row - vertically`() {
        val winChecker = TicTacToeEEBoardWinChecker(3)
        val content = listOf(
                listOf(Square(Player.X), Square(Player.O), Square(Player.X)),
                listOf(Square(Player.X), Square(Player.O), Square(Player.X)),
                listOf(Square(Player.X), Square(Player.O), Square(Player.O)
                ))

        assertTrue(winChecker.checkColumns(content, 0, 0) == Player.X)
        assertTrue(winChecker.checkColumns(content, 0, 1) == Player.O)
        assertTrue(winChecker.checkColumns(content, 0, 2) == null)
        assertTrue(winChecker.checkColumns(content, 1, 0) == null)
        assertTrue(winChecker.checkColumns(content, 2, 0) == null)
        assertTrue(winChecker.checkColumns(content, 1, 1) == null)
    }

    @Test
    fun `Player wins with N pieces in a row - right diagonaly`() {
        val winChecker = TicTacToeEEBoardWinChecker(3)
        val content = listOf(
                listOf(Square(Player.X), Square(Player.O), Square(Player.X)),
                listOf(Square(Player.X), Square(Player.X), Square(Player.X)),
                listOf(Square(Player.X), Square(Player.O), Square(Player.X)
                ))

        assertTrue(winChecker.checkRightDiagonals(content, 0, 0) == Player.X)
        assertTrue(winChecker.checkRightDiagonals(content, 0, 1) == null)
    }

    @Test
    fun `Player wins with N pieces in a row - left diagonaly`() {
        val winChecker = TicTacToeEEBoardWinChecker(3)
        val content = listOf(
                listOf(Square(Player.X), Square(Player.O), Square(Player.O)),
                listOf(Square(Player.X), Square(Player.O), Square(Player.X)),
                listOf(Square(Player.O), Square(Player.O), Square(Player.X)
                ))

        assertTrue(winChecker.checkLeftDiagonals(content, 0, 0) == null)
        assertTrue(winChecker.checkLeftDiagonals(content, 2, 0) == null)
        assertTrue(winChecker.checkLeftDiagonals(content, 0, 2) == Player.O)
    }

    @Test
    fun `Player wins with N pieces in a row -   all orientation`() {
        val winChecker = TicTacToeEEBoardWinChecker(3)
        val content = listOf(
                listOf(Square(Player.X), Square(Player.X), Square(Player.X)),
                listOf(Square(Player.X), Square(Player.O), Square(Player.X)),
                listOf(Square(Player.O), Square(Player.O), Square(Player.O)
                ))

        assertTrue(winChecker.checkSquare(content, 0, 0) == Player.X)
        assertTrue(winChecker.checkSquare(content, 2, 0) == Player.O)
        assertTrue(winChecker.checkSquare(content, 0, 2) == null)
    }

    @Test
    fun `Player wins with N pieces in a row - all mixed`() {
        val winChecker = TicTacToeEEBoardWinChecker(3)
        assertTrue(winChecker.checkForWinner(listOf(
                listOf(Square(Player.X), Square(), Square()),
                listOf(Square(), Square(Player.X), Square()),
                listOf(Square(), Square(), Square())
        )) == null)


        assertTrue(winChecker.checkForWinner(listOf(
                listOf(Square(Player.X), Square(), Square()),
                listOf(Square(), Square(Player.X), Square()),
                listOf(Square(), Square(), Square(Player.X))
        )) == Player.X)

        assertTrue(winChecker.checkForWinner(listOf(
                listOf(Square(), Square(), Square(Player.X)),
                listOf(Square(), Square(), Square(Player.X)),
                listOf(Square(), Square(), Square(Player.X))
        )) == Player.X)

        assertTrue(winChecker.checkForWinner(listOf(
                listOf(Square(), Square(), Square(Player.X)),
                listOf(Square(), Square(Player.X), Square()),
                listOf(Square(Player.X), Square(), Square())
        )) == Player.X)

        assertTrue(winChecker.checkForWinner(listOf(
                listOf(Square(), Square(), Square(Player.X)),
                listOf(Square(), Square(), Square()),
                listOf(Square(Player.X), Square(), Square())
        )) == null)
    }

    @Test
    fun `Player needs the right total of pieces in a row`() {
        val winChecker = TicTacToeEEBoardWinChecker(4)
        assertTrue(winChecker.checkForWinner(listOf(
                listOf(Square(Player.X), Square(), Square()),
                listOf(Square(Player.X), Square(), Square()),
                listOf(Square(Player.X), Square(), Square()),
                listOf(Square(), Square(), Square())
        )) == null)
        assertTrue(winChecker.checkForWinner(listOf(
                listOf(Square(Player.X), Square(), Square()),
                listOf(Square(Player.X), Square(), Square()),
                listOf(Square(Player.X), Square(), Square()),
                listOf(Square(Player.X), Square(), Square())
        )) == Player.X)

        assertTrue(winChecker.checkForWinner(listOf(
                listOf(Square(), Square(), Square(), Square()),
                listOf(Square(), Square(), Square(), Square()),
                listOf(Square(), Square(), Square(), Square()),
                listOf(Square(Player.X), Square(Player.X), Square(), Square(Player.X))
        )) == null)

        assertTrue(winChecker.checkForWinner(listOf(
                listOf(Square(), Square(), Square(), Square()),
                listOf(Square(), Square(), Square(), Square()),
                listOf(Square(), Square(), Square(), Square()),
                listOf(Square(Player.X), Square(Player.X), Square(Player.X), Square(Player.X))
        )) == Player.X)
    }

}