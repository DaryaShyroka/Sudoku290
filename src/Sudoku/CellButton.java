package Sudoku;

/*
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

public class CellButton extends Button{

    private int[] position;
    private int currentNum;

    /**
     * Constructor with mandatory parameters.
     * Position set, currentNum can be set afterwards (grid starts out with some buttons blank).
     *
     * @param position
     */
    public CellButton(int position[]){
        this.position = position;
        this.currentNum = 0;
        this.setFont(new Font(24));
    }

    /**
     * Constructor with all parameters set, including currentNum.
     *
     * @param position
     * @param num
     */
    public CellButton(int[] position, int num){
        this.position = position;
        this.currentNum = num;
    }

    /**
     * Method to set the current number of the CellButton
     *
     * @param num
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
     *
     * @return currentNum
     */
    public int getNum(){
        return this.currentNum;
    }

    /**
     * Method to get the position of the CellButton
     *
     * @return position
     */
    public int[] getPosition(){
        return this.position;
    }

    /*
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
