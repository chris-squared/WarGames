package utility;

import bge.Board;
import bge.BoardCoord;
import bge.GameOverException;
import bge.Player;

public class Engine {
	State state; 
	Logic logic;
	Player p1;
	Player p2;
	public Board board;
	PlayerProfile profiles;
	int current_player = 0; 

	
	public Engine(State s, Logic l, Board b, Player Player1, Player Player2){
		state = s;
		logic = l;
		p1 = Player1;
		p2 = Player2; 
		board = b; 
		
	}
	
	
	void Move() throws GameOverException {
		Player cp = get_current_player(); 
		logic.executeMove(cp);
		swap_players(current_player);
	}
	
	private void swap_players(int current) {
		if (current == 0)
			current_player = 1;
		else
			current_player = 0; 
		
	}


	private Player get_current_player() {
		if (current_player == 0)
			return p1;
		else
			return p2; 
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


	public void forwardMouseClick(BoardCoord coordToBoardCoord) throws GameOverException {
		System.out.println("ENGINE CLICKED");
		Move();
		
	}
}
