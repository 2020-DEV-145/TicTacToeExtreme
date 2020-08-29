package com.tictactoe.kata.app.startGameScreen

import com.tictactoe.kata.app.Styles
import javafx.beans.property.SimpleIntegerProperty
import tornadofx.*

class StartGameView : View("Tic Tac Toe - Extreme Edition") {

    private val boardSize = SimpleIntegerProperty()
    private val piecesInARowToWin = SimpleIntegerProperty()
    private val vm: StartGameViewModel by inject()

    override val root = vbox {
        label(title) {
            addClass(Styles.heading)
        }
        form {
            fieldset("Customize your game") {
                field("Board Size") {
                    combobox(boardSize, values = listOf(3, 4, 5, 6, 7, 8, 9)).apply {
                        value = vm.boardSize
                    }
                }
                field("Square In a row to Win") {
                    combobox(piecesInARowToWin, values = listOf(3, 4, 5, 6, 7, 8, 9)).apply {
                        value = vm.piecesInARowToWin
                    }
                }
            }
            button {
                text = "Play!"
                action {
                    vm.startGame(this@StartGameView)
                }
            }
        }
    }

    init {
        boardSize.onChange {
            vm.boardSize = it
        }
        piecesInARowToWin.onChange {
            vm.piecesInARowToWin = it
        }
    }

}