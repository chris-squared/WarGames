package games.tictactoe;

import bge.Board;
import bge.BoardCoord;
import bge.GameOverException;
import bge.InvalidMoveException;
import javafx.scene.paint.Color;

public class TicTacToeBoard extends Board {
	
	public TicTacToeBoard() {
		super("Tic-Tac-Toe 2", 3, 3);
	}

	@Override
	public void setStartingTiles() {
		
		for (int row = 0; row < rowsNum; ++row) {
			for (int col = 0; col < colsNum; ++col) {
				getTile(row,col).setOutlineColor(Color.WHITE);
				getTile(row,col).setColor(Color.BLACK);
			}
		}
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
	public void forwardMouseClick(BoardCoord clickCoords) throws GameOverException, InvalidMoveException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBoard() {
		// TODO Auto-generated method stub
		
	}
	
	
}
