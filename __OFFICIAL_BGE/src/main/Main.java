
package main;
import java.io.IOException;

//import bge.Board;
import bge.Player;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utility.PlayerProfile;

public class Main extends Application{

    public static PlayerProfile playerProfile = new PlayerProfile();

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


//        PlayerProfile pp = new PlayerProfile();
//        Player pablo = new Player("Pablo");
//        pp.addPlayer(pablo);
//        pp.printJSON();
//        pp.printJSON();
//        pp.writeToFile();


	    // Below is to run environment
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/InitialView.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("War Games");
        primaryStage.setScene(new Scene(root, 450, 450));
        primaryStage.setOnHidden(e -> {
            playerProfile.writeToFile();
            System.out.println("Exiting Application... Goodbye.");
            Platform.exit();
        });
        primaryStage.show();

	}
	

}