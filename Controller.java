public class Controller{
	
	public SudokuBoard current_board;
	
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
				
				current_board.setNum([i,j],0); 
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
			
			int[9] rows = current_board.getRow(i);
			int[9] cols = current_board.getCol(i);
			int[9] x9sq = current_board.getSquare(i);
			
			if(!checkUnique(rows) || !checkUnique(cols) || !checkUnique(x9sq)) {
				return false;
			}
			
		}
		
		return true;
		
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
					return false //there is a duplicate value.
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
	
	
}