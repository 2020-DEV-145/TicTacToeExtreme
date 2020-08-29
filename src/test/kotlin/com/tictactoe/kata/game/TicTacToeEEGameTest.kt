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

    @Test
    fun `Players alternate placing X-O until someone wins`() {
        val game: TicTacToeEE = TicTacToeEEGame(3, 3)
        game.play(0, 0)
        game.play(1, 0)
        game.play(0, 1)
        game.play(1, 1)
        assert(game.gameState.state == PlayingState.PLAYING)
        game.play(0, 2)
        assert(game.gameState.state == PlayingState.OVER)
    }

    @Test
    fun `If a player is able to draw B Xs or three Os in a row, that player wins`() {
        val game: TicTacToeEE = TicTacToeEEGame(3, 3)
        game.play(0, 0)
        game.play(1, 0)
        game.play(0, 1)
        game.play(1, 1)
        assert(game.gameState.state == PlayingState.PLAYING)
        assert(game.gameState.winner == null)
        game.play(0, 2)
        assert(game.gameState.state == PlayingState.OVER)
        assert(game.gameState.winner == Player.X)
    }

    @Test
    fun ` If all nine squares are filled and neither player has N in a row, the game is a draw`() {
        val game: TicTacToeEE = TicTacToeEEGame(3, 3)
        game.play(0, 0)
        game.play(0, 1)
        game.play(0, 2)
        game.play(1, 0)
        game.play(1, 2)
        game.play(1, 1)
        game.play(2, 0)
        game.play(2, 2)
        assert(game.gameState.state == PlayingState.PLAYING)
        assert(game.gameState.winner == null)
        game.play(2, 1)
        assert(game.gameState.isDraw)
        assert(game.gameState.winner == null)
        assert(game.gameState.state == PlayingState.OVER)
    }
}