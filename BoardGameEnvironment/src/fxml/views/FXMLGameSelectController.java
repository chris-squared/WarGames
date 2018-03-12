package fxml.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class FXMLGameSelectController {
    @FXML private Text actiontarget;

    @FXML protected void handleChooseTicTacToe(ActionEvent event){
        actiontarget.setText("Loading Tic Tac Toe Game...");
    }
    
    @FXML protected void handleChooseConnectFour(ActionEvent event){
        actiontarget.setText("Loading Connect Four Game...");
    }
    
    @FXML protected void handleChooseSimonSays(ActionEvent event){
        actiontarget.setText("Loading Simon Says Game...");
    }
    
    @FXML protected void handleChooseEelsAndEscalators(ActionEvent event){
        actiontarget.setText("Loading Eels And Escalators Game...");
    }
}
