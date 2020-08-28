package com.tictactoe.kata

import com.tictactoe.kata.game.Player
import com.tictactoe.kata.game.TicTacToeEE
import com.tictactoe.kata.game.TicTacToeEEGame
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
        game.play()
        assert(game.gameState.currentPlayer == Player.O)
    }

    @Test
    fun `X-O alternate turns`() {
        val game: TicTacToeEE = TicTacToeEEGame()
        assert(game.gameState.currentPlayer == Player.X)
        game.play()
        assert(game.gameState.currentPlayer == Player.O)
        game.play()
        assert(game.gameState.currentPlayer == Player.X)
    }
}