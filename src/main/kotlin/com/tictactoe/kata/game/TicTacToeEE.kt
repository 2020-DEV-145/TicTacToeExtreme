package com.tictactoe.kata.game

interface TicTacToeEE {
    val rowCount: Int
    val colCount: Int

    val gameState: GameState
    fun play(row: Int, col: Int): Boolean
}