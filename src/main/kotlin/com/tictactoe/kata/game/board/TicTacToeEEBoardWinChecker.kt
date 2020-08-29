package com.tictactoe.kata.game.board

import com.tictactoe.kata.game.Player

class TicTacToeEEBoardWinChecker(private val occupiedSquareInARowToWin: Int) {

    fun checkForWinner(content: Array<Array<Square<Player>>>): Player? {
        content.forEachIndexed { rowIndex, columns ->
            columns.forEachIndexed { colIndex, _ ->
                checkSquare(content, rowIndex, colIndex)?.let {
                    return it
                }
            }
        }
        return null
    }

    fun checkSquare(content: Array<Array<Square<Player>>>, row: Int, col: Int): Player? {
        var victoryState = checkRow(content, row, col)
        if (victoryState != null) return victoryState
        victoryState = checkColumns(content, row, col)
        if (victoryState != null) return victoryState
        victoryState = checkRightDiagonals(content, row, col)
        if (victoryState != null) return victoryState
        return checkLeftDiagonals(content, row, col)
    }


    fun checkRow(content: Array<Array<Square<Player>>>, row: Int, col: Int): Player? {
        if (isInBoardRange(content, row, col, 0, occupiedSquareInARowToWin)) {
            val firstSquare = content[row][col]
            if (!firstSquare.isOccupied) return null
            for (deltaCol in 1 until occupiedSquareInARowToWin) {
                if (firstSquare.occupiedBy != content[row][col + deltaCol].occupiedBy) return null
            }
            return firstSquare.occupiedBy
        }
        return null
    }

    fun checkColumns(content: Array<Array<Square<Player>>>, row: Int, col: Int): Player? {
        if (isInBoardRange(content, row, col, occupiedSquareInARowToWin, 0)) {
            val firstSquare = content[row][col]
            if (!firstSquare.isOccupied) return null
            for (nextRow in 1 until occupiedSquareInARowToWin) {
                if (firstSquare.occupiedBy != content[row + nextRow][col].occupiedBy) return null
            }
            return firstSquare.occupiedBy
        }
        return null
    }

    fun checkRightDiagonals(content: Array<Array<Square<Player>>>, row: Int, col: Int): Player? {
        if (isInBoardRange(content, row, col, occupiedSquareInARowToWin, occupiedSquareInARowToWin)) {
            val firstSquare = content[row][col]
            if (!firstSquare.isOccupied) return null
            for (nextIndex in 1 until occupiedSquareInARowToWin) {
                if (firstSquare.occupiedBy != content[row + nextIndex][col + nextIndex].occupiedBy) return null
            }
            return firstSquare.occupiedBy
        }
        return null
    }

    fun checkLeftDiagonals(content: Array<Array<Square<Player>>>, row: Int, col: Int): Player? {
        if (isInBoardRange(content, row, col, occupiedSquareInARowToWin, -occupiedSquareInARowToWin)) {
            val firstSquare = content[row][col]
            if (!firstSquare.isOccupied) return null
            for (nextIndex in 1 until occupiedSquareInARowToWin) {
                if (firstSquare.occupiedBy != content[row + nextIndex][col - nextIndex].occupiedBy) return null
            }
            return firstSquare.occupiedBy
        }
        return null
    }

    private fun isInBoardRange(content: Array<Array<Square<Player>>>, row: Int, col: Int, rowDelta: Int, colDelta: Int) =
            content.size >= (row + rowDelta) && content[row].size >= col + colDelta && row + 1 + rowDelta >= 0 && col + 1 + colDelta >= 0
}