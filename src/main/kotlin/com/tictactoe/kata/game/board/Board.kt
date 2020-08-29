package com.tictactoe.kata.game.board

interface Board<T> {
    val rowCount: Int
    val colCount: Int
    val isFull: Boolean
    val winner: T?
    fun playOnSquare(row: Int, col: Int, piece: T): Boolean
    fun getBoardRepresentation(): List<List<String>>
}
