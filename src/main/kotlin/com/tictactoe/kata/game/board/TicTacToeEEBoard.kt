package com.tictactoe.kata.game.board

import com.tictactoe.kata.game.Player

class TicTacToeEEBoard(override val rowCount: Int, override val colCount: Int, piecesInARowToWin: Int) : Board<Player> {

    private val content = List(rowCount) { List(colCount) { Square<Player>() } }
    private val winChecker = TicTacToeEEBoardWinChecker(piecesInARowToWin)
    private var gameWinner: Player? = null

    override val winner
        get() = if (gameWinner == null) winChecker.checkForWinner(content)?.also {
            gameWinner = it
        } else {
            gameWinner
        }

    override fun playOnSquare(row: Int, col: Int, piece: Player): Boolean =
            if (winner == null && content.size > row && content[row].size > col && !content[row][col].isOccupied) {
                content[row][col].occupiedBy = piece
                true
            } else {
                false
            }

    override val isFull: Boolean
        get() = content.all { row -> row.all { it.isOccupied } }

    override fun getBoardRepresentation(): List<List<String>> = content.map { row ->
        row.map { if (!it.isOccupied) "" else it.occupiedBy.toString() }
    }
}