package com.tictactoe.kata.game.board

interface Board<T> {
    val rowCount: Int
    val colCount: Int
    val isFull: Boolean
    fun playOnSquare(row: Int, col: Int, piece: T): Boolean
}