package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import gui.BGE_GUI;
import bge.Board;
import games.TicTacToeBoard;

public class FXMLInitialViewController implements Initializable{
	
	static Board newBoard; 
	static BGE_GUI bge;
	
	@FXML
	private TextField player1Name;
	
	@FXML
	private TextField player2Name;
	
	@FXML
	private ToggleGroup gameSelectGroup;
	
    @FXML
    protected void handlePlayButtonAction(ActionEvent event) throws Exception {
//    	System.out.println(player1Name.getText() + " vs. " + player2Name.getText());
    	RadioButton selectedGame = (RadioButton)gameSelectGroup.getSelectedToggle();
    	if(selectedGame.getText().equals("Tic-Tac-Toe")) {
    		handleChooseTicTacToe(event);
    	}
    	
    	else if (selectedGame.getText().equals("Simon Says")) {
    		handleChooseSimonSays(event);
    	}
    }
    
    @FXML protected void handleChooseTicTacToe(ActionEvent event) throws Exception{
        Stage primaryStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/gui/GameEnvironment.fxml"));
		Parent root = loader.load();
		primaryStage.setTitle("War Games");
		primaryStage.setScene(new Scene(root, 1000, 800));
		primaryStage.show();
//        newBoard = new TicTacToeBoard();
//		bge = new BGE_GUI(newBoard, primaryStage);
//
//		bge.updateDisplay(primaryStage);
//		bge.display(primaryStage);
//
//		bge.mouseClickListener();

    }
    
    @FXML protected void handleChooseCheckers(ActionEvent event){
    }
    
    @FXML protected void handleChooseSimonSays(ActionEvent event) throws Exception{
        Stage primaryStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/gui/GameEnvironment.fxml"));
		Parent root = loader.load();
		primaryStage.setTitle("War Games");
		primaryStage.setScene(new Scene(root, 1000, 800));
		primaryStage.show();
    }
    
    @FXML protected void handleChooseEelsAndEscalators(ActionEvent event){
    }

    @Override
	public void initialize(URL url, ResourceBundle resourceBundle){
    	System.out.println("INITIALIZED INITIAL VIEW");

	}
}
