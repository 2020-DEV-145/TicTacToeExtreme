package com.tictactoe.kata.domain

interface TicTacToeEE {
    val rowCount: Int
    val colCount: Int
    val piecesInARowToWin: Int

    val gameState: GameState
    fun play(row: Int, col: Int): Boolean
}