package gui;

import gui.BGE_GUI;
import bge.Board;
import games.TicTacToeBoard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class FXMLGUIController{
    static Board newBoard;
    static BGE_GUI bge;

    @FXML
    private TextField player1Name;

    @FXML
    private TextField player2Name;

    @FXML
    private ToggleGroup gameSelectGroup;

    @FXML
    private GridPane boardgrid;

    @FXML
    private AnchorPane gameView;

    @FXML
    protected void handlePlayButtonAction(ActionEvent event) throws Exception {
//    	System.out.println(player1Name.getText() + " vs. " + player2Name.getText());
        RadioButton selectedGame = (RadioButton)gameSelectGroup.getSelectedToggle();
        if(selectedGame.getText().equals("Tic-Tac-Toe")) {
            handleChooseTicTacToe(event);
        }
    }

    @FXML protected void handleChooseTicTacToe(ActionEvent event) throws Exception{
        Stage primaryStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
//        newBoard = new TicTacToeBoard();
//        bge = new BGE_GUI(newBoard, boardgrid);
//        bge.setBoardGrid();
//        bge.updateDisplay(primaryStage);
//        bge.display(primaryStage);

//        bge.mouseClickListener();

    }

    @FXML protected void handleChooseCheckers(ActionEvent event){
    }

    @FXML protected void handleChooseSimonSays(ActionEvent event){
    }

    @FXML protected void handleChooseEelsAndEscalators(ActionEvent event){
    }

}
