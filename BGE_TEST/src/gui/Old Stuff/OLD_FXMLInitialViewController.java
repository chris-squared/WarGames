package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

import bge.Board;
import games.EelsAndEscalatorsBoard;
import games.TicTacToeBoard;

public class OLD_FXMLInitialViewController {
	
	static Board newBoard; 
	static BGE_GUI bge;
	
	@FXML
	private TextField player1Name;
	
	@FXML
	private TextField player2Name;
	
	@FXML
	private ToggleGroup gameSelectGroup;
	
    @FXML
    protected void handlePlayButtonAction(ActionEvent event) throws IOException {
    	System.out.println(player1Name.getText() + " vs. " + player2Name.getText());
    	RadioButton selectedGame = (RadioButton)gameSelectGroup.getSelectedToggle();
    	if(selectedGame.getText().equals("Tic-Tac-Toe")) {
    		handleChooseTicTacToe(event);
    	}
    	if(selectedGame.getText().equals("Electic Eels and Super Escalators 2: Super Ultra Force")) {
    		handleChooseEelsAndEscalators(event);
    	}
    }
    
    @FXML protected void handleChooseTicTacToe(ActionEvent event){
        Stage primaryStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        newBoard = new TicTacToeBoard();
		bge = new BGE_GUI(newBoard, primaryStage);
		
		bge.updateDisplay(primaryStage);
		bge.display(primaryStage);
		
		bge.mouseClickListener();

    }
    
    @FXML protected void handleChooseCheckers(ActionEvent event){
    }
    
    @FXML protected void handleChooseSimonSays(ActionEvent event){
    }
    
    @FXML protected void handleChooseEelsAndEscalators(ActionEvent event){
    	Stage primaryStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        newBoard = new EelsAndEscalatorsBoard();
		bge = new BGE_GUI(newBoard, primaryStage);
		
		bge.updateDisplay(primaryStage);
		bge.display(primaryStage);
		
		bge.mouseClickListener();

    }
}
