package BoardLogic;
import java.util.ArrayList;

public class Board {

	String title;
	
	int rowsNum;
	int colsNum;
	
	int windHeight;
	int windWidth;
	
	double tileHeight;
	double tileWidth;
	
	ArrayList<ArrayList<Tile>> tiles;
	
	
	Board(String T, int R, int C, int H, int W) {
		
		title = T;
		
		rowsNum 	= R;
		colsNum 	= C;
		
		windHeight 	= H;
		windWidth 	= W;
		
		tileHeight	= windHeight/colsNum;
		tileWidth	= windWidth/rowsNum;
		
		tiles = new ArrayList<ArrayList<Tile>>();
		
		for (int row = 0; row < rowsNum; ++row) {
			tiles.add(new ArrayList<Tile>());
			for (int col = 0; col < colsNum; ++col) {
				tiles.get(row).add(new Tile(row,col));
			}
		}
	}
	
	//abstract void setTileColors()
	
	public BoardCoord coordToBoardCoord(Coord c) {
		double x = (c.X / windWidth)  * colsNum;
		double y = (c.Y / windHeight) * rowsNum;
		
		System.out.println("row = " + (int)y + " | col = " + (int)x);
		
		return new BoardCoord((int)y, (int)x);
		
	}
	
	
	
	///// GET/SET
	
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


	public int getWindHeight() {
		return windHeight;
	}


	public void setWindHeight(int windLength) {
		this.windHeight = windLength;
	}


	public int getWindWidth() {
		return windWidth;
	}


	public void setWindWidth(int windWidth) {
		this.windWidth = windWidth;
	}


	public ArrayList<ArrayList<Tile>> getTiles() {
		return tiles;
	}


	public void setTiles(ArrayList<ArrayList<Tile>> tiles) {
		this.tiles = tiles;
	}

	public double getTileHeight() {
		return tileHeight;
	}

	public void setTileHeight(double tileHeight) {
		this.tileHeight = tileHeight;
	}

	public double getTileWidth() {
		return tileWidth;
	}

	public void setTileWidth(double tileWidth) {
		this.tileWidth = tileWidth;
	}
	
	
	
	
}
