package utility;

import bge.Board;

public abstract class State {
		Board board;
		
	protected State(Board b){
		board = b;
	}
	
	public abstract Board getGameBoard();
	
}
