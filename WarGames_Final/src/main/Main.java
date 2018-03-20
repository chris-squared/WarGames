
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
    public static Player player1 = new Player();
    public static Player player2 = new Player();

	public static void main(String[] args) {
        Application.launch(args);
        playerProfile.addPlayer(player1);
        playerProfile.addPlayer(player2);
        playerProfile.writeToFile();
        System.out.println("Exiting Application in main... Goodbye.");
    }
	
	
	@Override 
	public void start (Stage primaryStage) throws IOException {

	    // Below is to run environment
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/InitialView.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("War Games");
        primaryStage.setScene(new Scene(root, 640, 400));
        primaryStage.show();

	}
	

}