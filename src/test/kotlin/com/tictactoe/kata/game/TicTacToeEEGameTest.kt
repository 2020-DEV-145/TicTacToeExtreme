package com.tictactoe.kata.game

import org.junit.jupiter.api.Test

internal class TicTacToeEEGameTest {

    @Test
    fun `X always goes first`() {
        val game: TicTacToeEE = TicTacToeEEGame()
        assert(game.gameState.currentPlayer == Player.X)
    }

    @Test
    fun `O plays seconds`() {
        val game: TicTacToeEE = TicTacToeEEGame()
        game.play(0, 0)
        assert(game.gameState.currentPlayer == Player.O)
    }

    @Test
    fun `X-O alternate turns`() {
        val game: TicTacToeEE = TicTacToeEEGame()
        assert(game.gameState.currentPlayer == Player.X)
        game.play(0, 0)
        assert(game.gameState.currentPlayer == Player.O)
        game.play(0, 1)
        assert(game.gameState.currentPlayer == Player.X)
    }

    @Test
    fun `Players cannot play on a played position`() {
        val game: TicTacToeEE = TicTacToeEEGame()
        assert(game.gameState.currentPlayer == Player.X)
        assert(game.play(0, 0))
        assert(game.gameState.currentPlayer == Player.O)
        assert(!game.play(0, 0))
        assert(game.gameState.currentPlayer == Player.O)
        assert(game.play(0, 1))
        assert(game.gameState.currentPlayer == Player.X)
    }

    @Test
    fun `Players alternate placing X-O until the board is full`() {
        val game: TicTacToeEE = TicTacToeEEGame(2, 2)
        game.play(0, 0)
        game.play(0, 1)
        game.play(1, 0)
        assert(game.gameState.state == PlayingState.PLAYING)
        game.play(1, 1)
        assert(game.gameState.state == PlayingState.OVER)
    }
}