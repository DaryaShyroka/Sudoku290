## Directory Structure

- `src` contains all Java source code in the `Sudoku` folder

## Code Structure

## Major Classes and Functions

This is where we explain the major classes and functions in Sudoku290.

### SudokuView

Contains the view, everything that is visible in the game. SudokuView initializes the GUI, launches the game , and updates the board when user input is given.

#### Methods

- `initUI(Stage stage)` Sets up the stage. Adds the grid and the new game buttons to the GUI.
- `makeBoard()` sets up the Sudoku Board cells and adds style to each cell.

### Controller

Contains the logic of the game and updates the model. Sets the values of the model and handles button presses.

#### Methods

- `newGame()` resets the current board and starts a new Sudoku game. Randomly picks between 1 of 5 boards and updates the board with the new values.
- `updateBoard(int[x,y] position, int value, boolean isNewGame)` changes the current value of the cell in position {x,y} to the int value. If `isNewGame` is true, the button is set so the value of the cell cannot be changed. This is to prevent players from changing preset cells.
- `isUnique(int[1..9] ilist)` Returns true if `ilist` contains all integers 1 to 9 without duplicates.
- `isSolved()` Returns true if the current board state is a winning state.
- `clear()` Resets the board to the state at the beggining of the game. Keeps values of starting cells.

### SudokuBoard

Contains the model of the project. The current state of the board is saved in a 2x2 array of integers. When the model is updated the cells on the view are updated to match the model.

#### Methods

- `setValue(int value, int x, int y, boolean isNewGame)` If the button can be changed, set the cell at position (x,y) to the int value. If isNewGame is true the button is set so the value cannot be changed afterwards.
- `getRow(int index)` Returns the row at int index.
- `getColumn(int index)` Returns the column at int index.
- `getSquare(int index)` Returns the 3x3 square with cell at int index as the top left corner.

### CellButton

The individual cells of the Sudoku board. Contains the current value of the cell.

#### Methods

- `setNum(int num)` sets the button's value `num`. Sets the text to match the number, leaves blank if num is 0.
