package gui;

import bge.Board;
import bge.BoardCoord;
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
	
	double windHeight;
	double windWidth;
	
	double tileHeight;
	double tileWidth;
	
	Coord lastClicked;

//	FXMLLoader loader = new FXMLLoader();

	public BGE_GUI(Board b, double height, double width) {
		
		board 	= b;
		grid 	= new GridPane();
//		scene 	= new Scene(grid, board.getWindWidth(), board.getWindHeight());

		windHeight 	= height;
		windWidth 	= width;
		
		tileHeight	= windHeight/board.getRowsNum();
		tileWidth	= windWidth/board.getColsNum();
		
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
	            
	            rec.setHeight(tileHeight);
	            rec.setWidth(tileWidth);

	            try {
	            	rec.setFill(board.getTile(row, col).getColor());
	            } catch (Exception e) {System.out.println(("No fill color :("));}
	            try {
	            	rec.setStroke(board.getTile(row, col).getOutlineColor());
	            } catch (Exception e) {System.out.println(("No outline color :("));}
	            
	            
	            GridPane.setRowIndex(rec, row);
	            GridPane.setColumnIndex(rec, col);
	        
	            
	            grid.getChildren().addAll(rec);
	        }
	    }
	}
	
	private void createPieces() {
		for (int row = 0; row < board.getRowsNum(); row++) {
	        for (int col = 0; col < board.getColsNum(); col++) {
	        	
	        	// Player 1
	        	if (board.getPieceP1(row,col) != null) {
		        	ImageView imgView1 = new ImageView(board.getPieceP1(row,col).getImage());
		        	
		        	imgView1.setFitHeight(tileHeight);
		        	imgView1.setFitWidth(tileHeight);
		        	
		        	GridPane.setRowIndex(imgView1, row);
		            GridPane.setColumnIndex(imgView1, col);
		        	
		        	grid.getChildren().addAll(imgView1);
	        	}
	        	
	        	// Player 2
	        	if (board.getPieceP2(row,col) != null) {
		        	ImageView imgView2 = new ImageView(board.getPieceP2(row,col).getImage());
		        	
		        	imgView2.setFitHeight(tileHeight);
		        	imgView2.setFitWidth(tileHeight);
		        	
		        	GridPane.setRowIndex(imgView2, row);
		            GridPane.setColumnIndex(imgView2, col);
		        	
		        	grid.getChildren().addAll(imgView2);
	        	}
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
	
	private BoardCoord coordToBoardCoord(Coord c) {
		double x = (c.getX() / windWidth)  * board.getColsNum();
		double y = (c.getY() / windHeight) * board.getRowsNum();
		
		System.out.println("row = " + (int)y + " | col = " + (int)x);
		
		return new BoardCoord((int)y, (int)x);
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
    			coordToBoardCoord(lastClicked);
    			mouseClicked();
    		}
		};
	}
	
	private void mouseClicked() {
		board.forwardMouseClick(coordToBoardCoord(lastClicked));
		updateDisplay();
	}

	public GridPane getGrid(){
		return grid;
	}
}
