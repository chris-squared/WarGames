package gui;

import bge.Board;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLGameEnvironmentController implements Initializable{

    private BGE_GUI bge;
    private Board newBoard;

    @FXML
    private GridPane boardgrid;

    @FXML
    private AnchorPane gridPaneParent;

    @FXML
    private Label playerTurn;

    @FXML
    private Label player1Name;

    @FXML
    private Label player2Name;

    public FXMLGameEnvironmentController(Board newBoard){
        System.out.println("GameEnvironmentController set the new board");
        this.newBoard = newBoard;
    }

    @FXML
    public String getPlayerTurn(){
        return playerTurn.getText();
    }

    @FXML
    public void setPlayerTurn(String playerName){
        playerTurn.setText(playerName);
    }

    @FXML
    public void setPlayer1Name(String name){
        player1Name.setText(name);
    }

    @FXML
    public void setPlayer2Name(String name){
        player2Name.setText(name);
    }

    @FXML
    protected void whosTurn(){
        if (newBoard.turn % 2 == 0){
            setPlayerTurn(player1Name.getText());
        }else{
            setPlayerTurn(player2Name.getText());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        System.out.println("GameEnvironment Initialized");
		bge = new BGE_GUI(newBoard, gridPaneParent.getPrefHeight(), gridPaneParent.getPrefWidth());
        bge.updateDisplay();
        gridPaneParent.getChildren().clear();
        gridPaneParent.getChildren().addAll(bge.getGrid());
		bge.mouseClickListener();
        bge.getGrid().addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                whosTurn();
            }
        });

    }

}
