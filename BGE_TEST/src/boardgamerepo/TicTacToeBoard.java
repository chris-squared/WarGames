package boardgamerepo;

import java.util.ArrayList;

import board_gui.Board;
import board_gui.BoardCoord;
import board_gui.Piece;
import javafx.scene.paint.Color;
import tictactoe.TicTacToeEngine;
import tictactoe.TicTacToeLogic;
import tictactoe.TicTacToeState;
import tictactoe.Utility;
public class TicTacToeBoard extends Board {
	
	static final int ROWS = 3;
	static final int COLS = 3;
	
	static final int windHeight = 500;
	static final int windWidth  = 500;
	
	TicTacToeState state;
	TicTacToeLogic ticTacToeLogic;
	TicTacToeEngine engine;
	
	int turn;
	
	
	public TicTacToeBoard() {
		super("Test TicTacToe",ROWS,COLS,windHeight,windWidth);
		state = new TicTacToeState();
		ticTacToeLogic = new TicTacToeLogic(state);
		engine = new TicTacToeEngine(state,ticTacToeLogic);
		
		Utility.printMenu();
		turn = 1;
		state.gameBoard.printBoard();
		// Turn determination and win conditions
		
	}
	
	public void forwardMouseClick(BoardCoord index) {
		engine.nextPlayersTurn(turn, index.getRow(), index.getCol());
		turn += 1;
		updateBoard();
	}
	
	public void updateBoard() {
		
		for (int i = 0; i < ROWS; ++i) {
			for (int j = 0; j < COLS; ++j) {
				if (state.gameBoard.board[i][j].equals("[X]")) {
					addPiece(i,j, new Piece(i,j,Color.BLUE));
				} 
				else if (state.gameBoard.board[i][j].equals("[O]")) {
					addPiece(i,j, new Piece(i,j,Color.RED));
				}
			}
		}
	}
	
	
	public void setStartingTiles() {
		
		for (int row = 0; row < rowsNum; ++row) {
			for (int col = 0; col < colsNum; ++col) {
				getTile(row,col).setOutlineColor(Color.BLACK);
			}
		}
	}
	
	public void setStartingPieces() {/* None */}
	
	public void setStartingImages() {/* None */}
	

}
