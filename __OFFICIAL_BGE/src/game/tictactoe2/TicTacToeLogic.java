package game.tictactoe2;

import bge.BoardCoord;
import bge.GameOverException;
import bge.Piece;
import bge.Player;
import bge.Tile;
import games.TicTacToe2Board;
import javafx.scene.image.Image;
import utility.Logic;

public class TicTacToeLogic extends Logic{
	TicTacToe2Board board; 
	
	public TicTacToeLogic(TicTacToe2Board b){
		super();
		board = b;
	}

	@Override
	public boolean check_win_condition(Piece p) {
		return (DiagonalCheck(p) || HorizontalCheck(p) || verticalCheck(p));
	}

	@Override
	public boolean isValidMove(BoardCoord end) {
	return(	board.getPieceP1(end.getRow(), end.getCol()) == null && 
		board.getPieceP2(end.getRow(), end.getCol()) == null);
	}

	
	
	
	boolean verticalCheck(Piece p) {
		return false;
			
		}
	
		
		
		
	
	
	boolean HorizontalCheck(Piece p) {
		return false;
	}
	
	boolean DiagonalCheck(Piece p) {
		return false;
	}

	@Override
	public void executeMove(Player p, BoardCoord bc) throws GameOverException {
		if (isValidMove(bc)) {
			placePiece(p, bc);
		}
		if(p.turn == 0)
			check_win_condition(board.getPieceP1(bc.getRow(), bc.getCol()));
		else
			check_win_condition(board.getPieceP2(bc.getRow(), bc.getCol()));
		
	}

	private void placePiece(Player p, BoardCoord bc) {
		if (p.turn == 0) {
			board.addPieceP1(bc.getRow(), bc.getCol(), new Piece(bc.getRow(), bc.getCol(), new Image("/games/tictactoe/VWx.png")));
		}
		else if (p.turn == 1) {
			board.addPieceP2(bc.getRow(), bc.getCol(), new Piece(bc.getRow(), bc.getCol(), new Image("/games/tictactoe/VWo.png")));
		}
		
	}
}
