package app.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginGUI extends GUIWindow {

    public LoginGUI (Stage stage) {
        super(stage);
        setTitle("LOGIN");
        setxSize(300);
        setySize(200);
        loginScene();
        setStage();
        stage.show();
    }

    private void loginScene(){
        setScene(new Scene(this.loginGrid()));
    }

    private GridPane loginGrid(){
        Text loginLabel = new Text("Enter Username");
        TextField username = new TextField();
        Button loginButton = new Button("Login");

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(this.getxSize(),this.getySize());
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(loginLabel,0,0);
        gridPane.add(username,0,1);
        gridPane.add(loginButton,1,1);

        gridPane.setStyle("-fx-background-color: darkgray");
        return gridPane;
    }



}
