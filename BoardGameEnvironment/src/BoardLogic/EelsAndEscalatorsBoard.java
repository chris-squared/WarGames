package BoardLogic;

import javafx.scene.paint.Color;

public class EelsAndEscalatorsBoard extends Board {
	static final int ROWS = 10;
	static final int COLS = 10;
	
	static final int windHeight = 1080;
	static final int windWidth  = 1920;
	
	
	public EelsAndEscalatorsBoard() {
		super("Electric Eels and Super Escalators 2: Super Ultra Force",ROWS,COLS,windHeight,windWidth);
	}
	
	
	public void setStartingTiles() {
		
		boolean colorFlag = true;
		
		for (int row = 0; row < rowsNum; ++row) {
			for (int col = 0; col < colsNum; ++col) {
				if (colorFlag)
					getTile(row, col).setColor(Color.BlUE);
				else
					getTile(row, col).setColor(Color.GREEN);
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
	
	


	
	void setStartingImages() {
		// TODO Auto-generated method stub
		
	}
}
