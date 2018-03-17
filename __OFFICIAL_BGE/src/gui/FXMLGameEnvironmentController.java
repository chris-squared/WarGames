package gui;

import bge.Board;
import games.TicTacToeBoard;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLGameEnvironmentController implements Initializable{

    private BGE_GUI bge_gui;

    @FXML
    private GridPane boardgrid;

    @FXML
    private AnchorPane gridPaneParent;

    public void initBGE(BGE_GUI bge){
        bge_gui = bge;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        System.out.println("GameEnvironment Initialized");
        System.out.println(boardgrid.toString());
//        boardgrid.getChildren().clear();
//        boardgrid.getChildren().addAll(new GridPane());
        Board newBoard = new TicTacToeBoard();
//        newBoard.setWindHeight(gridPaneParent.getPrefHeight());
//        newBoard.setWindWidth(gridPaneParent.getPrefWidth());
		BGE_GUI bge = new BGE_GUI(newBoard, gridPaneParent.getPrefHeight(), gridPaneParent.getPrefWidth());
        bge.updateDisplay();
//        gridPaneParent.getChildren().addAll(new GridPane());
//        gridPaneParent.getChildren().clear();
//        BoardController boardController = new BoardController();
//        gridPaneParent.getChildren().setAll(boardController.createContent(newBoard));
        gridPaneParent.getChildren().clear();
       
        //bge.getGrid().setPrefWidth(gridPaneParent.getPrefWidth());
       
        //bge.getGrid().setPrefHeight(gridPaneParent.getPrefHeight());
        gridPaneParent.getChildren().addAll(bge.getGrid());
//        boardgrid.getChildren().clear();
//        boardgrid.setPrefHeight(gridPaneParent.getPrefHeight());
//        boardgrid.setPrefWidth(gridPaneParent.getPrefWidth());
//
//        boardgrid.getChildren().addAll(bge.getGrid());
////
		bge.mouseClickListener();
    }

}
