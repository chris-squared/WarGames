package fxml.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMLInitialViewController {
    @FXML
    protected void handlePlayButtonAction(ActionEvent event) throws IOException {
        //actiontarget.setText("Button Pressed");

        Parent homePageParent = FXMLLoader.load(getClass().getResource("/resources/gameselectview.fxml"));
        Scene homePageScene = new Scene(homePageParent);
        Stage appStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        appStage.setScene(homePageScene);
        appStage.show();
    }
}
