package boardgamerepo;

import board_gui.Board;
import board_gui.BoardCoord;
import board_gui.Piece;
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
					getTile(row, col).setColor(Color.ALICEBLUE);
				else
					getTile(row, col).setColor(Color.BLACK);
				colorFlag = !colorFlag;
			}
			colorFlag = !colorFlag;
		}
	}
	
	public void setStartingPieces() {
		addPiece(9, 0, new Piece(9,0, Color.CORAL));
		addPiece(9, 0, new Piece(9, 0, Color.CADETBLUE));

	}
	
	


	
	public void setStartingImages() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void forwardMouseClick(BoardCoord clickCoords) {
		// TODO Auto-generated method stub
		
	}
}