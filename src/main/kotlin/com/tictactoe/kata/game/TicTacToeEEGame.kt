package com.tictactoe.kata.game

import com.tictactoe.kata.game.board.Board
import com.tictactoe.kata.game.board.TicTacToeEEBoard

class TicTacToeEEGame(
        override val rowCount: Int = BASE_SIZE,
        override val colCount: Int = BASE_SIZE,
        override val piecesInARowToWin: Int = BASE_PIECES_IN_A_ROW_TO_WIN
) : TicTacToeEE {

    private val board: Board<Player> = TicTacToeEEBoard(rowCount, colCount, piecesInARowToWin)

    override val gameState: GameState
        get() = GameState(currentPlayer,
                if (board.isFull || board.winner != null) PlayingState.OVER else PlayingState.PLAYING,
                board.winner)
    var currentPlayer: Player = Player.X


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
        const val BASE_PIECES_IN_A_ROW_TO_WIN = 3
    }
}