package Sudoku;

import java.util.Arrays;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

/**
 * @authors Saadaf Chowdhury, Darya Shyroka, Sam Newby, Ikjot Dhillon, Derek Jang, Daniel Ceniceros.
 */
public class Controller{
	
	public SudokuBoard currentBoard;
	/**
	 * Creates a new Controller object
	 * 
	 * @param board The SudokuBoard the Controller modifies
	 */
	public Controller(SudokuBoard board) {
		this.currentBoard = board;
	}
	
	/**
	 * Replaces the board attribute with a new random one, and
	 * updates the model and view accordingly.
	 */
	public void newGame() {
		int[][]tempboard1 = {{0, 0, 0, 0, 9, 0, 7, 0, 0},
                {0, 6, 1, 0, 0, 0, 0, 4, 0},
                {0, 0, 0, 0, 0, 2, 0, 0, 3},
                {0, 0, 7, 4, 8, 0, 0, 0, 0},
                {0, 8, 0, 0, 0, 0, 6, 0, 0},
                {0, 0, 3, 0, 0, 0, 5, 0, 0},
                {0, 0, 0, 5, 0, 0, 2, 0, 0},
                {9, 0, 0, 1, 0, 0, 0, 0, 0},
                {5, 0, 2, 0, 0, 0, 0, 8, 6}};
		
		int[][]tempboard2 = {{0, 0, 0, 0, 0, 0, 3, 0, 0},
                {8, 5, 2, 3, 0, 0, 0, 0, 1},
                {0, 9, 0, 2, 0, 0, 0, 0, 4},
                {9, 7, 4, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 6, 0, 0, 0, 0},
                {0, 0, 0, 0, 4, 0, 0, 0, 0},
                {6, 0, 9, 0, 8, 0, 0, 3, 7},
                {3, 0, 0, 0, 0, 0, 0, 6, 0},
                {0, 2, 0, 0, 0, 5, 0, 0, 0}};
		
		int[][]tempboard3 = {{0, 0, 7, 0, 0, 8, 0, 0, 0},
                {0, 5, 0, 0, 0, 4, 0, 0, 0},
                {0, 3, 1, 0, 0, 2, 5, 6, 0},
                {0, 0, 0, 0, 0, 0, 0, 3, 0},
                {0, 0, 6, 0, 0, 0, 7, 0, 0},
                {0, 0, 9, 5, 0, 6, 8, 0, 0},
                {0, 4, 0, 0, 0, 0, 0, 0, 5},
                {0, 0, 0, 0, 0, 0, 0, 4, 0},
                {7, 2, 0, 8, 0, 0, 0, 0, 3}};
		
		int[][]tempboard4 = {{0, 7, 0, 0, 8, 0, 6, 0, 0},
				{5, 4, 0, 0, 0, 0, 0, 3, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 1},
				{7, 0, 0, 0, 0, 0, 8, 0, 6},
				{0, 0, 0, 0, 0, 0, 0, 5, 0},
				{2, 5, 0, 4, 1, 0, 0, 0, 0},
				{0, 3, 0, 9, 4, 7, 0, 0, 0},
				{8, 0, 9, 0, 0, 2, 0, 1, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0}};
		
		int[][]tempboard5 = {{2, 0, 0, 0, 0, 4, 0, 0, 0},
				{0, 0, 5, 1, 0, 0, 0, 8, 0},
				{8, 0, 0, 0, 0, 0, 3, 0, 5},
				{3, 0, 7, 0, 4, 0, 0, 0, 0},
				{0, 1, 0, 0, 0, 0, 0, 6, 0},
				{0, 4, 0, 0, 0, 2, 0, 9, 0},
				{0, 6, 3, 0, 0, 9, 0, 0, 0},
				{0, 0, 2, 0, 3, 0, 8, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0}};
		int [][][] boards = {tempboard1, tempboard2,tempboard3,
				tempboard4,tempboard5}; 
		int randomBoard = new Random().nextInt(5);
		for(int x = 0; x < 9; x++) {
			for(int y = 0; y < 9; y++) {
				this.currentBoard.isNotChangable[x][y] = false;
			}
		}
		this.clear();
		for(int x = 0; x < 9; x++) {
			for(int y = 0; y < 9; y++) {
				int pos[] = {x,y};
				int value = boards[randomBoard][x][y];
				updateBoard(pos, value, true);
			}
		}
	}
	
	/**
	 * Clears every user-inputed sudoku cell, and
	 * updates the model and view accordingly.
	 */
	public void clear() {	
		for(int i = 0; i < 9; i++) {	
			for(int j = 0; j < 9; j++) {
				int pos[] = {i,j};
				updateBoard(pos,0, false); 
			
			}
		}	
	}
	
	/**
	 * Checks if currentBoard adheres to the sudoku grid rules. Every
	 * row, column, and inner square must have the integers inclusively
	 * from 1 to 9, without any repeats.
	 * @return true if and only if currentBoard is complete and correct.
	 */
	
	public boolean isSolved() {
		for(int i = 0; i < 9; i++) { // check if the rows are complete
			int[] rows = currentBoard.getRow(i);
			int[] cols = currentBoard.getCol(i);
			int[] x9sq = currentBoard.getSquare(i);
			if(!isUnique(rows) || !isUnique(cols) || !isUnique(x9sq)) {
				JLabel lose = new JLabel("Please double check your inputs!");
				lose.setFont(new Font("Arial", Font.BOLD, 18));
				JOptionPane.showMessageDialog(null, lose,"Incorrect!", JOptionPane.WARNING_MESSAGE);
				return false;
			}
		}
		JLabel win = new JLabel("You have all the correct inputs!");
		win.setFont(new Font("Arial", Font.BOLD, 18));
		JOptionPane.showMessageDialog(null, win, "Congratulations!", JOptionPane.PLAIN_MESSAGE);
		return true;
	}
	
	
	/**
	 * @pre: ilist has exactly 9 integers.
	 * Checks if the input adheres to the sudoku rules; the input
	 * must only have integers inclusively between 1 to 9.
	 * Furthermore, no duplicate integers are permitted.
	 * @return true if and only if the array completely spans the 
	 * integer range from 1 to 9.
	 */
	private boolean isUnique(int[] ilist){
		int keepTrack = 1; //the number we are looking for in ilist
		boolean foundIt = false;
		while(keepTrack <= 9) {	
			for(int i = 0; i < 9; i++) {	
				if(ilist[i] == keepTrack && !foundIt) {
					foundIt = true;
				}else if(ilist[i] == keepTrack && foundIt) {
					return false; //there is a duplicate value.
				}
			}
			if(!foundIt) {
				return false; //we have not found a required number
			}else{
				//we have found the required number exactly once, and so
				//we will look for the next number and do the same process.
				foundIt = false;
				keepTrack++;
			}
		}
		//if it reaches outside the for-loop, it has found exactly one
		//of every integer from 1 to 9.
		return true;
	}
	
	/**
	 * Updates the value of the button in the position of the positions array
	 * @param position The position array holding the x and y value of the button
	 * @param value The value to set the button to
	 */
	public void updateBoard(int[] position, int value, boolean isNewGame) {
		int x = position[0];
		int y = position[1];
		if (isNewGame == true && value != 0) {
			currentBoard.setValue(value, x, y, true);
		} else {
			currentBoard.setValue(value, x, y);
		}
	}
	
}