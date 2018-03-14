package main;
import board_gui.BGE_GUI;
import board_gui.Board;
import boardgamerepo.TicTacToeBoard;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Main extends Application{

	static Board newBoard; 
	static BGE_GUI bge;
	
	public static void main(String[] args) {
        Application.launch(args);
    }
	
	
	@Override 
	public void start (Stage primaryStage) {
		
		// TEST
		newBoard = new TicTacToeBoard();
		// 
		bge = new BGE_GUI(newBoard, primaryStage);
		
		bge.startDisplay(primaryStage);
		bge.display(primaryStage);
		
		bge.mouseClickListener();
	}
	
}