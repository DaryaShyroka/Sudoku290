# Extensions to Sudoku290

This is where we list and describe potential extensions to Sudoku290

There are multiple ways the game can be added to and improved upon. We have outlined some of those below.

## 1. Add new boards.

To add a new board, the board has to be first converted into a 9x9 int array. For example, if the board is this,(https://www.puzzles.ca/sudoku_puzzles/sudoku_easy_487.html) the array would be:
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

Then initialize the array inside `newGame()`and place it inside the`boards` variable. Also, `Random.nextInt` has to be called with the length of `boards` so that all the boards have an equal chance of being initialized when the `New Game` button is clicked by the user. 

