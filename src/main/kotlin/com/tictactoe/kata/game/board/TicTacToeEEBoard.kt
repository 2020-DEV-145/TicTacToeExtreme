package com.tictactoe.kata.game.board

import com.tictactoe.kata.game.Player

class TicTacToeEEBoard(override val rowCount: Int, override val colCount: Int) : Board<Player> {

    private val content = Array(rowCount) { Array(colCount) { Square<Player>() } }

    override fun playOnSquare(row: Int, col: Int, piece: Player): Boolean =
            if (content.size > row && content[row].size > col && !content[row][col].isOccupied) {
                content[row][col].occupiedBy = piece
                true
            } else {
                false
            }

    override val isFull: Boolean
        get() = content.all { row -> row.all { it.isOccupied } }
}