package games.simonsays;
import utility.State;
public class SimonSaysState extends State {
	public SimonSaysBoard gameBoard;
	
	public SimonSaysState() {
		gameBoard = new SimonSaysBoard(3, 3, "[ ]");
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
