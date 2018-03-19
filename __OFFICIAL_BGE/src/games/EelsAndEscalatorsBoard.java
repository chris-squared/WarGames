package games;

import bge.Board;
import bge.BoardCoord;
import bge.Piece;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;

public class EelsAndEscalatorsBoard extends Board {
	static final int ROWS = 10;
	static final int COLS = 10;
	
	static final int windHeight = 1080;
	static final int windWidth  = 1920;
	
	
	public EelsAndEscalatorsBoard() {
		//super("Electric Eels and Super Escalators 2: Super Ultra Force",ROWS,COLS,windHeight,windWidth);
		super("Electric Eels and Super Escalators 2: Super Ultra Force",ROWS,COLS);
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
		addPieceP1(9, 0, new Piece(9, 0, new Image("/games/eelsandescalators/GamePiece.png")));
		addPieceP2(9, 0, new Piece(9, 0, new Image("/games/eelsandescalators/GamePiece.png")));
	

	}
	
	


	
	public void setStartingImages() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void forwardMouseClick(BoardCoord clickCoords) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateBoard() {
		// TODO Auto-generated method stub
		
	}
}