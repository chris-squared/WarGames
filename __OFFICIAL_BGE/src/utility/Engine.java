package utility;

import bge.Board;
import bge.Player;

public class Engine {
	State state; 
	Logic logic;
	Board board;
	PlayerProfile profiles;
	

	
	public Engine(State s, Logic l, Board b){
		state = s;
		logic = l;
		board = b; 
		System.out.println("BUILDING ENGINE SUCKAHS");
	}
	
	
	void ExecuteMove() {
		logic.executeMove();
	}
	
	void UpdateBoard() {
		board.updateBoard();
	}
	
	//Update the wins in a player's profile by 1
	void UpdateWins(Player p) {
		p.incWins();
		profiles.updatePlayer(p);
	}
	
	//Update the losses in a player's profile by 1
	void UpdateLosses(Player p) {
		p.incLosses();
		profiles.updatePlayer(p);
	}
	
	void runGame() {
		
		
	}
}
