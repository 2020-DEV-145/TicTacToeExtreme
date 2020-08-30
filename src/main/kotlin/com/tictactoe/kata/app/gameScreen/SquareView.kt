package com.tictactoe.kata.app.gameScreen

import tornadofx.View
import tornadofx.action
import tornadofx.button

class SquareView(
        private val row: Int,
        private val col: Int,
        private val label: String,
        private val listener: Listener? = null
) : View() {
    override val root = button().apply {
        text = label
        style += "-fx-background-color:${when (text) {
            "X" -> X_COLOR
            "O" -> O_COLOR
            else -> NO_PIECE_COLOR
        }};"
        style += ("-fx-border-color: #000000; -fx-border-width: 5px;");
        setMinSize(WIDTH, HEIGHT)
        action { listener?.onClicked(col, row) }
    }
    interface Listener {
        fun onClicked(row: Int, col: Int)
    }

    companion object {
        const val WIDTH = 100.0
        const val HEIGHT = 100.0
        const val X_COLOR = "#ff0000"
        const val O_COLOR = "#00ff00"
        const val NO_PIECE_COLOR = "#ffffff"
    }
}