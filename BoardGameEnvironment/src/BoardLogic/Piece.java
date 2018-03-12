package BoardLogic;

import javafx.scene.paint.Color;

public class Piece {

	Tile currentTile;
	Color color;
	
	Piece(Tile T, Color C) {
		currentTile = T;
		color = C;;
	}

	public Tile getCurrentTile() {
		return currentTile;
	}

	public void setCurrentTile(Tile currentTile) {
		this.currentTile = currentTile;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
}
