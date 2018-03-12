package fxml.views;

import BoardLogic.BGE_GUI;
import BoardLogic.Board;
import BoardLogic.CheckerBoard;
import BoardLogic.TestCheckerBoard;
import BoardLogic.TicTacToeBoard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FXMLGameSelectController {

	static Board newBoard; 
	static BGE_GUI bge;
	
    @FXML private Text actiontarget;

    @FXML protected void handleChooseTicTacToe(ActionEvent event){
        actiontarget.setText("Loading Tic Tac Toe Game...");
        Stage primaryStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        newBoard = new TicTacToeBoard();
		bge = new BGE_GUI(newBoard, primaryStage);
		
		bge.updateDisplay(primaryStage);
		bge.display(primaryStage);
		
		bge.mouseClickListener();

    }
    
    @FXML protected void handleChooseCheckers(ActionEvent event){
        actiontarget.setText("Loading Checkers Game...");
        Stage primaryStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        newBoard = new TestCheckerBoard();
		bge = new BGE_GUI(newBoard, primaryStage);
		
		bge.updateDisplay(primaryStage);
		bge.display(primaryStage);
		
		bge.mouseClickListener();
    }
    
    @FXML protected void handleChooseSimonSays(ActionEvent event){
        actiontarget.setText("Loading Simon Says Game...");
    }
    
    @FXML protected void handleChooseEelsAndEscalators(ActionEvent event){
        actiontarget.setText("Loading Eels And Escalators Game...");
    }
}
