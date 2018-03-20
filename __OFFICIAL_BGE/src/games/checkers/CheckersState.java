package games.checkers;
import utility.State;
// Currently doesn't do anything, but it contains an arraylist that can save the board during each turn.
//import java.util.ArrayList;
public class CheckersState extends State{
	CheckersBoard gameBoard;
	
	public CheckersState() {
		super();
		gameBoard = new CheckersBoard(8,8,"[ ]");
	}
	
	public Board returnGameBoard() {
		return gameBoard;
	}

	@Override
	public bge.Board getGameBoard() {
		// TODO Auto-generated method stub
		return null;
	}
}
