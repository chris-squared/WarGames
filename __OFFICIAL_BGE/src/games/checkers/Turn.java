package games.checkers;
import java.util.Scanner;
abstract class Turn {
	public State state;
	public Logic logic;
	Player player1;
	Player player2;
	
	public Turn(State state, Logic logic) {
		this.state = state;
		this.logic = logic;
	}
	
	public abstract void executeMove(Player player, Board gameBoard, int turn, Scanner in);
	
	public abstract boolean nextPlayersTurn(int currentTurn, Scanner in);
}
