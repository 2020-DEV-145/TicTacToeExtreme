package com.tictactoe.kata.domain.board

import com.tictactoe.kata.domain.Player
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test


internal class TicTacToeEEBoardTest {

    @Test
    fun `The Tic Tac Toe Board cannot contains 2 pieces on the same square`() {
        val board: Board<Player> = TicTacToeEEBoard(3, 3, 3)
       assertTrue(board.playOnSquare(0, 0, Player.X))
       assertTrue(!board.playOnSquare(0, 0, Player.X))
    }

    @Test
    fun `The Tic Tac Toe Board is full when all squares are played`() {
        val board: Board<Player> = TicTacToeEEBoard(2, 2, 3)
       assertTrue(board.playOnSquare(0, 0, Player.X))
       assertTrue(board.playOnSquare(0, 1, Player.X))
       assertTrue(board.playOnSquare(1, 0, Player.X))
       assertTrue(!board.isFull)
       assertTrue(board.playOnSquare(1, 1, Player.X))
       assertTrue(board.isFull)
    }

    @Test
    fun `When the board is full no more pieces can be played`() {
        val board: Board<Player> = TicTacToeEEBoard(2, 2, 3)
       assertTrue(board.playOnSquare(0, 0, Player.X))
       assertTrue(board.playOnSquare(0, 1, Player.O))
       assertTrue(board.playOnSquare(1, 0, Player.O))
       assertTrue(board.playOnSquare(1, 1, Player.X))
       assertTrue(board.isFull)
       assertTrue(!board.playOnSquare(0, 0, Player.X))
    }

    @Test
    fun `When someone has win, no more pieces can be played`() {
        val board: Board<Player> = TicTacToeEEBoard(3, 3, 3)
       assertTrue(board.playOnSquare(0, 0, Player.X))
       assertTrue(board.playOnSquare(0, 1, Player.X))
       assertTrue(board.playOnSquare(0, 2, Player.X))
       assertTrue(!board.playOnSquare(1, 1, Player.O))
    }

    @Test
    fun `The Tic Tac Toe Board representation is the same as the content one`() {
        val board: Board<Player> = TicTacToeEEBoard(3, 3, 3)
       assertTrue(board.playOnSquare(0, 0, Player.X))
       assertTrue(board.playOnSquare(0, 1, Player.O))
       assertTrue(board.playOnSquare(0, 2, Player.X))
       assertTrue(board.getBoardRepresentation() ==
                listOf(
                        listOf("X", "O", "X"),
                        listOf("", "", ""),
                        listOf("", "", "")
                ))

       assertTrue(board.playOnSquare(1, 0, Player.O))
       assertTrue(board.playOnSquare(1, 1, Player.X))
       assertTrue(board.playOnSquare(1, 2, Player.O))
       assertTrue(board.getBoardRepresentation() ==
                listOf(
                        listOf("X", "O", "X"),
                        listOf("O", "X", "O"),
                        listOf("", "", "")
                ))
       assertTrue(board.playOnSquare(2, 0, Player.O))
       assertTrue(board.playOnSquare(2, 1, Player.X))
       assertTrue(board.playOnSquare(2, 2, Player.O))
       assertTrue(board.getBoardRepresentation() ==
                listOf(
                        listOf("X", "O", "X"),
                        listOf("O", "X", "O"),
                        listOf("O", "X", "O")
                ))
    }
}