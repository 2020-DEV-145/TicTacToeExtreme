package com.tictactoe.kata.game

class TicTacToeEEGame : TicTacToeEE {

    var currentPlayer: Player = Player.X

    override val gameState: GameState
        get() = GameState(currentPlayer)

    override fun play() {
        updateCurrentPlayer()
    }

    private fun updateCurrentPlayer() {
        currentPlayer = when (currentPlayer) {
            Player.X -> Player.O
            Player.O -> Player.X
        }
    }

}