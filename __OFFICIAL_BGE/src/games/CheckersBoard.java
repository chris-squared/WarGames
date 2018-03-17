package games;

import bge.Board;
import bge.BoardCoord;
import bge.GameOverException;
import bge.Piece;
import games.checkers.CheckersLogic;
import games.checkers.CheckersState;
import games.checkers.CheckersTurn;
import games.checkers.Utility;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class CheckersBoard extends Board {
	
	static final int ROWS = 8;
	static final int COLS = 8;
	
	CheckersState state;
	CheckersLogic logic;
	CheckersTurn checkersTurn;
	
	int turn;
	
	boolean endFlag;
	
	public CheckersBoard() {
		super("Checkers",ROWS,COLS);
		
		state = new CheckersState();
		logic = new CheckersLogic(state);
		checkersTurn = new CheckersTurn(state, logic);
		
		Utility.printMenu();
		
		turn = 1;
		
		state.getGameBoard().printBoard();
	
	}

	@Override
	public void setStartingTiles() {
		boolean colorFlag = true;
		for (int row = 0; row < rowsNum; ++row) {
			for (int col = 0; col < colsNum; ++col) {
				if(colorFlag) {
					getTile(row,col).setColor(Color.WHITE);
				}
				else {
					getTile(row,col).setColor(Color.BLACK);
				}
				colorFlag = !colorFlag;
			}
			colorFlag = !colorFlag;
		}
	}

	@Override
	public void setStartingPieces() {
		boolean colorFlag = false;
		for (int row = 0; row < rowsNum; ++row) {
			for (int col = 0; col < colsNum; ++col) {
				if(row <= 2 && colorFlag) {
					addPieceP1(row,col, new Piece(row,col,(new Image("/games/checkers/redCircle.png"))));
				}
				else if(row >= 5 && colorFlag) {
					addPieceP2(row,col, new Piece(row,col,(new Image("/games/checkers/whiteCircle.png"))));
				}
				colorFlag = !colorFlag;
			}
			colorFlag = !colorFlag;
		}
	}

	@Override
	public void setStartingImages() {
		/* None */
	}

	@Override
	public void forwardMouseClick(BoardCoord index) throws GameOverException {
		if(checkersTurn.getTurnStartRow() == -1 && checkersTurn.getTurnStartCol() == -1) {
			checkersTurn.setTurnStartRow(index.getRow());
			checkersTurn.setTurnStartCol(index.getCol());
		}
		else {
			checkersTurn.nextPlayersTurn(turn, checkersTurn.getTurnStartRow(), checkersTurn.getTurnStartCol(), index.getRow(), index.getCol());
			
			/// NEEDS TO BE FIXED
			if(turn % 2 == 1) {
				movePieceP1(checkersTurn.getTurnStartRow(), checkersTurn.getTurnStartCol(), index.getRow(), index.getCol());
			}
			else {
				movePieceP2(checkersTurn.getTurnStartRow(), checkersTurn.getTurnStartCol(), index.getRow(), index.getCol());
			}
			
			checkersTurn.setTurnStartRow(-1);
			checkersTurn.setTurnStartCol(-1);
			turn += 1;
			//updateBoard();
			if (endFlag) {
				throwGameIsOver();
			}
		}
	}

	@Override
	public void updateBoard() {
	}

}
