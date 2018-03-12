import java.util.Scanner;
abstract class SampleMain{
		/**Runs a new instance of a Game.
		 * @param args not used*/
		public static void main(String[] args) {
			//Initialize game elements
			Scanner in = new Scanner(System.in);
//			TicTacToeState state = new TicTacToeState();//Initialize new game state, state initializes a new board.
//			TicTacToeLogic ticTacToeLogic = new TicTacToeLogic(state); // Initialize new game logic
//			TicTacToeEngine engine = new TicTacToeEngine(state,ticTacToeLogic); // initialize new game engine
//			Utility.printMenu(); // Optionally print a menu
//			int turn = 1; // initialize a turn integer to 1 to keep track of alternating turns.
//			state.gameBoard.printBoard(); // In the console version, print an initial empty board.
//			// Turn determination and win conditions
//			while (engine.nextPlayersTurn(turn,in)){ // ALternate turns and define methods in the engine.
//				turn += 1; // increment the turn, once a winner is determined, the game ends.
//			}
			in.close();
		}
}
