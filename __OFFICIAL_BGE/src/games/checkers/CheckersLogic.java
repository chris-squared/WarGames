package games.checkers;

import utility.Logic;
import bge.BoardCoord;
import bge.GameOverException;
import bge.Piece;
import bge.Player;
import bge.Tile;

public class CheckersLogic extends Logic{

	public CheckersState state;
	public CheckersLogic(CheckersState state) {
		super()
		state = state;
	}
	@Override
	public boolean check_win_condition(Piece p) {
		return state.Player1Repo == 0 || state.Player2Repo == 0; 
	}
	@Override
	public boolean isValidMove(Piece p, Tile start, Tile end) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void executeMove(Player p, BoardCoord bc) throws GameOverException {
		// TODO Auto-generated method stub
		
	}


}