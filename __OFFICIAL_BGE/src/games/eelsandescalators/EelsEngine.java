package games.eelsandescalators;

import bge.Board;
import bge.GameOverException;
import bge.Player;
import games.EelsAndEscalatorsBoard;
import utility.DiceRoller;

public class EelsEngine {
	EelsAndEscalatorsBoard board;
	EelsState state;
	EelsLogic logic;
	DiceRoller dr;
	Player P1;
	
	public EelsEngine(EelsAndEscalatorsBoard b, EelsState s, EelsLogic l){
		dr = new DiceRoller();
		P1 = new Player("Chris", 0, "X");
		board = b;
		state = s;
		logic = l; 
		setPlayer();
		printConsoleBoard();
		state.playerLocationRepo.put(P1, 1);
		state.addEel(3, 1);
		state.addEscalator(5, 10);
		state.addEel(8, 2);
		state.addEscalator(20, 24);
		state.addEel(33, 27);
		state.addEel(99, 85);

	}

		public void makeTurn() throws GameOverException {
			int roll = dr.rollDice(2, 7);
			System.out.println(roll);
			logic.move(P1, roll);
			if (logic.is_winner(P1))
				board.throwGameIsOver();
			
		}
	
	public void setPlayer() {
		board.setStartingPieces();
	}
	public void printConsoleBoard() {
		System.out.println("INITIALIZING BOARD...");
		for (int i = 0; i < board.getRowsNum(); i++) {
			for (int j = 0; j < board.getColsNum(); j++)
				if (board.getPieceP1(i, j) != null)
					System.out.print("[X]");
				else
					System.out.print("[ ]");
			System.out.println("");}
	}
	
	

}
