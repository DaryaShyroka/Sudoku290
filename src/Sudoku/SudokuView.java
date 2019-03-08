package Sudoku;

import javafx.event.EventHandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class contains what the player sees on the Sudoku game window.
 * @author Derek Jang
 *
 */
public class SudokuView extends Application implements EventHandler<ActionEvent>, KeyListener {
	//private Stage stage;
	//private Model model;
	private Controller controller;
	private CellButton currentButton;
	/**
	 * Initializes a stage for the Sudoku game window.
	 * @param stage What is displayed on the screen.
	 */
	
	
	/** 
	 * Launches the game.
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	
	@Override
	public void start(Stage stage) throws Exception {
		this.initUI(stage);	
	}
	
	private GridPane makeBoard() {
		CellButton buttons[][] = new CellButton[9][9];
		GridPane board = new GridPane();
		
		for (int i = 0; i < 9; i++) {
    		for (int k = 0; k < 9; k++) {
    			int[] position = {i, k};
    			Button btn = new CellButton(position, true);
				btn.setOnAction(this);
    			btn.setMinSize(50, 50);
    			board.add(btn, i, k);
    		}
    	}
		
		return board;
	}
	
	
	/*public SudokuView(Stage stage) {
		//this.model = model;
		this.stage = stage;
		initUI(stage);
	}*/
	
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
		border.setRight(makeBoard());
		
		Scene scene = new Scene(border);
		stage.setScene(scene);
		stage.show();
	}
	
	/**
	 * Handles the player's interaction with the control buttons. 
	 * @param event An ActionEvent with the buttons. 
	 */
	public void handle(ActionEvent event) {
		if (event.getSource().getClass() == CellButton.class) {
			this.currentButton = ((CellButton) event.getSource());
		} else {
			String click = ((Button) event.getSource()).getText();
			if(click == "New Game") {
				this.controller.newGame();
			}
			else if(click == "Clear") {
				this.controller.clear();
			}
			else if(click == "Check") {
				this.controller.check();
			} else {
				
			}	
		}
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
