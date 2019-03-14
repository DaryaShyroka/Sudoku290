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
	private boolean changable[][] = new boolean[9][9];
	private SudokuView view;
	//Model model;
	//SudokuView view;
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
		this.board[x][y] = value;
		view.update(value, x, y);
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
		if (newGame) {
			this.changable[x][y] = false;
		} else {
			this.changable[x][y] = true;
		}
		this.board[x][y] = value;
		view.update(value, x, y);
	}

	/**
	 * Starts the game.
	 * @param stage The stage for the game.
	 */
	/*@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		//this.model = new Model;
		this.view = new SudokuView(stage);
	}
	*/
	
}
