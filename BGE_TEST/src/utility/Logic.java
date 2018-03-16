package utility;

import bge.Board;
import bge.Player;

public abstract class Logic {
	State state;
	Board board;
	
	protected Logic(State s, Board b){
		state = s;
		board = b; 
	}
	
	public abstract boolean win_condition();
	public abstract boolean isValidMove();
	public abstract void movePlayer(Player p);
	

}
