package gui;

import bge.Player;
import javafx.application.Platform;
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
import games.eelsandescalators.EelsLogic;
import games.eelsandescalators.EelsState;
import games.CheckersBoard;
import games.EelsAndEscalatorsBoard;
import games.SimonSaysBoard;
import main.Main;
import utility.Engine;
import utility.Logic;


public class FXMLInitialViewController implements Initializable{
	Engine engine;
	static Board newBoard; 
	static BGE_GUI bge;

	@FXML
	private TextField player1Name;
	
	@FXML
	private TextField player2Name;
	
	@FXML
	private ToggleGroup gameSelectGroup;

	@FXML
	protected void handlePlayerProfiles(){
		//TODO: Dynamically assing whos turn it is
		Main.player1.setUsername(player1Name.getText());
		Main.player2.setUsername(player2Name.getText());
		Main.player1.setTurn(1);
		Main.player2.setTurn(2);
	}
   protected void  BuildEngine(String gamename, ActionEvent event) throws Exception {
	   Player p1 = new Player(player1Name.getText(), 0, "X");
	   Player p2 = new Player(player2Name.getText(), 1, "T");
	   Logic logic;
	   Board board;
	   if (gamename.equals("Electric Eels and Super Escalators 2: Super Ultra Force")) {
		  
		   board = new EelsAndEscalatorsBoard();
		   EelsState state = new EelsState((EelsAndEscalatorsBoard)board, p1, p2);
		   logic = new EelsLogic(state, (EelsAndEscalatorsBoard)board);
		   engine = new Engine(state, logic, board, p1, p2);
		   initializeGameScreen(event, board);
	   }
	   
	   
		   
   }
 

    @FXML
    protected void handlePlayButtonAction(ActionEvent event) throws Exception {
//    	System.out.println(player1Name.getText() + " vs. " + player2Name.getText());
		handlePlayerProfiles();
		RadioButton selectedGame = (RadioButton)gameSelectGroup.getSelectedToggle();
		BuildEngine(selectedGame.getText(), event);
    	
    	// BuildEngine OR Engine.Build(selectedGame.getText()
    	//Here's the game we want to play, load up the right logic and board, and shove it up your engine
    	
    	/*if(selectedGame.getText().equals("Tic-Tac-Toe")) {
    		handleChooseTicTacToe(event);
    	}
    	else if(selectedGame.getText().equals("Checkers")) {
    		handleChooseCheckers(event);
    	}
    	else if (selectedGame.getText().equals("Simon Says")) {
    		handleChooseSimonSays(event);
    	}
    	else if (selectedGame.getText().equals("Electric Eels and Super Escalators 2: Super Ultra Force")){
    		handleChooseEelsAndEscalators(event);
		}
		else{
    		System.out.println("GAME NOT SELECTED IDIOT!");
		}*/
    }
    
    @FXML protected void handleChooseTicTacToe(ActionEvent event) throws Exception{
        initializeGameScreen(event, new TicTacToeBoard());
    }
    
    @FXML protected void handleChooseCheckers(ActionEvent event) throws Exception{
    	initializeGameScreen(event, new CheckersBoard());
    }
    
    @FXML protected void handleChooseSimonSays(ActionEvent event) throws Exception{
        //initializeGameScreen(event, new engine(new SimonSaysBoard()));
    }
    
    @FXML protected void handleChooseEelsAndEscalators(ActionEvent event) throws Exception{
    	//initializeGameScreen(event, new EelsAndEscalatorsBoard());
    }

    @Override
	public void initialize(URL url, ResourceBundle resourceBundle){
    	System.out.println("INITIALIZED INITIAL VIEW");

	}

	public void initializeGameScreen(ActionEvent event, Board newBoard) throws Exception{
		Stage primaryStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/resources/GameEnvironment.fxml"));

		// Create controller instance and pass it to the fxml file that was loaded
		FXMLGameEnvironmentController controller = new FXMLGameEnvironmentController(newBoard, primaryStage);
		controller.setEngine(engine);
		loader.setController(controller);
		Parent root = loader.load();
		controller.setPlayer1Name(Main.player1.getUsername());
		controller.setPlayer2Name(Main.player2.getUsername());
		controller.setPlayerTurn(Main.player1.getUsername());

		primaryStage.setTitle("War Games");
		primaryStage.setScene(new Scene(root, 1000, 800));
		primaryStage.show();
	}


}
