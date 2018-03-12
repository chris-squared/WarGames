package fxml.views;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FXMLLoginController {
    @FXML private Text actiontarget;

    @FXML protected void handleSubmitButtonAction(ActionEvent event) throws IOException{
        //actiontarget.setText("Button Pressed");
        
        Parent homePageParent = FXMLLoader.load(getClass().getResource("/resources/gameselectview.fxml"));
        Scene homePageScene = new Scene(homePageParent);
        Stage appStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        appStage.setScene(homePageScene);
        appStage.show();
    }
}
