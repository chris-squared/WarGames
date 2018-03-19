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
	
	int startRowToRedraw = 0;
	int endRowToRedraw = 0;
	
	boolean endFlag;
	
	public CheckersBoard() {
		super("Checkers",ROWS,COLS);
		
		state = new CheckersState();
		logic = new CheckersLogic(state);
		checkersTurn = new CheckersTurn(state, logic);
		
		Utility.printMenu();
		
		turn = 0;
		
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
			if(checkersTurn.nextPlayersTurn(turn, checkersTurn.getTurnStartRow(), checkersTurn.getTurnStartCol(), index.getRow(), index.getCol())){
				startRowToRedraw = checkersTurn.getTurnStartRow();
				turn += 1;
			}
			
			endRowToRedraw = index.getRow();
			
			checkersTurn.setTurnStartRow(-1);
			checkersTurn.setTurnStartCol(-1);
			
			if(checkersTurn.black == 0 || checkersTurn.red == 0){
				endFlag = true;
			}
				
			//System.out.println("//////////////////////   Turn " + turn);
			updateBoard();
			if (endFlag) {
				throwGameIsOver();
			}
			
		}
	}

	@Override
	public void updateBoard() {
		if(startRowToRedraw > endRowToRedraw) {
			int temp = startRowToRedraw;
			startRowToRedraw = endRowToRedraw;
			endRowToRedraw = temp;
		}
		
		for(int row = startRowToRedraw; row <= endRowToRedraw; row++) {
			for(int col = 0; col < COLS; col++) {
				if(state.getGameBoard().board[row][col].equals("[R]")) {
					addPieceP1(row,col, new Piece(row,col,(new Image("/games/checkers/redCircle.png"))));
				}
				else if(state.getGameBoard().board[row][col].equals("[B]")) {
					addPieceP2(row,col, new Piece(row,col,(new Image("/games/checkers/whiteCircle.png"))));
				}
				else if(state.getGameBoard().board[row][col].equals("[K]")) {
					addPieceP2(row,col, new Piece(row,col,(new Image("/games/checkers/RedKing.png"))));
				}
				else if(state.getGameBoard().board[row][col].equals("[Q]")) {
					addPieceP2(row,col, new Piece(row,col,(new Image("/games/checkers/BlackKing.png"))));
				}
				else {
					addPieceP1(row, col, null);
					addPieceP2(row, col, null);
				}
			}
		}
	}

}
