package Sudoku;

import javafx.event.EventHandler;

import java.awt.Color;

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
import javafx.geometry.Insets;

/**
 * This class contains what the player sees on the Sudoku game window.
 * @authors Derek Jang, Ikjot Dhillon, Saadaf Chowdhury, Sam Newby, Darya Shyroka, Daniel Ceniceros
 *
 */
public class SudokuView extends Application implements EventHandler<ActionEvent> {

	private Controller controller;
	private CellButton currentButton;
	private CellButton[][] boardButtons;
	
	/** 
	 * Launches the game.
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Initializes a stage for the Sudoku game window.
	 * @param stage What is displayed on the screen.
	 */
	@Override
	public void start(Stage stage) throws Exception {
		this.initUI(stage);	
	}
	
	/**
	 * Creates and returns a gridPane object containing CellButtons that numbers 
	 * can be placed into.
	 * @return: GridPane for numbers. 
	*/
	private GridPane makeBoard() {
		boardButtons = new CellButton[9][9];
		GridPane board = new GridPane();
		
		for (int i = 0; i < 9; i++) {
    		for (int k = 0; k < 9; k++) {
    			int pos[] = {k,i};
    			CellButton btn = new CellButton(pos);
				btn.setOnAction(this);
    			btn.setMinSize(50, 50);
    			board.add(btn, i, k);
    			boardButtons[k][i] = btn;
    			int btnLeftMargin = 0;
    			int btnTopMargin = 0;
    			if(i==3||i==6) {
    				btnLeftMargin = 10;
    			}else if(i==0){
    				btnLeftMargin = 15;
    			}
    			if(k==3||k==6) {
    				btnTopMargin = 10;
    			}
    			board.setMargin(btn,new Insets(btnTopMargin,0,0,btnLeftMargin));
    		}
    	}
		
		return board;
	}	
	
	/**
	 * Takes a stage and creates the Sudoku game control buttons. 
	 * @param stage: what is displayed on the screen.
	 */
	private void initUI(Stage stage) {
		stage.setTitle("Sudoku290");
		this.controller = new Controller(new SudokuBoard(this));
		
		VBox leftPanel = new VBox();
		
		Button newGame = new Button("New Game");
		newGame.setOnAction(this);
		newGame.setStyle("-fx-font-size:20");
		newGame.setMinSize(125, 50);
		
		Button clear = new Button("Clear");
		clear.setOnAction(this);
		clear.setStyle("-fx-font-size:20");
		clear.setMinSize(125, 50);
		
		Button check = new Button("Check");
		check.setOnAction(this);
		check.setStyle("-fx-font-size:20");
		check.setMinSize(125, 50);
		
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
		this.controller.newGame();
		stage.setScene(scene);
		stage.show();
	}
	
	/**
	 * Handles the player's interaction with the control buttons. 
	 * @param event: an ActionEvent with the buttons. 
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
	
	/**
	 * If a key is pressed and a button is selected, changes that cell's value to the
	 * number pressed and updates the view.
	 * @param event: KeyEvent indicating user has typed a character.
	 */
	private void onKeyPress(KeyEvent event) {
		int numberPressed = -1;
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
			case BACK_SPACE:
				numberPressed = 0;
				break;
		}
		
		System.out.println(String.valueOf(numberPressed));
		if (numberPressed == -1) {
			System.out.println("Not a number");
		} else if (this.currentButton != null) {
			int pos[] = this.currentButton.getPosition();
			this.controller.updateBoard(pos, numberPressed, false);
			this.currentButton = null;
		} else {
			System.out.println("Please pick a button first");
		}
	}

    /**
     * Set the number at position (x,y) in this.boardButtons to the value given
     * by the user.
     * @param value: the value the user typed.
     * @param x: x-coordinate of the cell.
     * @param y: y-coordinate of the cell.
     */
	public void update(int value, int x, int y) {
		if(!this.controller.currentBoard.notChangable[x][y]) {
			this.boardButtons[x][y].setStyle("-fx-text-fill: blue");
		}else{
			this.boardButtons[x][y].setStyle("-fx-text-fill: black");
		}
		this.boardButtons[x][y].setNum(value);
	}
}
