package Sudoku;

public class Controller{
	
	public SudokuBoard current_board;
	
	public Controller(SudokuBoard board) {
		this.current_board = board;
	}
	
	/**
	 * This method will replace the board attribute with a new random one, and
	 * update the model and view accordingly.
	 */
	public void newGame() {
		// swap new board here, to be implemented later.
	}
	
	/**
	 * This method will clear every cell which was inputted by the user.
	 */
	public void clear() {
		
		for(int i = 0; i < 9; i++) {
			
			for(int j = 0; j < 9; j++) {
				
				current_board.setValue(0,i,j); 
				//[i,j] are the coordinates of the cell, 0 is a placeholder
				// value for an empty cell.
			}
			
		}
		
	}
	
	/**
	 * This method will return true if and only if the board is completely
	 * filled and every row, column, and inner 3x3 squares contain the values
	 * from 1-9 respectively unique.
	 * @return true if the sudoku puzzle is correct
	 */
	
	public boolean check() {
		
		for(int i = 0; i < 9; i++) { // check if the rows are complete
			
			int[] rows = this.getRow(i);
			int[] cols = this.getCol(i);
			int[] x9sq = this.getSquare(i);
			
			if(!checkUnique(rows) || !checkUnique(cols) || !checkUnique(x9sq)) {
				return false;
			}
			
		}
		
		return true;
		
	}
	
	/**
	 * Returns a row of the current sudoku board.
	 * @param indice An integer from 0 to 8.
	 * @return The row of the sudoku board going from top to bottom.
	 */
	private int[] getRow(int indice){
		return (current_board.getBoard())[indice];
	}
	
	/**
	 * Returns a column of the current sudoku board.
	 * @param indice An integer from 0 to 8.
	 * @return The colum of the sudoku board going from left to right.
	 */
	private int[] getCol(int indice){
		int[] board_column = new int[9];
		int[][] curr_board = current_board.getBoard();
		for(int x = 0; x < 9; x++) {
			board_column[x] = curr_board[x][indice];
		}
		return board_column;
	}
	
	/**
	 * Returns an inner 3x3 square of the current sudoku board.
	 * @param indice An integer from 0 to 8.
	 * @return The corresponding inner 3x3 square of the sudoku board, going from
	 * top-left to bottom-right, iterating to the right before iterating down,
	 * represented as an array of 9 integers.
	 */
	private int[] getSquare(int indice){
		int[] board_square = new int[9];
		int[][] curr_board = current_board.getBoard();
		int x_start = (indice % 3)*3;
		int y_start = Math.floorDiv(indice, 3)*3;
		for(int x = 0; x < 3; x++) {
			for(int y = 0; y < 3; y++) {
				board_square[(Math.floorDiv(x, 3)*3) + y] = 
						curr_board[x_start + x][y_start + y];
			}
		}
		return board_square;
	} 
	
	/**
	 * Precondition: ilist has exactly 9 integers.
	 * Takes in an array of 9 integers and returns true if and only if
	 * the array completely spans the integer range from 1 to 9.
	 * @return
	 */
	private boolean checkUnique(int[] ilist){
		
		int keepTrack = 1;
		boolean foundIt = false;
		
		while(keepTrack <= 9) {
			
			for(int i = 0; i < 9; i++) {
				
				if(ilist[i] == keepTrack || !foundIt) {
					foundIt = true;
				}else if(ilist[i] == keepTrack || foundIt) {
					return false; //there is a duplicate value.
				}
				
			}
			
			if(!foundIt) {
				return false; //we have not found a required number
			}else {
				//we have found the required number exactly one, and so
				//we will look for the next number and do the same process.
				foundIt = false;
				keepTrack++;
			}
			
		}
		//if it reaches outside of the for-loop, it has found exactly one
		//of every integer from 1 to 9.
		return true;
		
	}
	
	/**
	 * Updates the value of the button in the position of the positions array
	 * @param position The position array holding the x and y value of the button
	 * @param value The value to set the button to
	 */
	public void updateBoard(int[] position, int value) {
		
		int x = position[0];
		int y = position[1];
		current_board.setValue(x, y, value);
		
	}
	
}