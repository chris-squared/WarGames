package utility;



import bge.Board;



public abstract class State {
	Board board;
		
	protected State(){
		
	}
	protected void setBoard(Board b) {
		board = b;
	}
	
	public abstract Board getGameBoard();
	
}
