package gui;

import bge.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import bge.Board;
import games.eelsandescalators.EelsLogic;
import games.eelsandescalators.EelsState;
import games.tictactoe.TicTacToeBoard;
import games.tictactoe.TicTacToeLogic;
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
	protected void playerStatsAlert(){
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("War Games");
		alert.setHeaderText("Player Stats");
		alert.setContentText(null);


		Label label = new Label("Player Info: ");

		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setWrapText(true);

		String text = "";
		for (Iterator iterator = Main.playerProfile.playerJSONMap.keySet().iterator(); iterator.hasNext();){
			String key = (String)iterator.next();
			text += key;
			text += "\n";
			text += Main.playerProfile.playerJSONMap.get(key);
			text += "\n";
		}
		textArea.setText(text);



		textArea.setMaxWidth(Double.MAX_VALUE);
		textArea.setMaxHeight(Double.MAX_VALUE);
		GridPane.setVgrow(textArea, Priority.ALWAYS);
		GridPane.setHgrow(textArea, Priority.ALWAYS);


		GridPane expContent = new GridPane();
		expContent.setMaxWidth(Double.MAX_VALUE);
		expContent.add(label, 0, 0);
		expContent.add(textArea, 0, 1);

// Set expandable Exception into the dialog pane.
		alert.getDialogPane().setExpandableContent(expContent);

		alert.showAndWait();
	}

	@FXML
	protected void quitGame(){

	}



	@FXML
	protected void handlePlayerProfiles(){
		//TODO: Dynamically assessing who's turn it is
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
		   engine = new Engine(logic, board, p1, p2);
		   engine.addState(state);
		   initializeGameScreen(event, board);
	   }
	   
	   else if (gamename.equals("Tic-Tac-Toe")){
		   board = new TicTacToeBoard();
		   logic = new TicTacToeLogic((TicTacToeBoard)board);
		   engine = new Engine(logic, board, p1, p2);
		   initializeGameScreen(event, board);
	   }
   }
 
    @FXML
    protected void handlePlayButtonAction(ActionEvent event) throws Exception {
//    	System.out.println(player1Name.getText() + " vs. " + player2Name.getText());
		handlePlayerProfiles();
		RadioButton selectedGame = (RadioButton)gameSelectGroup.getSelectedToggle();
		BuildEngine(selectedGame.getText(), event);
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
