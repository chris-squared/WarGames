package BoardLogic;
import javafx.scene.paint.Color;

public class Tile {
	
	Coord topLeftCoords;
	Coord bottomRightCoords;
	
	Color color;
	
	BoardCoord boardCoord;
	
	
	Tile(int boardRow, int boardCol) {
		
		boardCoord = new BoardCoord(boardRow, boardCol);
		
	}


	public Coord getTopLeftCoords() {
		return topLeftCoords;
	}


	public void setTopLeftCoords(Coord topLeftCoords) {
		this.topLeftCoords = topLeftCoords;
	}


	public Coord getBottomRightCoords() {
		return bottomRightCoords;
	}


	public void setBottomRightCoords(Coord bottomRightCoords) {
		this.bottomRightCoords = bottomRightCoords;
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}


	public BoardCoord getBoardCoord() {
		return boardCoord;
	}


	public void setBoardCoord(BoardCoord boardCoord) {
		this.boardCoord = boardCoord;
	}
	
}
