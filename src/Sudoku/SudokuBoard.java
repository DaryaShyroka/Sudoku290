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
	//Model model;
	//SudokuView view;
    public SudokuBoard(){

    	int[][]tempboard = {{0, 0, 0, 0, 9, 0, 7, 0, 0},
                 {0, 6, 1, 0, 0, 0, 0, 4, 0},
                 {0, 0, 0, 0, 0, 2, 0, 0, 3},
                 {0, 0, 7, 4, 8, 0, 0, 0, 0},
                 {0, 8, 0, 0, 0, 0, 6, 0, 0},
                 {0, 0, 3, 0, 0, 0, 5, 0, 0},
                 {0, 0, 0, 5, 0, 0, 2, 0, 0},
                 {9, 0, 0, 1, 0, 0, 0, 0, 0},
                 {5, 0, 2, 0, 0, 0, 0, 8, 6}};
		board = tempboard;
    	
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
