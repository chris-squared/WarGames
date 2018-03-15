package bge;

import javafx.scene.paint.Color;

public class Piece {

	BoardCoord boardCoord;
	Color color;
	
	Piece() {
	}
	
	public Piece(int row, int col, Color C) {
		boardCoord = new BoardCoord(row,col);
		color = C;
	}
	
	Piece(BoardCoord B, Color C) {
		boardCoord = B;
		color = C;;
	}

	public BoardCoord getBoardCoord() {
		return boardCoord;
	}

	public void setgetBoardCoord(BoardCoord boardCoord) {
		this.boardCoord = boardCoord;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
}
