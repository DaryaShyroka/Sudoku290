import javafx.scene.control.*;

public class CellButton extends Button{

    private int[] position;
    private int currentNum;
    private bool changeable;
    private Controller controller;
    
    /**
     * Constructor with mandatory parameters.
     * Position and changeability must be set, number can be set afterwards (grid starts out with some buttons blank).
     *
     * @param position
     * @param changeable
     */
    public (int[] position, bool changeable){
        this.position = position;
        this.changeable = changeable;
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
    public num getNum(){
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

    /**
    * Method to print a CellButton (for debugging purposes)
    */
    @Override
    public String toString(){
        return "Value: " + this.currentNum + "Position: " + this.position[0] + ", " + this.position[1] + "Changeable: " + this.changeable; 
    }
}