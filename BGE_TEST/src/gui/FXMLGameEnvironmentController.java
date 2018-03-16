package gui;

import bge.Board;
import games.TicTacToeBoard;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLGameEnvironmentController implements Initializable{

    private BGE_GUI bge_gui;

//    @FXML
//    private GridPane boardgrid;

    @FXML
    private AnchorPane gridPaneParent;

    private NewBoard.Board board;
//    public void initBGE(BGE_GUI bge){
//        bge_gui = bge;
//    }

    public AnchorPane getGridPaneParent(){
        return gridPaneParent;
    }

    public void setGridPaneParent(NewBoard.Board gridPane){
        gridPaneParent.getChildren().addAll(gridPane);
        board = gridPane;
    }

    public double getAnchorWidth(){
        return gridPaneParent.getPrefWidth();
    }

    public double getAnchorHeight(){
        return gridPaneParent.getPrefHeight();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        System.out.println("GameEnvironment Initialized");
//        System.out.println(boardgrid.toString());
//        gridPaneParent.getChildren().clear();
//        gridPaneParent.getChildren().addAll(board);
//        boardgrid.getChildren().clear();
//        boardgrid.getChildren().addAll(new GridPane());

//        newBoard.setWindHeight(gridPaneParent.getPrefHeight());
//        newBoard.setWindWidth(gridPaneParent.getPrefWidth());
<<<<<<< HEAD
        //KEEP
//        Board newBoard = new TicTacToeBoard();
//        BGE_GUI bge = new BGE_GUI(newBoard);
//        bge.updateDisplay();
        //END KEEP
=======
		BGE_GUI bge = new BGE_GUI(newBoard, gridPaneParent.getPrefHeight(), gridPaneParent.getPrefWidth());
        bge.updateDisplay();
>>>>>>> Separated-bge_gui-and-board-more.-X's-and-O's-added-for-tic-tack-toe
//        gridPaneParent.getChildren().addAll(new GridPane());
//        gridPaneParent.getChildren().clear();
//        BoardController boardController = new BoardController();
//        gridPaneParent.getChildren().setAll(boardController.createContent(newBoard));
<<<<<<< HEAD

        //KEEP
//        gridPaneParent.getChildren().clear();
//        bge.getGrid().setPrefWidth(gridPaneParent.getPrefWidth());
//        bge.getGrid().setPrefHeight(gridPaneParent.getPrefHeight());
//        gridPaneParent.getChildren().addAll(bge.getGrid());
        //END KEEP
=======
        gridPaneParent.getChildren().clear();
       
        //bge.getGrid().setPrefWidth(gridPaneParent.getPrefWidth());
       
        //bge.getGrid().setPrefHeight(gridPaneParent.getPrefHeight());
        gridPaneParent.getChildren().addAll(bge.getGrid());
>>>>>>> Separated-bge_gui-and-board-more.-X's-and-O's-added-for-tic-tack-toe
//        boardgrid.getChildren().clear();
//        boardgrid.setPrefHeight(gridPaneParent.getPrefHeight());
//        boardgrid.setPrefWidth(gridPaneParent.getPrefWidth());
//
//        boardgrid.getChildren().addAll(bge.getGrid());
////
        //KEEP
//		bge.mouseClickListener();
    }

}
