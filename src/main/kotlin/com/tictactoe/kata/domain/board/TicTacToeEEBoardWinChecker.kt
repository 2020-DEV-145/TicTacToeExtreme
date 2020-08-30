package com.tictactoe.kata.domain.board

import com.tictactoe.kata.domain.Player

class TicTacToeEEBoardWinChecker(private val occupiedSquareInARowToWin: Int) {

    fun checkForWinner(content: List<List<Square<Player>>>): Player? {
        content.forEachIndexed { rowIndex, columns ->
            columns.forEachIndexed { colIndex, _ ->
                checkSquare(content, rowIndex, colIndex)?.let {
                    return it
                }
            }
        }
        return null
    }

    fun checkSquare(content: List<List<Square<Player>>>, row: Int, col: Int): Player? {
        var victoryState = checkRow(content, row, col)
        if (victoryState != null) return victoryState
        victoryState = checkColumns(content, row, col)
        if (victoryState != null) return victoryState
        victoryState = checkRightDiagonals(content, row, col)
        if (victoryState != null) return victoryState
        return checkLeftDiagonals(content, row, col)
    }


    fun checkRow(content: List<List<Square<Player>>>, row: Int, col: Int): Player? {
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

    fun checkColumns(content: List<List<Square<Player>>>, row: Int, col: Int): Player? {
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

    fun checkRightDiagonals(content: List<List<Square<Player>>>, row: Int, col: Int): Player? {
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

    fun checkLeftDiagonals(content: List<List<Square<Player>>>, row: Int, col: Int): Player? {
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

    private fun isInBoardRange(content: List<List<Square<Player>>>, row: Int, col: Int, rowDelta: Int, colDelta: Int) =
            content.size >= (row + rowDelta) && content[row].size >= col + colDelta && row + 1 + rowDelta >= 0 && col + 1 + colDelta >= 0
}