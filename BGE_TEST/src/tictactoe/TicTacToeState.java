package tictactoe;

public class TicTacToeState extends State{
	public TicTacToeBoard gameBoard;
	
	public TicTacToeState() {
		gameBoard = new TicTacToeBoard(3,3,"[ ]");
	}

	public TicTacToeBoard getGameBoard() {
		return gameBoard;
	}
	
	
}
