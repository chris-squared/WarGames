package gui;

import bge.Board;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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


    public FXMLGameEnvironmentController(Board newBoard){
        System.out.println("GameEnvironmentController set the new board");
        this.newBoard = newBoard;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        System.out.println("GameEnvironment Initialized");
		bge = new BGE_GUI(newBoard, gridPaneParent.getPrefHeight(), gridPaneParent.getPrefWidth());
        bge.updateDisplay();
        gridPaneParent.getChildren().clear();
        gridPaneParent.getChildren().addAll(bge.getGrid());
		bge.mouseClickListener();

    }

}
