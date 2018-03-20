package game.tictactoe2;

import bge.Piece;
import bge.Tile;
import games.TicTacToe2Board;
import utility.Logic;

public class TicTacToeLogic extends Logic{
	TicTacToe2Board board; 
	
	TicTacToeLogic(){
		super();
		
	}

	@Override
	public boolean check_win_condition(Piece p) {
		return (DiagonalCheck(p) || HorizontalCheck(p) || verticalCheck(p));
	}

	@Override
	public boolean isValidMove(Piece p, Tile start, Tile end) {
	return(	board.getPieceP1(p.getBoardCoord().getRow(), p.getBoardCoord().getCol()) == null && 
		board.getPieceP2(p.getBoardCoord().getRow(), p.getBoardCoord().getCol()) == null);
	}

	@Override
	public void executeMove() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	boolean verticalCheck(Piece p) {
		int startR = p.getBoardCoord().getRow();
		int startC = p.getBoardCoord().getCol();
		
		
	}
	
	boolean HorizontalCheck(Piece p) {
		
	}
	
	boolean DiagonalCheck(Piece p) {
		
	}
}
