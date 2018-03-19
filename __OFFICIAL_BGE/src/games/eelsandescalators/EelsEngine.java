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
	Player P2; 
	int player_num = 0;
	Player currentPlayer;
	
	public EelsEngine(EelsAndEscalatorsBoard b, EelsState s, EelsLogic l){
		dr = new DiceRoller();
		P1 = new Player("Chris", 0, "X");
		P2 = new Player("Nick", 1, "Y");
		board = b;
		state = s;
		logic = l; 
		setPlayer();
		printConsoleBoard();
		state.playerLocationRepo.put(P1, 1);
		state.playerLocationRepo.put(P2, 1);
		state.addEel(3, 1);
		state.addEscalator(5, 10);
		state.addEel(8, 2);
		state.addEscalator(20, 24);
		state.addEel(33, 27);
		state.addEel(99, 85);

	}

		public void makeTurn() throws GameOverException {
			if (player_num == 0) {
				currentPlayer = P1;
			}
			else
				currentPlayer = P2;
			int roll = dr.rollDice(2, 7);
			System.out.println(roll);
			logic.move(currentPlayer, roll);
			if (logic.is_winner(currentPlayer))
				board.throwGameIsOver();
			if (player_num == 0){
				player_num = 1;
			}
			else
				player_num = 0;
			
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
