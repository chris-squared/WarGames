package games.simonsays2;

import bge.GameOverException;
import bge.Player;
import games.SimonSaysBoard;

public class SimonSaysEngine2 {
	SimonSaysBoard board;
	SimonSaysState2 state;
	SimonSaysLogic2 logic;
	
	Player P1;
	Player P2;
	int player_num = 1;
	Player currentPlayer;
	Player otherPlayer;
	
	public boolean continueGame = true;
	public boolean isGuessing = false;
	
	public SimonSaysEngine2(SimonSaysBoard b, SimonSaysState2 s, SimonSaysLogic2 l) {
		P1 = new Player("Quang", 1, "X");
		P2 = new Player("Saul", 2, "Y");
		board = b;
		state = s;
		logic = l;
		
	}
	
	public void makeTurn(int turn) throws GameOverException {
			
	}
	
}
