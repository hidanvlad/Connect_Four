# Connect Four

A simple command-line Connect Four game written in Java.

## Features

- **Two-player mode**: Play against another person locally
- **AI mode**: Play against a computer opponent with strategic gameplay
- Classic 6x7 Connect Four board
- Win detection for horizontal, vertical, and diagonal connections
- Input validation and error handling

## How to Play

Connect Four is a two-player connection game where players take turns dropping colored discs into a vertical grid. The objective is to be the first to form a horizontal, vertical, or diagonal line of four of one's own discs.

## Requirements

- Java JDK 8 or higher

## How to Compile

```bash
javac -d bin src/main/java/com/connectfour/*.java
```

## How to Run

### Using the run script (Linux/Mac):

```bash
./run.sh
```

### Manual compilation and run:

```bash
java -cp bin com.connectfour.Main
```

## Game Instructions

1. When you start the game, you'll be prompted to select a game mode:
   - **Option 1**: Two Players (local) - Play with another person
   - **Option 2**: Player vs AI - Play against the computer

2. Players take turns entering a column number (1-7) to drop their piece

3. Player X always goes first
   - In two-player mode: Player 1 is X, Player 2 is O
   - In AI mode: You are X, the AI is O

4. The first player to connect four pieces horizontally, vertically, or diagonally wins!

5. The game ends in a draw if the board fills up without a winner

## Example Gameplay

```
╔════════════════════════════════╗
║   CONNECT FOUR GAME            ║
╚════════════════════════════════╝

Select game mode:
1. Two Players (local)
2. Player vs AI

Enter your choice (1 or 2): 2

=== Welcome to Connect Four! ===
Player X goes first.
You are X, AI is O.

 1 2 3 4 5 6 7
---------------
| | | | | | | |
| | | | | | | |
| | | | | | | |
| | | | | | | |
| | | | | | | |
| | | | | | | |
---------------
Player X, enter column (1-7): 4
```

## AI Strategy

The AI opponent uses a strategic approach:
1. Tries to win if possible
2. Blocks the player from winning
3. Prefers center columns for better positioning
4. Makes smart defensive and offensive moves

## Project Structure

```
Connect_Four/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── connectfour/
│                   ├── Main.java      # Entry point and menu
│                   ├── Game.java      # Game logic
│                   ├── Board.java     # Board representation
│                   └── AIPlayer.java  # AI opponent
├── .gitignore
└── README.md
```