package bge;

public class BoardCoord {

	int row;
	int col;
	
	BoardCoord(int r, int c) {
		row = r;
		col = c;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
	
	public void set(int row, int col) {
		this.row = row;
		this.col = col;
	}
}
