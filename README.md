# Sudoku290

Sudoku290 is an implementation of the classic Sudoku game. It is a number placement puzzle game consisting of a simple 9x9 grid. Some of the cells in the grid contain preset numbers. Your job is to fill in the remaining cells with the digits from 1 to 9 in such a way that no digit repeats in each row, column and inner 3X3 square. That is, each row, column, and inner 3X3 square contain all of the digits from 1 to 9. You can play between five different Sudoku290 boards that will be sure to challenge your brain!

## Getting Started

Follow these instructions to install a copy of the game onto your local machine to run the game, or for development and testing purposes.

### To run the game 

1. Clone this repository with the following command:
`git clone https://github.com/DaryaShyroka/Sudoku290`

2. Navigate to the `src` directory, then open `Sudoku`.

2. Import the entire project into Eclipse.

3. Run `SudokuView.java`. The game should start!

### To edit the code

Open `SudokuView.java`, `SudokuBoard.java`, `Controller.java`, `CellButton.java` in Eclipse and bless Sudoku290 with your coding skills!

### How to Play Sudoku290
The starting screen consists of 3 buttons (New Game, Clear, Check) and a 9x9 Sudoku Board with some preset numbers.

![new_game_screen](https://user-images.githubusercontent.com/46885386/54781800-ac380780-4bf3-11e9-8ec4-f0c10efc6fe8.jpg)

The empty cells indicate positions where the player can input numbers. These cells can be changed and cleared at any time. The starting cells which already contain numbers cannot be changed or cleared. 

To input a number into the cell, the player must first click on a valid cell and input a valid number from the keyboard. Entering any character other than 1-9 will result in nothing being inputed and an error message being printed. Attempting to enter a number into a starting cell will result in nothing being changed.

![played_a_little](https://user-images.githubusercontent.com/46885386/54781905-f4efc080-4bf3-11e9-8ea9-c906556eff23.jpg)

The player can click the Clear and Check button during anytime of the game. Selecting Clear will result in removing all numbers the player entered. The Check button will test the board's values and show a dialogue box indicating whether the player is finished. 

![not_done_yet](https://user-images.githubusercontent.com/46885386/54782065-662f7380-4bf4-11e9-802c-5b472f81d718.jpg)

Once finished, the player can select New Game to start playing on a different board or the player can exit.

![done](https://user-images.githubusercontent.com/46885386/54782084-6fb8db80-4bf4-11e9-955c-c47a11f84fcb.jpg)

## Authors

Darya Shyroka, Derek Jang, Ikjot Dhillon, Sam Newby, Daniel Ceniceros, Saadaf Chowdhury

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* README template: **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)
* Sudoku boards - we used game boards from this lovely site: https://www.puzzles.ca/sudoku/?fbclid=IwAR2-rysiASKKw04_LtzqaU13S3CMTY37WnUJWLyk1iSKhkg3G2Y1U25sQ9k
