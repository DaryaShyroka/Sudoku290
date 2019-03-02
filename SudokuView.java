import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class contains what the player sees on the Sudoku game window.
 * @author Derek Jang
 *
 */
public class SudokuView implements EventHandler<ActionEvent> {
	
	private Stage stage;
	//private Model model;
	/**
	 * Initializes a stage for the Sudoku game window.
	 * @param stage What is displayed on the screen.
	 */
	public SudokuView(Stage stage) {
		//this.model = model;
		this.stage = stage;
		initUI(stage);
	}
	
	/**
	 * Takes a stage and creates the Sudoku game control buttons. 
	 * @param stage What is displayed on the screen.
	 */
	private void initUI(Stage stage) {
		
		stage.setTitle("Sudoku290");
		
		VBox leftPanel = new VBox();
		
		Button newGame = new Button("New Game");
		newGame.setOnAction(this);
		
		Button clear = new Button("Clear");
		clear.setOnAction(this);
		
		Button check = new Button("Check");
		check.setOnAction(this);
		
		leftPanel.getChildren().addAll(newGame, clear, check);
		
		BorderPane border = new BorderPane();
		border.setLeft(leftPanel);
		
		Scene scene = new Scene(border);
		stage.setScene(scene);
		stage.show();
	}
	
	/**
	 * Handles the player's interaction with the control buttons. 
	 * @param event An ActionEvent with the buttons. 
	 */
	public void handle(ActionEvent event) {
		String click = ((Button) event.getSource()).getText();
		if(click == "New Game") {
			
		}
		else if(click == "Clear") {
			
		}
		else if(click == "Check") {
			
		}
	}
}
