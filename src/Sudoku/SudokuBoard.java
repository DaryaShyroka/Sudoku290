package Sudoku;

/**
 * This class represents the Sudoku board that will be displayed on the view.
 * @authors Ikjot Dhillon, Derek Jang, Saadaf Chowdhury, Darya Shyroka, Daniel Ceniceros, Sam Newby
 *
 */

public class SudokuBoard {

	private int board[][] = new int[9][9];
	public boolean isNotChangable[][] = new boolean[9][9];
	private SudokuView view;

	/**
	 * Sets up a new SudokuBoard
	 * @param view The view that is notified when a value is changed on the board
	 */
    public SudokuBoard(SudokuView view){
    	this.view = view;
	}

	/**
	 * Gets the current board.
	 * @return the integer array board
	 */
	public int[][] getBoard() {
		return this.board;
	}


	/**
	 * Set the value of the board array and buttons array at position x and y if the cell is not a preset cell.
	 * @param value The number to be stored.
	 * @param x The x coordinate of the array.
	 * @param y The y coordinate of the array.
	 */
	public void setValue(int value, int x, int y) {
		if (this.isNotChangable[x][y] != true) {
			this.board[x][y] = value;
			view.update(value, x, y);
		}
	}
	
	/**
	 * Sets the board array with a optional new game argument which sets if a button value can be changed. This can prevent players for changing preset cells.
	 * @param value The number to be stored.
	 * @param x The x coordinate of the array.
	 * @param y The y coordinate of the array.
	 * @param isNewGame If true the cell is set to not changeable. Used when setting preset cells.
	 */
	public void setValue(int value, int x, int y, boolean isNewGame) {
		if (isNewGame == true) {
			this.isNotChangable[x][y] = true;
			this.board[x][y] = value;
			view.update(value, x, y);
		} else {
			if (this.isNotChangable[x][y] != true) {
				this.board[x][y] = value;
				view.update(value, x, y);
			}
		}	
	}
	
	
	/**
	 * Returns a row of the current sudoku board.
	 * @param index An integer from 0 to 8.
	 * @return The row of the sudoku board going from top to bottom.
	 */
	public int[] getRow(int index){
		return this.board[index];
	}
	
	/**
	 * Returns a column of the current sudoku board.
	 * @param index An integer from 0 to 8.
	 * @return The column of the sudoku board going from left to right.
	 */
	public int[] getCol(int index){
		int[] boardColumn = new int[9];
		for(int x = 0; x < 9; x++) {
			boardColumn[x] = this.board[x][index];
		}
		return boardColumn;
	}
	
	/**
	 * Returns an inner 3x3 square of the current sudoku board.
	 * @param index An integer from 0 to 8.
	 * @return The corresponding inner 3x3 square of the sudoku board, going from
	 * top-left to bottom-right, iterating to the right before iterating down,
	 * represented as an array of 9 integers.
	 */
	public int[] getSquare(int index){
		int[] boardSquare = new int[9];
		int xStart = (index % 3)*3; //capture the leftmost column of the indice's inner square
		int yStart = Math.floorDiv(index, 3)*3; //capture the top row of the indice's inner square
		for(int x = 0; x < 3; x++) {
			for(int y = 0; y < 3; y++) {
				int currentIndex = (x*3) + y;
				boardSquare[currentIndex] = 
						this.board[xStart + x][yStart + y];
			}
		}
		return boardSquare;
	} 
	
}
