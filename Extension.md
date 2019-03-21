# Extensions to Sudoku290

Here, we list and describe potential extensions to Sudoku290.

There are multiple ways the game can be added to and improved upon. We have outlined a couple of those below.

## 1. Add new boards.

To add a new board:

1. Convert the board into a 9X9 integer array. For example, if the board is this,(https://www.puzzles.ca/sudoku_puzzles/sudoku_easy_487.html) the array would be:
`{{0,7,0,0,0,2,0,0,0},
{6,0,0,0,0,0,0,0,0},
{0,0,0,0,5,3,0,0,0},
{0,0,0,8,0,0,0,2,0},
{0,3,0,0,4,7,1,6,0},
{4,0,0,0,0,0,5,7,0},
{0,0,0,0,1,0,7,5,0},
{0,6,0,5,2,0,0,4,0},
{3,0,0,0,0,9,0,8,6},
}`

2. Initialize the array inside `newGame()`and place it inside the`boards` variable. 

3. Change the call to `Random.nextInt` to have the length of `boards` so that all the boards have an equal chance of being initialized when the `New Game` button is clicked by the user. 

## 2. Add Show Solution Button

Although there is a check solution button to check if the board has been solved, it would be nice to have a button to display the solution. This function could be implemented within the `Controller` and `SudokuView` classes. Here is how to add a 'Show Solution' button:

1. Begin by creating a new button in `SudokuView` and assinging it the handler.

2. Now, create the function for displaying the solution in the `Controller` class. The function will have to work with the `currentBoard` array to display the solution. Each cell in the array has a `currentNum` value which can be changed to the correct value.

The new function should have a `void` return type.
