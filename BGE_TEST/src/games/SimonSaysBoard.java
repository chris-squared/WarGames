package games;

import java.awt.Color;

import bge.Board;
import bge.BoardCoord;

public class SimonSaysBoard extends Board {
	
	static final int ROWS = 3;
	static final int COLS = 3;
	
	static final int windHeight = 500;
	static final int windWidth = 500;
	
	
	protected SimonSaysBoard() {
		super("Test Simon Says", ROWS, COLS, windHeight, windWidth);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setStartingTiles() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStartingPieces() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStartingImages() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void forwardMouseClick(BoardCoord clickCoords) {
		// TODO Auto-generated method stub
		
	}

}
