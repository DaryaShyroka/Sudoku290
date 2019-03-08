package Sudoku;

import javafx.event.EventHandler;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class contains what the player sees on the Sudoku game window.
 * @author Derek Jang
 *
 */
public class SudokuView extends Application implements EventHandler<ActionEvent> {
	//private Stage stage;
	//private Model model;
	private Controller controller;
	private CellButton currentButton;
	private CellButton[][] boardButtons;
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
		boardButtons = new CellButton[9][9];
		GridPane board = new GridPane();
		
		for (int i = 0; i < 9; i++) {
    		for (int k = 0; k < 9; k++) {
    			int pos[] = {k,i};
    			CellButton btn = new CellButton(pos,true);
				btn.setOnAction(this);
    			btn.setMinSize(50, 50);
    			board.add(btn, i, k);
    			boardButtons[k][i] = btn;
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
		this.controller = new Controller(new SudokuBoard(this));
		
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
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                onKeyPress(event);
            }
        });
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
				System.out.println("I dont know how you did this");
			}	
		}
	}
	
	private void onKeyPress(KeyEvent event) {
		int numberPressed = 0;
		switch (event.getCode()) {
			case DIGIT1:
				numberPressed = 1;
				break;
			case DIGIT2:
				numberPressed = 2;
				break;
			case DIGIT3:
				numberPressed = 3;
				break;
			case DIGIT4:
				numberPressed = 4;
				break;
			case DIGIT5:
				numberPressed = 5;
				break;
			case DIGIT6:
				numberPressed = 6;
				break;
			case DIGIT7:
				numberPressed = 7;
				break;
			case DIGIT8:
				numberPressed = 8;
				break;
			case DIGIT9:
				numberPressed = 9;
				break;
		}
		
		System.out.println(String.valueOf(numberPressed));
		if (numberPressed == 0) {
			System.out.println("Not a number");
		} else if (this.currentButton != null) {
			int pos[] = this.currentButton.getPosition();
			this.controller.updateBoard(pos, numberPressed);
			this.currentButton = null;
		} else {
			System.out.println("Please pick a button first");
		}
	}


	public void update(int value, int x, int y) {
		this.boardButtons[x][y].setNum(value);
	}
}
