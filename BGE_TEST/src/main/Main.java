
package main;
import java.io.IOException;

import bge.Board;
import games.EelsAndEscalatorsBoard;
import games.TicTacToeBoard;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Main extends Application{
	
	public static void main(String[] args) {
        Application.launch(args);
    }
	
	
	@Override 
	public void start (Stage primaryStage) throws IOException {
<<<<<<< HEAD
		// Jerry Board in NewBoard package
        // Launch like so:
//        Board board = new Board(500,500,3,3);
//        Scene scene = new Scene(board, board.getPrefWidth(), board.getPrefHeight());
//        board.drawBoard();
//        primaryStage.setScene(scene);
//        primaryStage.show();



<<<<<<< HEAD
//	     Below is to run environment
=======
		
>>>>>>> parent of fb04ef1... Created new board class that extends GridPane to allow for easy resizing. You can specify listeners in the tile class to handle specific task. Tic tac toe can easily be implemented with listeners. Right click for x left click for o
=======
	    // Below is to run environment
>>>>>>> Separated-bge_gui-and-board-more.-X's-and-O's-added-for-tic-tack-toe
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/gui/InitialView.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("War Games");
        primaryStage.setScene(new Scene(root, 450, 450));
        primaryStage.show();
<<<<<<< HEAD
<<<<<<< HEAD

=======
		
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("/resources/InitialView.fxml"));
//        Parent root = loader.load();
//        primaryStage.setTitle("War Games");
//        primaryStage.setScene(new Scene(root, 450, 450));
//        primaryStage.show();
//        newBoard = new EelsAndEscalatorsBoard();
//        bge = new BGE_GUI(newBoard, primaryStage);
//        bge.startDisplay(primaryStage);
//        bge.display(primaryStage);
//    	bge.mouseClickListener();
        /*
		newBoard = new TicTacToeBoard();
		
		bge = new BGE_GUI(newBoard, primaryStage);
		
		bge.startDisplay(primaryStage);
		bge.display(primaryStage);
		
		bge.mouseClickListener();
		*/
>>>>>>> parent of fb04ef1... Created new board class that extends GridPane to allow for easy resizing. You can specify listeners in the tile class to handle specific task. Tic tac toe can easily be implemented with listeners. Right click for x left click for o
=======

>>>>>>> Separated-bge_gui-and-board-more.-X's-and-O's-added-for-tic-tack-toe
	}
	

}