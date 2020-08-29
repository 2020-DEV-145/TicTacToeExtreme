package com.tictactoe.kata.app.gameScreen

import com.tictactoe.kata.app.Styles
import tornadofx.*

class GameView : View("Tic Tac Toe - Extreme Edition") {
    override val scope = super.scope as GameScope
    private val vm: GameViewModel by inject()

    override val root = vbox {
        label(title) {
            addClass(Styles.heading)
        }
        label(scope.boardSize.toString())
        label(scope.occupiedSquareInARowToWin.toString())
    }

}