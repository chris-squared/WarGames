package BoardLogic;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class BGE_GUI {

	
	Board board;
	GridPane grid;
	Scene scene;
	Stage primaryStage;
	
	Coord lastClicked;
	
	BGE_GUI(Board b, Stage primaryStage) {
		board 	= b;
		grid 	= new GridPane();
		scene 	= new Scene(grid, board.getWindLength(), board.getWindWidth());
		lastClicked = new Coord(0,0);
		
		this.primaryStage = primaryStage;
		primaryStage.setTitle(board.getTitle());
		primaryStage.setScene(scene);
	}
	
	public void createDisplay(Stage primaryStage) {
		
	    boolean colorFlag = true;
	    for (int row = 0; row < board.getRowsNum(); row++) {
	        for (int col = 0; col < board.getColsNum(); col++) {
	            Rectangle rec = new Rectangle();
	            rec.setWidth(50);
	            rec.setHeight(50);
	            
	            if (colorFlag)
	            	rec.setFill(Color.BLACK);
	            else
	            	rec.setFill(Color.WHITE);
	            colorFlag = !colorFlag; 
	            
	            GridPane.setRowIndex(rec, row);
	            GridPane.setColumnIndex(rec, col);
	            grid.getChildren().addAll(rec);
	        }
	        colorFlag = !colorFlag;
	    }
	    
	}
	
	public void display(Stage primaryStage) {
		primaryStage.show();
	}
	
	public void mouseClickListener() {
		scene.addEventFilter(MouseEvent.MOUSE_PRESSED, mouseClick());
	}
	
	public EventHandler<MouseEvent> mouseClick() {
		
		return new EventHandler<MouseEvent>() {
    		public void handle(MouseEvent mouseEvent) {
    			lastClicked.X = mouseEvent.getX();
    			lastClicked.Y = mouseEvent.getY();
    			System.out.println("MOUSE CLICKED AT"
    					+ "\nX: " + lastClicked.X
    					+ "\nY: " + lastClicked.Y
    					+"\n-----");
    		}
		};
	}
	
}
