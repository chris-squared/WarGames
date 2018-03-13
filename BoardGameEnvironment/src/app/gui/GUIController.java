package app.gui;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUIController extends Application{

    @Override
    public void start(Stage stage) throws Exception{
//        LoginGUI loginGUI = new LoginGUI(stage);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/InitialView.fxml"));
        Parent root = loader.load();
        stage.setTitle("My New Stage Title");
        stage.setScene(new Scene(root, 450, 450));
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
