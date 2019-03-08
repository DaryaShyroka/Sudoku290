package Sudoku;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
/**
 * This class represents the Sudoku board that will be displayed on the view.
 * @author Ikjot Dhillon, Derek Jang, Saadaf Chowdhury, Sam Newby
 *
 */


public class SudokuBoard extends GridPane implements EventHandler<ActionEvent>{

	private int board[][] = new int[9][9];
	private CellButton buttons[][] = new CellButton[9][9];
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
    	for (int i = 0; i < 9; i++) {
    		for (int k = 0; k < 9; k++) {
<<<<<<< HEAD
    			int pos[] = {i, k};
    			CellButton btn = new CellButton(pos, true);
=======
    			int[] position = {i, k};
    			Button btn = new CellButton(position, true);
				btn.setOnAction(this);
				if(board[k][i] == 0) {
					btn.setText(" ");
				} else {
					btn.setText(Integer.toString(board[k][i]));
				}
>>>>>>> bb2ee985521dd01f7c0633698d954f596baec68b
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

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		((Button) event.getSource()).setText("0");
	}

	/**
	 * Adds the button to the current Sudokuboard
	 * 
	 * @param button The CellButton to be added to the board
	 */
	public void add(CellButton button, int x, int y) {
		this.buttons[x][y] = button;
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
