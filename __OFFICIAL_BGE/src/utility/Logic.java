package utility;

import bge.Board;
import bge.Piece;

import bge.Tile;

public abstract class Logic {
	Board board;
	
	protected Logic(Board b){
		board = b; 
	}
	
	//Functions every Logic needs to implement? 
	public abstract boolean check_win_condition(Piece p);
	public abstract boolean isValidMove(Piece p, Tile start, Tile end);
	//This function is meant to be a facade so that you can call ExecuteMove from an engine and it'll run the appropriate ExecuteMove function, irregardless of game being played.
	public abstract void executeMove();

	

}
