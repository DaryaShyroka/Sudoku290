## Directory Structure

- `src` contains all Java source code in the `Sudoku` folder

## Code Structure

- `src/Sudoku/SudokuView.java` contains the view part of the Model-View-Controller architecture. This class contains everything that is visible in the game. It also initializes the GUI, launches the game when it is run, and asks the Controller and Model to update the board upon user input.
- `src/Sudoku/SudokuBoard.java`
- `src/Sudoku/Controller.java`
- `src/Sudoku/CellButton.java`

## Major Classes and Functions

This is where explain the important classes in functions in Sudoku290

### SudokuView

#### Methods

- `initUI(Stage stage)` Sets up the stage. Adds the grid and the new game buttons to the GUI.
- `makeBoard()` sets up the Sudoku Board cells and adds style to each cell.

### Controller

#### Methods

- `newGame()` Resets the current board and starts a new Sudoku game. randomly picks between 1 of 5 boards and updates the board with the new values.
- `updateBoard(int[x,y] position, int value, boolean isNewGame)` Changes the current value of cell in position {x,y} to the int value. If isNewGame is true the button is set so the value of the cell cannot be changed.
- `isUnique(int[1..9] ilist)` ilist is an array of 9 integers. The method returns true if the list contains all integers 1 to 9 with no duplicates.
- `isSolved()` Returns true if the current board state is a winning state.
- `clear()` Resets the board to the state at the beggining of the game. Keeps values of starting cells.

### SudokuBoard

#### Methods

- `setValue(int value, int x, int y, boolean newGame)` If the button can be changed, set the cell at position (x,y) to the int value. If newGame is true the button is set so the value cannot be changed afterwards.
- `getRow(int indice)` Returns the row at int indice.
- `getColumn(int indice)` Returns the column at int indice.
- `getSquare(int indice)` Returns the 3x3 square with cell at int indice as the top left corner.

### CellButton

#### Methods

- `setNum(int num)` sets the button number to int num. Sets the text to match the number, leaves blank if num is 0.
