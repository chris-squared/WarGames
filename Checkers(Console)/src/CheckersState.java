// Currently doesn't do anything, but it contains an arraylist that can save the board during each turn.
//import java.util.ArrayList;
public class CheckersState extends State{
	CheckersBoard gameBoard;
	
	public CheckersState() {
		gameBoard = new CheckersBoard(8,8,"[ ]");
	}
	
	@Override
	public Board getGameBoard() {
		return gameBoard;
	}
	
}
