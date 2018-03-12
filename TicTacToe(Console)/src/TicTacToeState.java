public class TicTacToeState extends State{
	TicTacToeBoard gameBoard;
	
	public TicTacToeState() {
		gameBoard = new TicTacToeBoard(3,3,"[ ]");
	}

	public TicTacToeBoard getGameBoard() {
		return gameBoard;
	}
	
	
}
