package games.checkers;
/**Instantiate a constructor with a new Board with dimensions of your game.
 * Can also be used to add functionality to store previous board states.*/
abstract class State {
	// Example: TicTacToeBoard gameBoard;
	public State() {
		// Example: gameBoard = new TicTacToeBoard(3,3,"[ ]");
	}

	public abstract Board getGameBoard();
}
