package games;


import bge.Board;
import bge.BoardCoord;
import games.simonsays.SimonSaysEngine;
import games.simonsays.SimonSaysLogic;
import games.simonsays.SimonSaysState;
import games.simonsays.SimonSaysTurn;
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
	SimonSaysTurn simonTurn;
	//SimonSaysEngine engine;
	
	int turn;
	int startRowToRedraw = 0;
	int endRowToRedraw = 0;
	
	boolean endFlag;
	
	public SimonSaysBoard() {
		super("Simon Says",ROWS,COLS);
		
		state = new SimonSaysState();
		logic = new SimonSaysLogic(state);
		//engine = new SimonSaysEngine(state, logic);
		simonTurn =  new SimonSaysTurn(state, logic);
		
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
		
		for (int row = 0; row < rowsNum; row++) {
			for (int col = 0; col < colsNum; col++) {
				System.out.println("THE FUCKING COLOR IS : " + colors[row][col]);
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

		// EDIT TO TAKE IN ROW AND COL *****
		
		//LOOPS CURRENT TURN IF PLAYER IS GUESSING
		//-INCREMENTING/DECREMENTING TURN VALUE TO REMAIN AT SAME PLACE
		if (simonTurn.isGuessing) {
			turn -= 1;
			endFlag = !simonTurn.nextPlayersTurn(turn, simonTurn.getTurnStartRow(), simonTurn.getTurnStartCol(), index.getRow(), index.getCol());
			turn += 1;
		} 
		
		//OTHERWISE, ALTERNATES TO NEXT PLAYER
		else {
			endFlag = !simonTurn.nextPlayersTurn(turn, simonTurn.getTurnStartRow(), simonTurn.getTurnStartCol(), index.getRow(), index.getCol());
			turn += 1;
		}

		
		updateBoard();
		
		// IDEAL
		if (endFlag) {
			System.exit(0);
			//throwGameIsOver();
		}
		
	}

	@Override
	public void updateBoard() {
		// TODO Auto-generated method stub
		// ADD THIS TOO
	}

}
