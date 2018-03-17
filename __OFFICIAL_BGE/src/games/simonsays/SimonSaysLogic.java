package games.simonsays;

public class SimonSaysLogic extends Logic {
	public SimonSaysState state;
	
	public SimonSaysLogic(SimonSaysState state) {
		super(state);
		this.state = state;
	}

	public boolean checkWinCondition(String gamePiece) {
		System.out.println("No Winner Yet! SimonSaysLogic #12");
		return false;
	}

	//DONT NEED THIS FOR SIMON SAYS?
	public boolean isValidMove(String gamePiece, int startRow, int startColumn, int endRow, int endColumn) {
		// TODO Auto-generated method stub
		return false;
	}

}
