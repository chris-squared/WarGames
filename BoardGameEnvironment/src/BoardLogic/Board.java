package BoardLogic;
import java.util.ArrayList;

public class Board {

	String title;
	
	int rowsNum;
	int colsNum;
	
	int windLength;
	int windWidth;
	
	ArrayList<ArrayList<Tile>> tiles;
	
	
	Board(String T, int R, int C, int L, int W) {
		
		title = T;
		
		rowsNum 	= R;
		colsNum 	= C;
		windLength 	= L;
		windWidth 	= W;
		
		tiles = new ArrayList<ArrayList<Tile>>();
		
		for (int row = 0; row < rowsNum; ++row) {
			tiles.add(new ArrayList<Tile>());
			for (int col = 0; col < colsNum; ++col) {
				tiles.get(row).add(new Tile(row,col));
			}
		}
	}
	
	void calculateCoord(int row, int col) {
		
	}
	
	public void coordToBoardCoord(Coord c) {
		
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


	public int getWindLength() {
		return windLength;
	}


	public void setWindLength(int windLength) {
		this.windLength = windLength;
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
	
	
	
	
}
