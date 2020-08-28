package com.tictactoe.kata.game

data class GameState(
        val currentPlayer: Player,
        val state: PlayingState
)

enum class PlayingState {
    PLAYING,
    OVER
}