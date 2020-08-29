package com.tictactoe.kata.app.gameScreen

import tornadofx.Scope

class GameScope(
        val boardSize: Int = 3,
        val occupiedSquareInARowToWin: Int = 3
) : Scope()
