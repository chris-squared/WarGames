package BoardLogic;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public class TestSimonBoard extends Board{

	static final int ROWS = 3;
	static final int COLS = 3;
	
	static final int windHeight = 500;
	static final int windWidth  = 500;
	
	public TestSimonBoard() {
		super("Test Simon",ROWS,COLS,windHeight,windWidth);
	}
	
	public void setStartingTileColors() {
		
		Color[][] colors = new Color [3][3];
		
		colors[0][0] = Color.RED;
		colors[0][1] = Color.GREEN;
		colors[0][2] = Color.BLUE;
		colors[1][0] = Color.PINK;
		colors[1][1] = Color.PURPLE;
		colors[1][2] = Color.YELLOW;
		colors[2][0] = Color.ORANGE;
		colors[2][1] = Color.BROWN;
		colors[2][2] = Color.GRAY;
		
		for (int row = 0; row < rowsNum; ++row) {
			for (int col = 0; col < colsNum; ++col) {
				tiles.get(row).get(col).setColor(colors[row][col]);
			}
		}
	}
			
	public void setStartingPieces() {
		
	}
	
}
