# 🔥 Tic Tac Toe -  Extreme Edition 🔥

## 🗒 Introduction Note
I've played the *standard* Tic Tac Toe version with friends and I personally don't like the way the game is played out.
When both players are good, it's always a draw. 
I wanted to build something different, something more **FUN**!
 
For this Kata, I added 2 modifications:
1. The board can be bigger than 3x3
2. The player needs to draw **N** X's or O's in a row

For me, coding is about the *love for the code* but also *the love for what you are building*

## 📜 Extreme Edition Rules
- X always goes first.
- Players cannot play on a played position.
- Players alternate placing X’s and O’s on the board until either:
	- One player has **N** in a row, horizontally, vertically or diagonally
	- **All squares** are filled.
- If a player is able to draw **N** X’s or **N** O’s in a row, that player wins.
- If **all squares** are filled and neither player has **N** in a row, the game is a draw.

##  🎮 How to run
🍎/🐧 Mac - Linux:
```
./gradlew build
./gradlew test
./gradlew run
```
🖼 Windows
```
gradlew clean build
gradlew clean test
gradlew clean run
```

## 📃 Development steps
1) Writing the domain logic
    - Iterating using TDD on the domain logic
2) Creating Views
    - Binding it with the Domain Logic
    - *Adding UI tests* (Not done here because it's not in the test scope)
    - If needed, updating the domain logic and adding unit tests as edge cases arise
3) Getting the code ready for MR
    - Refactoring
    - Code style
    
## 🚀 Possible Evolutions
- Being able to play with more than 2 players. It would only require updating the PlayerEnum, the updateCurrentPlayer() Function and the SquareView.
    
## 💬 Sidenotes
I chose to do the project in pure Kotlin rather than Android/Kotlin because I wanted to learn more about it without the Android Framework

I also discovered TornadoFX, a JavaFX Framework for Kotlin. First time for me.