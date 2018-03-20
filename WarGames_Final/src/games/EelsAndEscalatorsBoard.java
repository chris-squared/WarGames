package games;

import bge.Board;
import bge.BoardCoord;
import bge.GameOverException;
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
		updateBoard();
	}
	
	
	
	public void setStartingTiles() {
		
			
	
	}
	
	public void setStartingPieces() {
		System.out.println("SETTING PLAYERS DOWN");
		addPieceP1(9, 0, new Piece(9, 0, new Image("/games/eelsandescalators/GamePiece.png")));
		addPieceP2(9, 0, new Piece(9, 0, new Image("/games/eelsandescalators/2Player.jpg")));
	

	}
	
	


	
	public void setStartingImages() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void forwardMouseClick(BoardCoord clickCoords) throws GameOverException {
		turn_flag = 1;
		System.out.println("MAKING A TURN");
	
		
	}


	@Override
	public void updateBoard() {
System.out.println("CALLED");
		
		boolean colorFlag = true;
		
		for (int row = 0; row < rowsNum; ++row) {
			for (int col = 0; col < colsNum; ++col) {
				if (colorFlag)
					getTile(row, col).setColor(Color.CORNFLOWERBLUE);
				else
					getTile(row, col).setColor(Color.AQUAMARINE);
				colorFlag = !colorFlag;
			}
			colorFlag = !colorFlag;
		}
		
	}
}