package gui;

import bge.Board;
import games.TicTacToeBoard;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

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
		BGE_GUI bge = new BGE_GUI(newBoard);
        bge.updateDisplay();
        boardgrid.getChildren().clear();
        boardgrid.getChildren().addAll(bge.getGrid());
//		bge.updateDisplay();
//		bge.display();

		bge.mouseClickListener();
    }

}
