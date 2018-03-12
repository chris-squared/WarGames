abstract class Logic{
	public State state;
	/**Logic constructor that takes in the current state of the game in 
	 * order to determine if a move is valid or to check win conditions.*/
	public Logic(State state) {
		this.state = state;
	}
	
	/**Checks the win conditions on the game
	 * @param gamePiece the player's piece on the board (example: "[X] in tic tac toe")
	 * @return true if the current player has won, false otherwise.*/
	public abstract boolean checkWinCondition(String gamePiece);
	
	/**Checks if the move in the selected gridPiece is valid.
	 * @return true if the move is valid, false otherwise.*/
	public abstract boolean isValidMove(int row, int column);
	
}