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
		
	}
	
	
	
	public void setStartingTiles() {
		
		boolean colorFlag = true;
		
		for (int row = 0; row < rowsNum; ++row) {
			for (int col = 0; col < colsNum; ++col) {
				if (colorFlag)
					getTile(row, col).setColor(Color.ALICEBLUE);
				else
					getTile(row, col).setColor(Color.AQUAMARINE);
				colorFlag = !colorFlag;
			}
			colorFlag = !colorFlag;
		}
		
		getTile(9, 2).setColor(Color.GREEN);
		getTile(9, 0).setColor(Color.GREEN);
		
		getTile(9, 4).setColor(Color.BLACK);
		getTile(9, 9).setColor(Color.BLACK);
		
		getTile(9, 7).setColor(Color.RED);
		getTile(9, 1).setColor(Color.RED);
		
		getTile(8, 0).setColor(Color.BROWN);
		getTile(7, 3).setColor(Color.BROWN);
		
		getTile(6, 7).setColor(Color.BISQUE);
		getTile(7, 7).setColor(Color.BISQUE);
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
		// TODO Auto-generated method stub
		
	}
}