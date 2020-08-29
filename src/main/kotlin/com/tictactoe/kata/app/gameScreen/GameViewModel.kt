package com.tictactoe.kata.app.gameScreen

import com.tictactoe.kata.game.PlayingState
import com.tictactoe.kata.game.TicTacToeEE
import com.tictactoe.kata.game.TicTacToeEEGame
import io.reactivex.subjects.BehaviorSubject

import io.reactivex.subjects.Subject
import tornadofx.*

class GameViewModel : ViewModel() {

    private lateinit var game: TicTacToeEE
    val gameState: Subject<GameViewState> = BehaviorSubject.create<GameViewState>()

    fun initializeGame(boardSize: Int, piecesInARowToWin: Int) {
        game = TicTacToeEEGame(boardSize, boardSize, piecesInARowToWin)
        updateViewGameState()
    }

    private fun updateViewGameState() {
        gameState.onNext(with(game.gameState) {
            GameViewState(
                    currentPlayer.toString(),
                    boardState,
                    when (state) {
                        PlayingState.PLAYING -> GameViewState.GameState.PLAYING
                        PlayingState.OVER -> GameViewState.GameState.OVER
                    },
                    winner = winner?.toString() ?: ""
            )
        })
    }

    fun play(row: Int, col: Int) {
        game.play(row, col)
        updateViewGameState()
    }
}