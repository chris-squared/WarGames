
package main;
import java.io.IOException;

//import bge.Board;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	public static void main(String[] args) {
        Application.launch(args);
    }
	
	
	@Override 
	public void start (Stage primaryStage) throws IOException {
		// Jerry Board in NewBoard package
        // Launch like so:
//        Board board = new Board(500,500,3,3);
//        Scene scene = new Scene(board, board.getPrefWidth(), board.getPrefHeight());
//        board.drawBoard();
//        primaryStage.setScene(scene);
//        primaryStage.show();



	    // Below is to run environment
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/gui/InitialView.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("War Games");
        primaryStage.setScene(new Scene(root, 450, 450));
        primaryStage.show();

	}
	

}