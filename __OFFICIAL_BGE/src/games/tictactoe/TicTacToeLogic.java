package games.tictactoe;

import bge.BoardCoord;
import bge.GameOverException;
import bge.Piece;
import bge.Player;
import javafx.scene.image.Image;
import utility.Logic;

public class TicTacToeLogic extends Logic{
	TicTacToeBoard board; 
	
	public TicTacToeLogic(TicTacToeBoard b){
		super();
		board = b;
	}

	@Override
	public boolean check_win_condition(Piece p) {
		return (DiagonalCheckLToR(p) || DiagonalCheckRToL(p) || HorizontalCheck(p) || VerticalCheck(p) || BoardIsFullCheck());
	}

	@Override
	public boolean isValidMove(BoardCoord end) {
	return(	board.getPieceP1(end.getRow(), end.getCol()) == null && 
		board.getPieceP2(end.getRow(), end.getCol()) == null);
	}

	boolean VerticalCheck(Piece p) {
		int counterP1 = 0; 
		int counterP2 = 0;
		boolean winner = false;
		for(int col = 0; col < board.getColsNum(); col++) {
			for(int row = 0; row < board.getRowsNum(); row++) {
				if(board.getPieceP1(row, col) != null) {
					counterP1++;
					if(counterP1 >= 3) {
						winner = true;
					}
				} else if(board.getPieceP2(row, col) != null) {
					counterP2++;
					if(counterP2 >= 3) {
						winner = true;
					}
				}
				else {
					counterP1 = 0;
					counterP2 = 0;
				}
			}
			counterP1 = 0;
			counterP2 = 0;
		}
		return winner;
	}
	
	boolean HorizontalCheck(Piece p) {
		int counterP1 = 0; 
		int counterP2 = 0;
		boolean winner = false;
		for(int row = 0; row < board.getRowsNum(); row++) {
			for(int col = 0; col < board.getColsNum(); col++) {
				if(board.getPieceP1(row, col) != null) {
					counterP1++;
					if(counterP1 >= 3) {
						winner = true;
					}
				} else if(board.getPieceP2(row, col) != null) {
					counterP2++;
					if(counterP2 >= 3) {
						winner = true;
					}
				}
				else {
					counterP1 = 0;
					counterP2 = 0;
				}
			}
			counterP1 = 0;
			counterP2 = 0;
		}
		return winner;
	}
	
	boolean DiagonalCheckLToR(Piece p) {
		int counterP1 = 0; 
		int counterP2 = 0;
		boolean winner = false;
		for(int row = 0; row < 1; row++) {
			for(int col = 0; col < 1; col++) {
				if(board.getPieceP1(row, col) != null) {
					counterP1++;
					for(int i = 1; i < 3; i++) {
						if(board.getPieceP1(row+i, col+i) != null) {
							counterP1++;
							if(counterP1 >= 3) {
								winner = true;
							}
						} else {
							counterP1 = 0;
						}
					}
				} else if(board.getPieceP2(row, col) != null) {
					counterP2++;
					for(int i = 1; i < 3; i++) {
						if(board.getPieceP2(row+i, col+i) != null) {
							counterP2++;
							if(counterP2 >= 3) {
								winner = true;
							}
						} else {
							counterP2 = 0;
						}
					}
				}
				else {
					counterP1 = 0;
					counterP2 = 0;
				}
			}
		}
		return winner;
	}
	
	boolean DiagonalCheckRToL(Piece p) {
		int counterP1 = 0; 
		int counterP2 = 0;
		boolean winner = false;
		for(int row = 2; row < 3; row++) {
			for(int col = 0; col < 1; col++) {
				if(board.getPieceP1(row, col) != null) {
					counterP1++;
					for(int i = 1; i < 3; i++) {
						if(board.getPieceP1(row-i, col+i) != null) {
							counterP1++;
							if(counterP1 >= 3) {
								winner = true;
							}
						} else {
							counterP1 = 0;
						}
					}
				} else if(board.getPieceP2(row, col) != null) {
					counterP2++;
					for(int i = 1; i < 3; i++) {
						if(board.getPieceP2(row-i, col+i) != null) {
							counterP2++;
							if(counterP2 >= 3) {
								winner = true;
							}
						} else {
							counterP2 = 0;
						}
					}
				}
				else {
					counterP1 = 0;
					counterP2 = 0;
				}
			}
		}
		return winner;
	}
	
	boolean BoardIsFullCheck() {
		for(int col = 0; col < board.getColsNum(); col++) {
			for(int row = 0; row < board.getRowsNum(); row++) {
				if(board.getPieceP1(row, col) == null && board.getPieceP2(row, col) == null) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public void executeMove(Player p, BoardCoord bc) throws GameOverException {
		if (isValidMove(bc)) {
			placePiece(p, bc);
		}
		if(p.turn == 0 && check_win_condition(board.getPieceP1(bc.getRow(), bc.getCol()))) {
			System.out.println("Player 1 Wins!");
			throw(new GameOverException());
		}
		else if (p.turn != 0 && check_win_condition(board.getPieceP2(bc.getRow(), bc.getCol()))) {
			System.out.println("Player 2 Wins!");
			throw(new GameOverException());
		}
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
