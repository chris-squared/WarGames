package games.checkers;
import java.util.HashMap;

import bge.Board;
import bge.Piece;
import bge.Player;
import games.CheckersBoard;
import utility.State;
// Currently doesn't do anything, but it contains an arraylist that can save the board during each turn.
//import java.util.ArrayList;
public class CheckersState extends State{
	CheckersBoard board; 
	
	//Repositories for Players
	HashMap<Player, Piece> Player1Repo = new HashMap<Player, Piece>();
	HashMap<Player, Piece> Player2Repo = new HashMap<Player, Piece>();
	
	
	protected CheckersState(CheckersBoard b) {
		super(b);
		board = b;
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public CheckersBoard getGameBoard() {
		return board;
		
	}
	
	
}
