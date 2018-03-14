package BoardLogic;

import java.util.ArrayList;

import javafx.scene.paint.Color;
public class TicTacToeBoard extends Board {
	
	static final int ROWS = 3;
	static final int COLS = 3;
	
	static final int windHeight = 500;
	static final int windWidth  = 500;
	
	
	public TicTacToeBoard() {
		super("Test TicTacToe",ROWS,COLS,windHeight,windWidth);
	}
	
	
	public void setStartingTiles() {
		
		for (int row = 0; row < rowsNum; ++row) {
			for (int col = 0; col < colsNum; ++col) {
				getTile(row,col).setOutlineColor(Color.BLACK);
			}
		}
	}
	
	public void setStartingPieces() {/* None */}
	
	void setStartingImages() {/* None */}
	

}
