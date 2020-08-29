package com.tictactoe.kata.game.board

import com.tictactoe.kata.game.Player
import org.junit.jupiter.api.Test


internal class TicTacToeEEBoardTest {

    @Test
    fun `The Tic Tac Toe Board cannot contains 2 pieces on the same square`() {
        val board: Board<Player> = TicTacToeEEBoard(3, 3, 3)
        assert(board.playOnSquare(0, 0, Player.X))
        assert(!board.playOnSquare(0, 0, Player.X))
    }

    @Test
    fun `The Tic Tac Toe Board is full when all squares are played`() {
        val board: Board<Player> = TicTacToeEEBoard(2, 2, 3)
        assert(board.playOnSquare(0, 0, Player.X))
        assert(board.playOnSquare(0, 1, Player.X))
        assert(board.playOnSquare(1, 0, Player.X))
        assert(!board.isFull)
        assert(board.playOnSquare(1, 1, Player.X))
        assert(board.isFull)
    }

    @Test
    fun `When the board is full no more pieces can be played`() {
        val board: Board<Player> = TicTacToeEEBoard(2, 2, 3)
        assert(board.playOnSquare(0, 0, Player.X))
        assert(board.playOnSquare(0, 1, Player.O))
        assert(board.playOnSquare(1, 0, Player.O))
        assert(board.playOnSquare(1, 1, Player.X))
        assert(board.isFull)
        assert(!board.playOnSquare(0, 0, Player.X))
    }

    @Test
    fun `When someone has win, no more pieces can be played`() {
        val board: Board<Player> = TicTacToeEEBoard(3, 3, 3)
        assert(board.playOnSquare(0, 0, Player.X))
        assert(board.playOnSquare(0, 1, Player.X))
        assert(board.playOnSquare(0, 2, Player.X))
        assert(!board.playOnSquare(1, 1, Player.O))
    }

    @Test
    fun `The Tic Tac Toe Board representation is the same as the content one`() {
        val board: Board<Player> = TicTacToeEEBoard(3, 3, 3)
        assert(board.playOnSquare(0, 0, Player.X))
        assert(board.playOnSquare(0, 1, Player.O))
        assert(board.playOnSquare(0, 2, Player.X))
        assert(board.getBoardRepresentation() ==
                listOf(
                        listOf("X", "O", "X"),
                        listOf("", "", ""),
                        listOf("", "", "")
                ))

        assert(board.playOnSquare(1, 0, Player.O))
        assert(board.playOnSquare(1, 1, Player.X))
        assert(board.playOnSquare(1, 2, Player.O))
        assert(board.getBoardRepresentation() ==
                listOf(
                        listOf("X", "O", "X"),
                        listOf("O", "X", "O"),
                        listOf("", "", "")
                ))
        assert(board.playOnSquare(2, 0, Player.O))
        assert(board.playOnSquare(2, 1, Player.X))
        assert(board.playOnSquare(2, 2, Player.O))
        assert(board.getBoardRepresentation() ==
                listOf(
                        listOf("X", "O", "X"),
                        listOf("O", "X", "O"),
                        listOf("O", "X", "O")
                ))

    }
}