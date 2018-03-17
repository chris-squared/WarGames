package games;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import bge.Board;
import bge.BoardCoord;
import bge.GameOverException;
import bge.InvalidMoveException;
import bge.Piece;
import games.tictactoe.TicTacToeEngine;
import games.tictactoe.TicTacToeLogic;
import games.tictactoe.TicTacToeState;
import games.tictactoe.Utility;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class TicTacToeBoard extends Board {
	
	static final int ROWS = 3;
	static final int COLS = 3;
	
//	static final int windHeight = 500;
//	static final int windWidth  = 500;

//	static double windHeight = 500;
//	static double windWidth = 500;

	TicTacToeState state;
	TicTacToeLogic ticTacToeLogic;
	TicTacToeEngine engine;
	
	int turn;
	
	// TEMP - Find way to use throw methods
	boolean endFlag;
	//
	
	
	public TicTacToeBoard() {
		super("Test TicTacToe",ROWS,COLS);
		state = new TicTacToeState();
		ticTacToeLogic = new TicTacToeLogic(state);
		engine = new TicTacToeEngine(state,ticTacToeLogic);
		
		Utility.printMenu();
		turn = 1;
		state.gameBoard.printBoard();
		// Turn determination and win conditions
		
	}
	
	public void forwardMouseClick(BoardCoord index) throws GameOverException, InvalidMoveException {
		
		// TEMP
		if (turn > 9 || endFlag)
			System.exit(0);
		
		endFlag = !engine.nextPlayersTurn(turn, index.getRow(), index.getCol());
		
		turn += 1;
		//
		
		updateBoard();
		
		// IDEAL
		if (endFlag) {
			throwGameIsOver();
		}
	}
	
	public void updateBoard() {
		
		for (int i = 0; i < ROWS; ++i) {
			for (int j = 0; j < COLS; ++j) {
				if (state.gameBoard.board[i][j].equals("[X]")) {
					addPieceP1(i,j, new Piece(i,j,(new Image("/games/tictactoe/x.png"))));
				} 
				else if (state.gameBoard.board[i][j].equals("[O]")) {
					addPieceP2(i,j, new Piece(i,j,(new Image("/games/tictactoe/o.png"))));
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
