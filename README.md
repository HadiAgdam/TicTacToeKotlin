# Tic Tac Toe Kotlin

This repository contains a Tic Tac Toe game implemented in Kotlin, featuring a command-line interface (CLI) and an extensible AI system. The game supports customizable AI algorithms, with a default implementation of the Minimax algorithm.

## Features

- **Object-Oriented Design**: The project uses Kotlin's `enum class`, `data class`, and inheritance to create a modular and extensible design.
- **AI Support**: The game includes a pluggable AI system, with Minimax as the default algorithm.
- **Command-Line Interface**: A simple and intuitive CLI for playing Tic Tac Toe.
- **Extensibility**: Easily add custom AI algorithms by extending the `Algorithm` abstract class.

## How It Works

### Game Components

- **`Mark`**: Represents the state of each cell in the game board (`X`, `O`, or `BLANK`).
- **`Position`**: Represents the coordinates of a cell on the board.
- **`Board`**: Manages the game state, including setting marks, checking for win conditions, and finding available moves.
- **`Algorithm`**: An abstract class for AI algorithms. Custom AI can be added by extending this class and implementing the `play` method.
- **`Minimax`**: The default AI algorithm using the Minimax strategy for optimal moves.

### Board Functionality

- `set(position: Position, mark: Mark)`: Marks a cell with `X`, `O`, or `BLANK`.
- `get(position: Position): Mark`: Retrieves the mark of a cell.
- `checkWin(): Mark?`: Checks if there's a winner and returns the winning mark, or `null` if there's no winner.
- `getBlanks(): List<Position>`: Returns a list of all available positions on the board.

### AI Functionality

To implement a custom AI, extend the `Algorithm` class:

```kotlin
abstract class Algorithm {
    abstract fun play(board: Board, c: Mark): Position?
}
```

Example: Adding a new AI algorithm:

```kotlin
object CustomAI : Algorithm() {
    override fun play(board: Board, c: Mark): Position? {
        // Your custom logic here
    }
}
```

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/HadiAgdam/TicTacToeKotlin.git
   ```
2. Open the project in your favorite Kotlin IDE (e.g., IntelliJ IDEA).
3. Build and run the project.

## How to Play

1. Run the application.
2. Choose whether you want to play as `X` or `O`.
3. Make your moves by entering the coordinates of the cell (e.g., `0 1` for the cell at row 0, column 1).
4. The AI will make its moves automatically.

## Minimax Algorithm

The Minimax algorithm evaluates all possible moves to determine the best one for the AI. It uses a recursive approach with the following logic:
- Maximizes the AI's score.
- Minimizes the opponent's score.
- Stops recursion when a win, loss, or draw is detected, or a maximum depth is reached.

## Future Enhancements

- Add support for larger board sizes and custom win conditions.
- Implement additional AI strategies (e.g., Alpha-Beta Pruning, Random AI).
- Add a GUI for better user interaction.

## Contributing

Contributions are welcome! If you'd like to add a new feature or improve the AI, feel free to fork the repository and create a pull request.

