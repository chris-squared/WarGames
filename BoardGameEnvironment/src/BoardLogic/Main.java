package BoardLogic;
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
		newBoard = new TestCheckerBoard();
		// 
		bge = new BGE_GUI(newBoard, primaryStage);
		
		bge.updateDisplay(primaryStage);
		bge.display(primaryStage);
		
		bge.mouseClickListener();
		
	}
	
}