package games.simonsays;

import java.util.Scanner;

public class SimonSays {
	public static void main(String[] args) {
		//INITIALIZATION
		Scanner in = new Scanner(System.in);
		SimonSaysState state = new SimonSaysState();
		SimonSaysLogic logic = new SimonSaysLogic(state);
		SimonSaysEngine engine = new SimonSaysEngine(state, logic);
		
		
		/*This should be printing 'Welcome to Simon Says!*/
		//Utility.printMenu();
		
		/*Using SimonSaysUtility instead*/
		SimonSaysUtility.printMenu();
		
		int turn = 1;
		state.gameBoard.printBoard();
		
		while (engine.nextPlayersTurn(turn, in)) {
			turn+= 1;
		}
		in.close();
	}
}
