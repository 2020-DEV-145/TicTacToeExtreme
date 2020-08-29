package com.tictactoe.kata.game

data class GameState(
        val currentPlayer: Player,
        val state: PlayingState,
        val winner: Player?,
        val boardState: List<List<String>>
) {
    val isDraw: Boolean
        get() = state == PlayingState.OVER && winner == null
}

enum class PlayingState {
    PLAYING,
    OVER
}