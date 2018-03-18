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
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import bge.Board;
import games.TicTacToeBoard;
import games.CheckersBoard;
import games.SimonSaysBoard;


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
    	else if(selectedGame.getText().equals("Checkers")) {
    		handleChooseCheckers(event);
    	}
    	else if (selectedGame.getText().equals("Simon Says")) {
    		handleChooseSimonSays(event);
    	}
    	else if (selectedGame.getText().equals("EelsAndEscalators")){
    		handleChooseEelsAndEscalators(event);
		}
		else{
    		System.out.println("GAME NOT SELECTED IDIOT!");
		}
    }
    
    @FXML protected void handleChooseTicTacToe(ActionEvent event) throws Exception{
        initializeGameScreen(event, new TicTacToeBoard());
    }
    
    @FXML protected void handleChooseCheckers(ActionEvent event) throws Exception{
    	initializeGameScreen(event, new CheckersBoard());
    }
    
    @FXML protected void handleChooseSimonSays(ActionEvent event) throws Exception{
        initializeGameScreen(event, new SimonSaysBoard());
    }
    
    @FXML protected void handleChooseEelsAndEscalators(ActionEvent event){
    	System.out.println("EELS AND EXCALATORS");
    }

    @Override
	public void initialize(URL url, ResourceBundle resourceBundle){
    	System.out.println("INITIALIZED INITIAL VIEW");

	}

	public void initializeGameScreen(ActionEvent event, Board newBoard) throws Exception{
		Stage primaryStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/gui/GameEnvironment.fxml"));

		// Create controller instance and pass it to the fxml file that was loaded
		FXMLGameEnvironmentController controller = new FXMLGameEnvironmentController(newBoard);
		loader.setController(controller);
		Parent root = loader.load();

		primaryStage.setTitle("War Games");
		primaryStage.setScene(new Scene(root, 1000, 800));
		primaryStage.show();
	}


}
