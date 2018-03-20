package gui;

import java.io.IOException;
import java.util.Optional;

import bge.Board;
import bge.BoardCoord;
import bge.Coord;
import bge.GameOverException;
import bge.InvalidMoveException;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
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
import utility.Engine;

public class BGE_GUI {

	Engine engine;
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

	public BGE_GUI(Engine e, Stage primaryStage, double height, double width) {
		engine = e;
		board 	= e.board;
		grid 	= new GridPane();
		this.primaryStage = primaryStage;
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
		            
		            GridPane.setHalignment(imgView1, HPos.CENTER);
		        	
		        	grid.getChildren().addAll(imgView1);
	        	}
	        	
	        	// Player 2
	        	if (board.getPieceP2(row,col) != null) {
		        	ImageView imgView2 = new ImageView(board.getPieceP2(row,col).getImage());
		        	
		        	imgView2.setFitHeight(tileHeight);
		        	imgView2.setFitWidth(tileHeight);
		        	
		        	GridPane.setRowIndex(imgView2, row);
		            GridPane.setColumnIndex(imgView2, col);
		            
		            GridPane.setHalignment(imgView2, HPos.CENTER);
		        	
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
    			try {
					mouseClicked();
				} catch (GameOverException e) {
					gameOver();
				} catch (InvalidMoveException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
		};
	}
	
	private void mouseClicked() throws GameOverException, InvalidMoveException {
		try {
			engine.forwardMouseClick(coordToBoardCoord(lastClicked));
			updateDisplay();
		} catch (GameOverException e) {
			updateDisplay();
			throw new GameOverException();
		}
	}

	private void gameOver() {
		System.out.println("GAME OVER");
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("War Games");
		alert.setHeaderText("Game Over!");
		alert.setContentText("What next?");

		ButtonType resetGame = new ButtonType("Reset Game");
		ButtonType gameSelect = new ButtonType("Game Select");
		ButtonType exit = new ButtonType("Exit");

		alert.getButtonTypes().setAll(resetGame, gameSelect, exit);

		Optional<ButtonType> result = alert.showAndWait();
		
	    FXMLLoader loader = new FXMLLoader();
		if (result.get() == resetGame){
		    System.out.println("Resetting game");
			loader.setLocation(getClass().getResource("/resources/GameEnvironment.fxml"));
			try {
				Board newBoard = board.getClass().newInstance();
				FXMLGameEnvironmentController controller = new FXMLGameEnvironmentController(newBoard, primaryStage);
				controller.setEngine(engine);
				loader.setController(controller);
				Parent root = loader.load();
				primaryStage.setTitle("War Games");
				primaryStage.setScene(new Scene(root, 1000, 800));
				primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		} else if (result.get() == gameSelect) {
		    System.out.println("Choosing another game");
	        loader.setLocation(getClass().getResource("/resources/InitialView.fxml"));
	        try {
				Parent root = loader.load();
				primaryStage.setTitle("War Games");
				primaryStage.setScene(new Scene(root, 640, 400));
				primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
//		    System.exit(0);
			Platform.exit();
		}
	}

	// Getter
	
	public GridPane getGrid(){
		return grid;
	}
}
