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
		newBoard = new Board("Test Checkers",8,8,500,500);
		// 
		bge = new BGE_GUI(newBoard, primaryStage);
		
		bge.createDisplay(primaryStage);
		bge.display(primaryStage);
		
		bge.mouseClickListener();
		
	}
	
}