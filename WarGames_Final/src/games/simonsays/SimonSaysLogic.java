package games.simonsays;
import bge.BoardCoord;
import bge.GameOverException;
import bge.Logic;
import bge.Piece;
import bge.Player;
public class SimonSaysLogic extends Logic {
	public SimonSaysState state;
	
	public SimonSaysLogic(SimonSaysState state) {
		super();
		this.state = state;
		has_move_function = 0;
	}

	
	
	public boolean checkWinCondition(String gamePiece) {
		return false;
	}

	//DONT NEED THIS FOR SIMON SAYS?
	public boolean isValidMove(String gamePiece, int startRow, int startColumn, int endRow, int endColumn) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean check_win_condition(Piece p) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public void executeMove(Player p, BoardCoord bc) throws GameOverException {
		// TODO Auto-generated method stub
		
	}

}
