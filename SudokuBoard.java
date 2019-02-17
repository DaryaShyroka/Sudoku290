import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class SudokuBoard extends GridPane{
	
	public SudokuBoard(){
		
    	for (int i = 0; i < 9; i++) {
    		for (int k = 0; k < 9; k++) {
    			Button btn = new Button();
    			btn.setMinSize(50, 50);
    			this.add(btn, i, k);   		
    		}
    	}		
	}
}