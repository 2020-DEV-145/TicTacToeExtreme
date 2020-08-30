package com.tictactoe.kata.app.gameScreen

import com.tictactoe.kata.domain.PlayingState
import com.tictactoe.kata.domain.TicTacToeEE
import com.tictactoe.kata.domain.TicTacToeEEGame
import io.reactivex.subjects.BehaviorSubject

import io.reactivex.subjects.Subject
import tornadofx.*

class GameViewModel : ViewModel() {

    private lateinit var game: TicTacToeEE
    val gameState: Subject<GameViewState> = BehaviorSubject.create<GameViewState>()

    fun initializeGame(boardSize: Int, piecesInARowToWin: Int) =
            TicTacToeEEGame(boardSize, boardSize, piecesInARowToWin).also {
                game = it
                updateViewGameState()
            }


    private fun updateViewGameState() {
        gameState.onNext(with(game.gameState) {
            GameViewState(
                    currentPlayer = currentPlayer.toString(),
                    board = boardState,
                    gameState = when (state) {
                        PlayingState.PLAYING -> GameViewState.GameState.PLAYING
                        PlayingState.OVER -> GameViewState.GameState.OVER
                    },
                    winner = winner?.toString() ?: ""
            )
        })
    }

    fun play(row: Int, col: Int) = game.play(row, col).also {
        updateViewGameState()
    }
}