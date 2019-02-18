/**
 * This class represents the Sudoku board that will be displayed on the view.
 * @author Ikjot Dhillon
 *
 */


public class SudokuBoard {

	private int board[][] = new int[9][9];
	private CellButton buttons[][] = new CellButton[9][9];

	/**
	 *
	 * @return the integer array board
	 */
	public int[][] getBoard() {
		return this.board;
	}
	
	/**
	 * Set the value of the board array and buttons array at position x and y.
	 *
	 * @param value The number to be stored.
	 * @param x The x coordinate of the array.
	 * @param y The y coordinate of the array.
	 */
	public void setValue(int value, int x, int y) {
		this.board[x][y] = value;
		this.buttons[x][y].setNum(value);
	}
}
