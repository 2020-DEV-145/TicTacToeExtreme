package com.tictactoe.kata.app.startGameScreen

import com.tictactoe.kata.app.gameScreen.GameScope
import com.tictactoe.kata.app.gameScreen.GameView
import tornadofx.*

class StartGameViewModel : ViewModel() {
    var boardSize = BASE_BOARD_SIZE
    var piecesInARowToWin = BASE_PIECES_IN_A_ROW_TO_WIN

    fun startGame(view: View) =
            find<GameView>(GameScope(boardSize, piecesInARowToWin)).also {
                view.replaceWith(it)
            }

    companion object {
        const val BASE_BOARD_SIZE = 3
        const val BASE_PIECES_IN_A_ROW_TO_WIN = 3
    }
}