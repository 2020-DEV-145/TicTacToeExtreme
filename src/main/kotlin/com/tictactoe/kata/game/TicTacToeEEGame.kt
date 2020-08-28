package com.tictactoe.kata.game

import com.tictactoe.kata.game.board.Board
import com.tictactoe.kata.game.board.TicTacToeEEBoard

class TicTacToeEEGame(override val rowCount: Int = BASE_SIZE, override val colCount: Int = BASE_SIZE) : TicTacToeEE {

    var currentPlayer: Player = Player.X
    private val board: Board<Player> = TicTacToeEEBoard(rowCount, colCount)

    override val gameState: GameState
        get() = GameState(currentPlayer)

    override fun play(row: Int, col: Int) = if (board.playOnSquare(row, col, currentPlayer)) {
        updateCurrentPlayer()
        true
    } else {
        false
    }

    private fun updateCurrentPlayer() {
        currentPlayer = when (currentPlayer) {
            Player.X -> Player.O
            Player.O -> Player.X
        }
    }

    companion object {
        const val BASE_SIZE = 3
    }
}