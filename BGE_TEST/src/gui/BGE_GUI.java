package gui;

import bge.Board;
import bge.Coord;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class BGE_GUI {

	
	Board board;
	GridPane grid;
	Scene scene;
	Stage primaryStage;
	
	Coord lastClicked;

//	FXMLLoader loader = new FXMLLoader();

	public BGE_GUI(Board b) {
		board 	= b;
		grid 	= new GridPane();
//		scene 	= new Scene(grid, board.getWindWidth(), board.getWindHeight());

		board.setStartingTiles();
		board.setStartingPieces();
		
		lastClicked = new Coord(0,0);
		
//		this.primaryStage = primaryStage;
//		primaryStage.setTitle(board.getTitle());
//		primaryStage.setScene(scene);
		// FIXED SIZE
//		primaryStage.setResizable(false);
//		primaryStage.sizeToScene();

//		loader.setLocation(getClass().getResource("/gui/GameEnvironment.fxml"));


	}

	public void setBoardGrid() throws Exception{
//		AnchorPane root = loader.load();
//		scene = new Scene(root);
//		scene.lookup("#boardgrid");

	}

	public void startDisplay() {
	    createTiles();
	    createPieces();
	    createImages();
	}
	
	public void updateDisplay() {
		// inefficient but w.e
		startDisplay();
	}
	
	public void display(Stage primaryStage) {
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	// Private
	
	private void createTiles() {
		for (int row = 0; row < board.getRowsNum(); row++) {
	        for (int col = 0; col < board.getColsNum(); col++) {
	        	
	            Rectangle rec = new Rectangle();
	            
	            rec.setHeight(board.getTileHeight());
	            rec.setWidth(board.getTileWidth());

	            try {
	            	rec.setFill(board.getTile(row, col).getColor());
	            } catch (Exception e) {System.out.println(("No fill color :("));}
	            try {
	            	rec.setStroke(board.getTile(row, col).getOutlineColor());
	            } catch (Exception e) {System.out.println(("No outline color :("));}
	            
	            
	            GridPane.setRowIndex(rec, row);
	            GridPane.setColumnIndex(rec, col);
	            
//	            // Click Action
//	            rec.setOnMouseClicked(
//	            	new EventHandler<MouseEvent>() {
//	            		
//	            		@Override
//	            		public void handle(MouseEvent mouseEvent) {
//		        			lastClicked.row = GridPane.getRowIndex(rec);
//		        			lastClicked.col = GridPane.getColumnIndex(rec);
//		        			System.out.println("MOUSE CLICKED AT"
//		        					+ "\nRow: " + GridPane.getRowIndex(rec)
//		        					+ "\nCol: " + GridPane.getColumnIndex(rec)
//		        			);
//	            		}
//	            	}
//	            );
//	            // Click Action End
	            
	            grid.getChildren().addAll(rec);
	        }
	    }
	}
	
	private void createPieces() {
		for (int row = 0; row < board.getRowsNum(); row++) {
	        for (int col = 0; col < board.getColsNum(); col++) {
	        	
	        	if (board.getPiece(row,col) == null)
	        		continue;
	        	
	        	Circle cir = new Circle();
		    	
	    		cir.setRadius(board.getTileHeight()/3);
	    		cir.setFill(board.getPiece(row,col).getColor());
	    		
	    		GridPane.setRowIndex(cir, row);
	    		GridPane.setColumnIndex(cir, col);
	    		
	    		grid.getChildren().addAll(cir);
	        }
	    }   
	}
	
	private void createImages() {
		for (int row = 0; row < board.getRowsNum(); row++) {
	        for (int col = 0; col < board.getColsNum(); col++) {
	        	
	        	if (board.getImage(row,col) == null)
	        		continue;

	        	ImageView imgView = new ImageView(board.getImage(row,col));
	    		
	    		grid.add(imgView,row,col);
	        }
	    }   
	}
	
	
	// Mouse
	
	public void mouseClickListener() {
		grid.addEventFilter(MouseEvent.MOUSE_PRESSED, click());
	}
	
	private EventHandler<MouseEvent> click() {
		
		return new EventHandler<MouseEvent>() {
    		public void handle(MouseEvent mouseEvent) {
    			lastClicked.setX(mouseEvent.getX());
    			lastClicked.setY(mouseEvent.getY());
    			System.out.println("MOUSE CLICKED AT"
    					+ "\nX: " + lastClicked.getX()
    					+ "\nY: " + lastClicked.getY()
    					+"\n-----");
    			board.coordToBoardCoord(lastClicked);
    			mouseClicked();
    		}
		};
	}
	
	private void mouseClicked() {
		board.forwardMouseClick(board.coordToBoardCoord(lastClicked));
		updateDisplay();
	}

	public GridPane getGrid(){
		return grid;
	}
}
