package BoardLogic;
import javafx.scene.paint.Color;

public class Tile {
	
	Color color;
	
	BoardCoord boardCoord;
	
	
	Tile(int boardRow, int boardCol) {
		
		boardCoord = new BoardCoord(boardRow, boardCol);
		
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
