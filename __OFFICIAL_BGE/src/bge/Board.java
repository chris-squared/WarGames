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
	ArrayList<ArrayList<Piece>> piecesP1;
	ArrayList<ArrayList<Piece>> piecesP2;
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
		
		tiles 		= new ArrayList<ArrayList<Tile>>();
		piecesP1 	= new ArrayList<ArrayList<Piece>>();
		piecesP2 	= new ArrayList<ArrayList<Piece>>();
		images		= new ArrayList<ArrayList<Image>>();
		
		// Creates tiles and pieces matrix
		for (int row = 0; row < rowsNum; ++row) {
			// Create Rows
			tiles.add(new ArrayList<Tile>());
			piecesP1.add(new ArrayList<Piece>());
			piecesP2.add(new ArrayList<Piece>());
			images.add(new ArrayList<Image>());
			
			for (int col = 0; col < colsNum; ++col) {
				// Create columns
				tiles.get(row).add(new Tile(row,col));
				piecesP1.get(row).add(null);
				piecesP2.get(row).add(null);
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
	//P1
	public Piece getPieceP1(int row, int col) {
		return piecesP1.get(row).get(col);
	}
	
	public void addPieceP1(int row, int col, Piece p) {
		//pieces.get(row).add(col,p);
		piecesP1.get(row).set(col,p);
	}
	
	public void removePieceP1(int row, int col) {
		if (getPieceP1(row,col) == null) {
			System.out.println("No piece to remove :(s");
			return;
		}
		addPieceP1(row,col,null);
	}
	
	public void movePieceP1(int currRow, int currCol, int newRow, int newCol) {
		getPieceP1(currRow,currCol).getBoardCoord().set(newRow, newCol);
		addPieceP1(newRow, newCol, getPieceP1(currRow,currCol));
		removePieceP1(currRow,currCol);
	}
	
	public void changePieceImage(int row, int col, Image image) {
		if (getPieceP1(row,col) == null) {
			System.out.println("Piece no exist.");
			return;
		}
		
		getPieceP1(row,col).setImage(image);
		
	}
	// P2
	public Piece getPieceP2(int row, int col) {
		return piecesP2.get(row).get(col);
	}
	
	public void addPieceP2(int row, int col, Piece p) {
		//pieces.get(row).add(col,p);
		piecesP2.get(row).set(col,p);
	}
	
	public void removePieceP2(int row, int col) {
		if (getPieceP1(row,col) == null) {
			System.out.println("No piece to remove :(s");
			return;
		}
		addPieceP2(row,col,null);
	}
	
	public void movePieceP2(int currRow, int currCol, int newRow, int newCol) {
		getPieceP2(currRow,currCol).getBoardCoord().set(newRow, newCol);
		addPieceP2(newRow, newCol, getPieceP2(currRow,currCol));
		removePieceP2(currRow,currCol);
	}
	
	public void changePieceImageP2(int row, int col, Image image) {
		if (getPieceP2(row,col) == null) {
			System.out.println("Piece no exist.");
			return;
		}
		
		getPieceP2(row,col).setImage(image);
		
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

	public ArrayList<ArrayList<Piece>> getPiecesP1() {
		return piecesP1;
	}

	public void setPiecesP1(ArrayList<ArrayList<Piece>> pieces) {
		this.piecesP1 = pieces;
	}
	
	public ArrayList<ArrayList<Piece>> getPiecesP2() {
		return piecesP2;
	}

	public void setPiecesP2(ArrayList<ArrayList<Piece>> pieces) {
		this.piecesP2 = pieces;
	}


	public ArrayList<ArrayList<Image>> getImages() {
		return images;
	}


	public void setImages(ArrayList<ArrayList<Image>> images) {
		this.images = images;
	}
	
	
	
	
}
