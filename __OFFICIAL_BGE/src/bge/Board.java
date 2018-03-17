package bge;
import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public abstract class Board {

	String title;
	
	protected int rowsNum;
	protected int colsNum;
	
//	double windHeight; 	- To gui
//	double windWidth; 	- To gui
//	
//	double tileHeight; 	- To gui
//	double tileWidth; 	- To gui
	
	ArrayList<ArrayList<Tile>> 	tiles;
	ArrayList<ArrayList<Piece>> pieces;
	ArrayList<ArrayList<Image>> images;
	
	
	protected Board(String T, int R, int C, double H, double W) {
		
		title = T;
		
		// FOR BEST RESULTS
		//   Have width and height be proportional
		//   with columns and rows
		
		rowsNum 	= R;
		colsNum 	= C;
		
//		windHeight 	= H; - To gui
//		windWidth 	= W; - To gui
//		
//		tileHeight	= windHeight/colsNum; - To gui
//		tileWidth	= windWidth/rowsNum;  - To gui
		
		tiles 	= new ArrayList<ArrayList<Tile>>();
		pieces 	= new ArrayList<ArrayList<Piece>>();
		images	= new ArrayList<ArrayList<Image>>();
		
		// Creates tiles and pieces matrix
		for (int row = 0; row < rowsNum; ++row) {
			// Create Rows
			tiles.add(new ArrayList<Tile>());
			pieces.add(new ArrayList<Piece>());
			images.add(new ArrayList<Image>());
			
			for (int col = 0; col < colsNum; ++col) {
				// Create columns
				tiles.get(row).add(new Tile(row,col));
				pieces.get(row).add(null);
				images.get(row).add(null);
			}
		}
	}
	
	
	// Abstract Methods
	
	public abstract void setStartingTiles();
	public abstract void setStartingPieces();
	public abstract void setStartingImages();
	public abstract void forwardMouseClick(BoardCoord clickCoords);
	
	
	// Tile Operations ----------
	
	public void changeTileColor(int row, int col, Color color) {
		getTile(row, col).setColor(color);
	}
	
	public void changeTileOutline(int row, int col, Color color) {
		getTile(row,col).setOutlineColor(color);
	}
	
	
	// Piece Operations ----------
	
	public Piece getPiece(int row, int col) {
		return pieces.get(row).get(col);
	}
	
	public void addPiece(int row, int col, Piece p) {
		//pieces.get(row).add(col,p);
		pieces.get(row).set(col,p);
	}
	
	public void removePiece(int row, int col) {
		if (getPiece(row,col) == null) {
			System.out.println("No piece to remove :(s");
			return;
		}
		addPiece(row,col,null);
	}
	
	public void movePiece(int currRow, int currCol, int newRow, int newCol) {
		getPiece(currRow,currCol).getBoardCoord().set(newRow, newCol);
		addPiece(newRow, newCol, getPiece(currRow,currCol));
		removePiece(currRow,currCol);
	}
	
	public void changePieceImage(int row, int col, Image image) {
		if (getPiece(row,col) == null) {
			System.out.println("Piece no exist.");
			return;
		}
		
		getPiece(row,col).setImage(image);
		
	}
	
	
	// Image Operations ----------
	
	public Image getImage(int row, int col) {
		return images.get(row).get(col);
	}
	
	public void addImage(int row, int col, Image i) {
		images.get(row).set(col, i);
	}
	
	public void removeImage(int row, int col) {
		if (getImage(row,col) == null) {
			System.out.println("No image to remove :(");
			return;
		}
		addImage(row,col,null);
	}
	
	public void moveImage(int currRow, int currCol, int newRow, int newCol) {
		addImage(newRow, newCol, getImage(currRow,currCol));
		removeImage(currRow,currCol);
	}

	
	// Utilities ----------
	
	// To gui
//	public BoardCoord coordToBoardCoord(Coord c) {
//		double x = (c.getX() / windWidth)  * colsNum;
//		double y = (c.getY() / windHeight) * rowsNum;
//		
//		System.out.println("row = " + (int)y + " | col = " + (int)x);
//		
//		return new BoardCoord((int)y, (int)x);
//	}

	
	///// GET/SET ----------
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Tile getTile(int r, int c) {
		return tiles.get(r).get(c);
	}


	public int getRowsNum() {
		return rowsNum;
	}


	public void setRowsNum(int rowsNum) {
		this.rowsNum = rowsNum;
	}


	public int getColsNum() {
		return colsNum;
	}


	public void setColsNum(int colsNum) {
		this.colsNum = colsNum;
	}


//	public double getWindHeight() {
//		return windHeight;
//	}
//
//
//	public void setWindHeight(double windLength) {
//		this.windHeight = windLength;
//	}
//
//
//	public double getWindWidth() {
//		return windWidth;
//	}
//
//
//	public void setWindWidth(double windWidth) {
//		this.windWidth = windWidth;
//	}


	public ArrayList<ArrayList<Tile>> getTiles() {
		return tiles;
	}


	public void setTiles(ArrayList<ArrayList<Tile>> tiles) {
		this.tiles = tiles;
	}

//	public double getTileHeight() {
//		return tileHeight;
//	}
//
//	public void setTileHeight(double tileHeight) {
//		this.tileHeight = tileHeight;
//	}
//
//	public double getTileWidth() {
//		return tileWidth;
//	}
//
//	public void setTileWidth(double tileWidth) {
//		this.tileWidth = tileWidth;
//	}

	public ArrayList<ArrayList<Piece>> getPieces() {
		return pieces;
	}

	public void setPieces(ArrayList<ArrayList<Piece>> pieces) {
		this.pieces = pieces;
	}


	public ArrayList<ArrayList<Image>> getImages() {
		return images;
	}


	public void setImages(ArrayList<ArrayList<Image>> images) {
		this.images = images;
	}
	
	
	
	
}
