package Sudoku;

/**
* A CellButton represents a cell in the sudoku grid.
* Attributes:
*   position: position in the grid
*   currentNum: the current number in the cell
*   changeable: whether currentNum can be modified
*   controller: the Controller of this CellButton
* Changeable CellButtons are ones in which the user fills the contents in themselves.
* If a CellButton is changeable, its currentNum field can be modified.
*
* @author Darya Shyroka
* @version 1.0
* @since 2019-02-15
*/

import javafx.scene.control.*;
import javafx.scene.text.*;

/**
 * A CellButton is a button in the SudokuBoard array. 
 * @authors Darya Shyroka, Daniel Ceniceros, Sam Newby, Ikjot Dhillon, Derek Jang, Saadaf Newby.
 */
public class CellButton extends Button{

    private int[] position;
    private int currentNum;

    /**
     * Creates a new CellButton with a position, currentNum can be set afterwards (grid starts out with some buttons blank).
     * @param position An array holding the x and y position of the button
     */
    public CellButton(int position[]){
        this.position = position;
        this.currentNum = 0;
        this.setFont(new Font(24));
    }

    /**
     * Creates a new CellButton with a position and number.
     * @param position An array holding the x and y position of the button
     * @param num The number which currentNum is set to
     */
    public CellButton(int[] position, int num){
        this.position = position;
        this.currentNum = num;
    }

    /**
     * Method to set the current number and text of the CellButton
     * @param num The number to set CellButton number to.
     */
    public void setNum(int num){
            this.currentNum = num;
            if (num == 0) {
            	this.setText(" ");
            } else {
            	this.setText(String.valueOf(num));
            }
    }

    /**
     * Method to get the current number of the CellButton
     * @return currentNum
     */
    public int getNum(){
        return this.currentNum;
    }

    /**
     * Method to get the position of the CellButton
     * @return position
     */
    public int[] getPosition(){
        return this.position;
    }

    /**
    * Clear the number at this button
    */
    public void clear(){
            this.currentNum = 0;
    }

    /**
    * Method to print a CellButton (for debugging purposes)
    */
    @Override
    public String toString(){
        return "Value: " + this.currentNum + "Position: " + this.position[0] + ", " + this.position[1];
    }
}
