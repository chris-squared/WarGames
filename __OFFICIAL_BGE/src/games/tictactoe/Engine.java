package games.tictactoe;
import java.util.Scanner;
abstract class Engine {
	public State state;
	public Logic logic;
	Player player1;
	Player player2;
	
	public Engine(State state, Logic logic) {
		this.state = state;
		this.logic = logic;
	}


	public abstract void executeMove(Player player, Board gameBoard, int turn, int row, int col);
	
	public abstract boolean nextPlayersTurn(int currentTurn, int row, int col);
}
