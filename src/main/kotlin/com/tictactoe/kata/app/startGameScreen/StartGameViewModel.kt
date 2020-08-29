package com.tictactoe.kata.app.startGameScreen

import com.tictactoe.kata.app.gameScreen.GameScope
import com.tictactoe.kata.app.gameScreen.GameView
import tornadofx.*

class StartGameViewModel : ViewModel() {
    var boardSize = 3
    var piecesInARowToWin = 3

    fun startGame(view: View) {
        val boardView = find<GameView>(GameScope(boardSize, piecesInARowToWin))
        view.replaceWith(boardView)
    }
}