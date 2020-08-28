package com.tictactoe.kata.game.board

data class Square<T>(var occupiedBy: T? = null) {
    val isOccupied: Boolean
        get() = occupiedBy != null
}