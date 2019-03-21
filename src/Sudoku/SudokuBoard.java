package Sudoku;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
/**
 * This class represents the Sudoku board that will be displayed on the view.
 * @author Ikjot Dhillon, Derek Jang, Saadaf Chowdhury
 *
 */


public class SudokuBoard {

	private int board[][] = new int[9][9];
	public boolean notChangable[][] = new boolean[9][9];
	private SudokuView view;

    public SudokuBoard(SudokuView view){
    	this.view = view;
	}

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
		if (this.notChangable[x][y] != true) {
			this.board[x][y] = value;
			view.update(value, x, y);
		}
	}
	
	/**
	 * Sets the board array with the new game values that are not changable
	 * 
	 * @param value
	 * @param x
	 * @param y
	 * @param newGame
	 */
	public void setValue(int value, int x, int y, boolean newGame) {
		if (newGame == true) {
			this.notChangable[x][y] = true;
			this.board[x][y] = value;
			view.update(value, x, y);
		} else {
			if (this.notChangable[x][y] != true) {
				this.board[x][y] = value;
				view.update(value, x, y);
			}
		}	
	}
	
	
	/**
	 * Returns a row of the current sudoku board.
	 * @param indice An integer from 0 to 8.
	 * @return The row of the sudoku board going from top to bottom.
	 */
	public int[] getRow(int indice){
		return this.board[indice];
	}
	
	/**
	 * Returns a column of the current sudoku board.
	 * @param indice An integer from 0 to 8.
	 * @return The column of the sudoku board going from left to right.
	 */
	public int[] getCol(int indice){
		int[] boardColumn = new int[9];
		for(int x = 0; x < 9; x++) {
			boardColumn[x] = this.board[x][indice];
		}
		return boardColumn;
	}
	
	/**
	 * Returns an inner 3x3 square of the current sudoku board.
	 * @param indice An integer from 0 to 8.
	 * @return The corresponding inner 3x3 square of the sudoku board, going from
	 * top-left to bottom-right, iterating to the right before iterating down,
	 * represented as an array of 9 integers.
	 */
	public int[] getSquare(int indice){
		int[] boardSquare = new int[9];
		int xStart = (indice % 3)*3; //capture the leftmost column of the indice's inner square
		int yStart = Math.floorDiv(indice, 3)*3; //capture the top row of the indice's inner square
		for(int x = 0; x < 3; x++) {
			for(int y = 0; y < 3; y++) {
				int index = (x*3) + y;
				boardSquare[index] = 
						this.board[xStart + x][yStart + y];
			}
		}
		return boardSquare;
	} 
	
}
