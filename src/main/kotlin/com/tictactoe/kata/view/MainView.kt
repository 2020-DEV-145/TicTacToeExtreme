package com.tictactoe.kata.view

import com.tictactoe.kata.app.Styles
import tornadofx.*

class MainView : View("TicTacToe - Extreme Edition") {
    override val root = hbox {
        label(title) {
            addClass(Styles.heading)
        }
    }
}