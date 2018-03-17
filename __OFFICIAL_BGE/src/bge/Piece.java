package bge;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Piece {

	BoardCoord boardCoord;
	Image image;
	
	Piece() {
	}
	
	public Piece(int row, int col, Image I) {
		boardCoord = new BoardCoord(row,col);
		image = I;
	}
	
	Piece(BoardCoord B, Image I) {
		boardCoord = B;
		image = I;
	}

	public BoardCoord getBoardCoord() {
		return boardCoord;
	}

	public void setgetBoardCoord(BoardCoord boardCoord) {
		this.boardCoord = boardCoord;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image i) {
		this.image = i;
	}
	
}
