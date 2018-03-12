import java.util.Scanner;
/**The TicTacToe Class runs a new instance of the TicTacToe Game.*/
public class TicTacToe {
	/**Runs a new instance of the TicTacToe Game.
	 * @param args not used*/
	public static void main(String[] args) {
		//Initialize game elements
		Scanner in = new Scanner(System.in);
		TicTacToeState state = new TicTacToeState();
		TicTacToeLogic ticTacToeLogic = new TicTacToeLogic(state);
		TicTacToeEngine engine = new TicTacToeEngine(state,ticTacToeLogic);
		Utility.printMenu();
		int turn = 1;
		state.gameBoard.printBoard();
		// Turn determination and win conditions
		while (engine.nextPlayersTurn(turn, in)) {
			turn += 1;
			}
		in.close();
	}
}