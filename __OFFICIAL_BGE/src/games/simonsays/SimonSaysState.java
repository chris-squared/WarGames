package games.simonsays;
public class SimonSaysState extends State {
	public SimonSaysBoard gameBoard;
	
	public SimonSaysState() {
		gameBoard = new SimonSaysBoard(3, 3, "[ ]");
	}
	
	public Board getGameBoard() {
		return gameBoard;
	}

}
