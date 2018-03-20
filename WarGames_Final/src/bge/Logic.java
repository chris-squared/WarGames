package bge;

public abstract class Logic {
	Board board;
	protected int has_move_function = 1;
	protected Logic(){ 
	}
	
	public Board getBoard() {
		return board;
	}
	
	public void setBoard(Board board) {
		this.board = board;
	}

	//Functions every Logic needs to implement? 
	public abstract boolean check_win_condition(Piece p);
	//This function is meant to be a facade so that you can call ExecuteMove from an engine and it'll run the appropriate ExecuteMove function, irregardless of game being played.
	public abstract void executeMove(Player p, BoardCoord bc) throws GameOverException;

	public boolean isValidMove(BoardCoord end) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
