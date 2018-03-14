package BoardLogic;

import java.util.ArrayList;

import javafx.scene.paint.Color;
public class TestCheckerBoard extends Board {
	
	static final int ROWS = 8;
	static final int COLS = 8;
	
	static final int windHeight = 500;
	static final int windWidth  = 500;
	
	
	public TestCheckerBoard() {
		super("Test Checkers",ROWS,COLS,windHeight,windWidth);
	}
	
	
	public void setStartingTiles() {
		
		boolean colorFlag = true;
		
		for (int row = 0; row < rowsNum; ++row) {
			for (int col = 0; col < colsNum; ++col) {
				if (colorFlag)
					getTile(row, col).setColor(Color.WHITE);
				else
					getTile(row, col).setColor(Color.BLACK);
				colorFlag = !colorFlag;
			}
			colorFlag = !colorFlag;
		}
	}
	
	public void setStartingPieces() {
		
		for (int i = 0; i < 3; ++i) 
			for (int j = 0; j < COLS; ++j) 
				if (getTile(i,j).getColor() == Color.BLACK) 
					addPiece(i, j, new Piece(i,j,Color.BLUE));
		
		for (int i = 7; i > 4; --i) 
			for (int j = 0; j < COLS; ++j) 
				if (getTile(i,j).getColor() == Color.BLACK) 
					addPiece(i, j, new Piece(i,j,Color.GOLD));

	}
	
	public void setStartingImages() {
		// Not applicable
	}

}
