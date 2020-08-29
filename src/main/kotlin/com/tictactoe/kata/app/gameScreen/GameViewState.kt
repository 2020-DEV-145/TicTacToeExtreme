package com.tictactoe.kata.app.gameScreen

data class GameViewState(
        val currentPlayer: String,
        val board: List<List<String>>,
        val gameState: GameState,
        val winner: String
) {
    val isDraw: Boolean
        get() = gameState == GameState.OVER && winner.isBlank()

    enum class GameState {
        PLAYING,
        OVER
    }
}