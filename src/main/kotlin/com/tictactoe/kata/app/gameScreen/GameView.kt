package com.tictactoe.kata.app.gameScreen

import com.tictactoe.kata.app.Styles
import io.reactivex.disposables.Disposable
import javafx.scene.layout.GridPane
import tornadofx.*

class GameView : View("Tic Tac Toe - Extreme Edition"), SquareView.Listener {
    override val scope = super.scope as GameScope
    private val vm: GameViewModel by inject()
    private lateinit var gridPane: GridPane
    private var gameStateDisposable: Disposable? = null

    override val root = vbox {
        label(title) {
            addClass(Styles.heading)
        }
        gridPane = gridpane { }
    }

    override fun onDock() {
        super.onDock()
        resizeWindows()
        vm.initializeGame(scope.boardSize, scope.occupiedSquareInARowToWin)
        gameStateDisposable = vm.gameState.subscribe { onNext ->
            updateView(onNext)
        }
    }

    private fun resizeWindows() {
        primaryStage.width = SquareView.WIDTH * scope.boardSize + 100
        primaryStage.height = SquareView.HEIGHT * scope.boardSize + 100
    }

    override fun onDelete() {
        super.onDelete()
        gameStateDisposable?.dispose()
    }

    private fun updateView(gameState: GameViewState) {
        gridPane.clear()
        gameState.board.forEachIndexed { colIndex, row ->
            gridPane.run {
                row {
                    row.forEachIndexed { rowIndex, label ->
                        this += SquareView(rowIndex, colIndex, label, this@GameView)
                    }
                }
            }
        }
    }

    override fun onClicked(row: Int, col: Int) {
        vm.play(row, col)
    }
}

