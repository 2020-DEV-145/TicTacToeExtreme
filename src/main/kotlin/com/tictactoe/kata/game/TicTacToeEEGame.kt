package com.tictactoe.kata.game

class TicTacToeEEGame : TicTacToeEE {

    var currentPlayer: Player = Player.X

    override val gameState: GameState
        get() = GameState(currentPlayer)

}