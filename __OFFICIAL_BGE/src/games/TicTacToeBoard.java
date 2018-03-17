package games;

import java.io.File;
import java.util.ArrayList;
import bge.Board;
import bge.BoardCoord;
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
	boolean endCheck;
	
	
	public TicTacToeBoard() {
		super("Test TicTacToe",ROWS,COLS,500,500);
		state = new TicTacToeState();
		ticTacToeLogic = new TicTacToeLogic(state);
		engine = new TicTacToeEngine(state,ticTacToeLogic);
		
		Utility.printMenu();
		turn = 1;
		state.gameBoard.printBoard();
		// Turn determination and win conditions
		
	}
	
	public void forwardMouseClick(BoardCoord index) {
		if (turn > 9 || endCheck)
			System.exit(turn);
		endCheck = !engine.nextPlayersTurn(turn, index.getRow(), index.getCol());
		turn += 1;
		updateBoard();
	}
	
	public void updateBoard() {
		
		System.out.println(new File("/hello/tictactoe/o.png").getPath());
		
		for (int i = 0; i < ROWS; ++i) {
			for (int j = 0; j < COLS; ++j) {
				if (state.gameBoard.board[i][j].equals("[X]")) {
					addPiece(i,j, new Piece(i,j,(new Image("File:/games/tictactoe/o.jpg"))));
				} 
				else if (state.gameBoard.board[i][j].equals("[O]")) {
					addPiece(i,j, new Piece(i,j,(new Image("File:/games/tictactoe/o.jpg"))));
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