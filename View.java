import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class View implements EventHandler<ActionEvent> {
	private Stage stage;
	
	public View(Stage stage) {
		this.stage = stage;
		initUI(stage);
	}
	
	private void initUI(Stage stage){
		// TODO Auto-generated method stub
		stage.setTitle("Sudoku290");
		VBox left = new VBox();
		Button button1 = new Button("New Game");
		Button button2 = new Button("Clear");
		Button button3 = new Button("Check");
		left.getChildren().addAll(button1, button2, button3);
		
	    BorderPane layout = new BorderPane();
	    layout.setLeft(left);
	    
	    Scene scene = new Scene(layout);
	    stage.setScene(scene);
	    stage.show();
	} 
	

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

}
