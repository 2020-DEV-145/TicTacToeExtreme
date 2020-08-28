package com.tictactoe.kata.game.board

import com.tictactoe.kata.game.Player
import org.junit.jupiter.api.Test


internal class TicTacToeEEBoardTest {

    @Test
    fun `The Tic Tac Toe Board cannot contains 2 pieces on the same square`() {
        val board: Board<Player> = TicTacToeEEBoard(3, 3)
        assert(board.playOnSquare(0, 0, Player.X))
        assert(!board.playOnSquare(0, 0, Player.X))
    }

    @Test
    fun `The Tic Tac Toe Board is full when all squares are played`() {
        val board: Board<Player> = TicTacToeEEBoard(2, 2)
        assert(board.playOnSquare(0, 0, Player.X))
        assert(board.playOnSquare(0, 1, Player.X))
        assert(board.playOnSquare(1, 0, Player.X))
        assert(!board.isFull)
        assert(board.playOnSquare(1, 1, Player.X))
        assert(board.isFull)
    }
}