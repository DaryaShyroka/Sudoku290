## Directory Structure

- `src` contains all Java source code in the `Sudoku` folder.

## Code Structure

## Major Classes and Functions

The major classes and functions in Sudoku290 are discussed below.

### SudokuView

This class contains the view; which handles everything that is visible in the game. SudokuView initializes the GUI, launches the game, and updates the board whenever user input is provided.

#### Methods

- `initUI(Stage stage)`: Sets up the stage; adding the grid and the new game buttons to the GUI.
- `makeBoard()`: Sets up the SudokuBoard cells and adds a style to each cell.

### Controller

This class contains the logic of the game and updates the model; setting the values and handling button presses.

#### Methods

- `newGame()`: Resets the current board and starts a new Sudoku290 game. It randomly picks between 5 preset boards and updates the current board with the new values.
- `updateBoard(int[x,y] position, int value, boolean isNewGame)`: Changes the current value of the cell at position {x,y} to `value`. If `isNewGame` is true, the button is set so the value of the cell cannot be changed. This prevents players from changing cells with preset numbers.
- `isUnique(int[1..9] ilist)`: Returns true if `ilist` contains all integers 1 to 9 without duplicates.
- `isSolved()`: Returns true if the current board is in a winning state.
- `clear()`: Resets the board to the beggining state of the game; keeping the values of starting cells the same and wiping user-inputted values.

### SudokuBoard

This class contains the model of the project, where the current state of the board is saved in a 2x2 array of integers. When the model is updated, the cells on the view are also updated accordingly.

#### Methods

- `setValue(int value, int x, int y, boolean isNewGame)`: If the button can be changed, set the cell at position (x,y) to the `value`. If 'isNewGame' is true, the button is set so the value cannot be changed afterwards.
- `getRow(int index)`: Returns the row at `index`.
- `getColumn(int index)`: Returns the column at `index`.
- `getSquare(int index)`: Returns the 3x3 square with cell at `index`.

### CellButton

Contains the individual cells of the SudokuBoard grid in the form of buttons, which hold an integer value.

#### Methods

- `setNum(int num)`: Sets the cell's value to `num` and leaves the cell blank if `num` is 0.
