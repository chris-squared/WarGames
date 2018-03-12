package fxml.views;

import BoardLogic.BGE_GUI;
import BoardLogic.Board;
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
    }
    
    @FXML protected void handleChooseCheckers(ActionEvent event){
        actiontarget.setText("Loading Checkers Game...");
        Stage primaryStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
		newBoard = new Board("Test Checkers",8,8,500,500);
		// 
		bge = new BGE_GUI(newBoard, primaryStage);
		
		bge.createDisplay(primaryStage);
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
