import java.util.Scanner;
/**The Checkers Class runs a new instance of the Checkers Game.*/
public class Checkers {
	/**Runs a new instance of the Checkers Game.
	 * @param args not used*/
	public static void main(String[] args) {
		//Initialize game elements
		Scanner in = new Scanner(System.in);
		CheckersState state = new CheckersState();
		CheckersLogic logic = new CheckersLogic(state);
		CheckersTurn turnState = new CheckersTurn(state, logic);
		Utility.printMenu();
		int turn = 1;
		state.gameBoard.printBoard();
		// Turn determination and win conditions
		while (turnState.nextPlayersTurn(turn, in)) {
			turn += 1;
			}
		in.close();
	}
	
}