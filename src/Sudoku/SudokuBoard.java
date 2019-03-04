package Sudoku;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
/**
 * This class represents the Sudoku board that will be displayed on the view.
 * @author Ikjot Dhillon, Derek Jang, Saadaf Chowdhury
 *
 */


public class SudokuBoard extends GridPane {

	private int board[][] = new int[9][9];
	private CellButton buttons[][] = new CellButton[9][9];
	//Model model;
	//SudokuView view;
    public SudokuBoard(){
		
    	for (int i = 0; i < 9; i++) {
    		for (int k = 0; k < 9; k++) {
    			int[] position = {i, k};
    			Button btn = new CellButton(position, true, new Controller(this));
    			btn.setMinSize(50, 50);
    			this.add(btn, i, k);   		
    		}
    	}		
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
		this.buttons[x][y].setNum(value);
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

