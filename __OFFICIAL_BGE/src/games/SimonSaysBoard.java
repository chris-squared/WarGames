package games;


import bge.Board;
import bge.BoardCoord;
import games.simonsays.SimonSaysEngine;
import games.simonsays.SimonSaysLogic;
import games.simonsays.SimonSaysState;
import games.simonsays.SimonSaysUtility;
import games.tictactoe.TicTacToeEngine;
import games.tictactoe.TicTacToeLogic;
import games.tictactoe.TicTacToeState;
import javafx.scene.paint.Color;

public class SimonSaysBoard extends Board {
	
	static final int ROWS = 3;
	static final int COLS = 3;
	
//	static final int windHeight = 500;
//	static final int windWidth = 500;
	
	
	SimonSaysState state;
	SimonSaysLogic logic;
	SimonSaysEngine engine;
	
	int turn;
	
	boolean endFlag;
	
	public SimonSaysBoard() {
		super("Simon Says",ROWS,COLS);
		
		state = new SimonSaysState();
		logic = new SimonSaysLogic(state);
		engine = new SimonSaysEngine(state, logic);
		
		SimonSaysUtility.printMenu();
		
		turn = 1;
		
		state.gameBoard.printBoard();
	
	}

	@Override
	public void setStartingTiles() {
		
		// Hard coded - Dont wanna deal with Color class
		Color[][] colors =  {
				
		{Color.RED,		Color.BLUE,		Color.GREEN,},
		{Color.PINK,	Color.PURPLE,	Color.YELLOW,},
		{Color.ORANGE,	Color.BROWN,	Color.SILVER}
		
		};
		//
		
		for (int row = 0; row < rowsNum; ++row) {
			for (int col = 0; col < colsNum; ++col) {
				getTile(row,col).setColor(colors[row][col]);
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
	public void forwardMouseClick(BoardCoord index) {
//		while (engine.nextPlayersTurn(turn)) {
//			turn+= 1;
//		}
		// TEMP
		if (turn > 9 || endFlag)
			System.exit(0);
		
		// EDIT TO TAKE IN ROW AND COL *****
		endFlag = !engine.nextPlayersTurn(turn, index.getRow(), index.getCol());
		
		turn += 1;
		//
		
		updateBoard();
		
		// IDEAL
		if (endFlag) {
			throwGameIsOver();
		}
		
	}

	@Override
	public void updateBoard() {
		// TODO Auto-generated method stub
		// ADD THIS TOO
	}

}
