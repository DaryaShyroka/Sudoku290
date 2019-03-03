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

public class CellButton extends Button{

    private int[] position;
    private int currentNum;
    private Boolean changeable;
    private Controller controller;
    
    /**
     * Constructor with mandatory parameters.
     * Position and changeability must be set, number can be set afterwards (grid starts out with some buttons blank).
     *
     * @param position
     * @param changeable
     * @param controller
     */
    public CellButton(int[] position, Boolean changeable, controller){
        this.position = position;
        this.currentNum = null;
        this.changeable = changeable;
        this.controller = controller;
    }

    /**
     * Constructor with all parameters set, including currentNum.
     *
     * @param position
     * @param currentNum
     * @param changeable
     * @param controller
     */
    public CellButton(int[] position, int num, Boolean changeable, controller){
        this.position = position;
        this.currentNum = num;
        this.changeable = changeable;
        this.controller = controller;
    }

    /**
     * Method to set the current number of the CellButton
     *
     * @param num
     */
    public void setNum(int num){
        this.currentNum = num;
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
        this.currentNum = null;
    }

    /**
    * Method to print a CellButton (for debugging purposes)
    */
    @Override
    public String toString(){
        return "Value: " + this.currentNum + "Position: " + this.position[0] + ", " + this.position[1] + "Changeable: " + this.changeable; 
    }
}