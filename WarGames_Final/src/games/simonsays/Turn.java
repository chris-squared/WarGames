package games.simonsays;
import bge.Logic;
import utility.State;
public abstract class Turn {
	public State state;
	public Logic logic;
	Player player1;
	Player player2;
	
	public Turn(State state, Logic logic) {
		this.state = state;
		this.logic = logic;
	}
	
	public abstract boolean nextPlayersTurn(int currentTurn, int startRow, int startCol, int endRow, int endCol);

	public abstract void executeMove(Player player, Board gameBoard, int turn, int startRow, int startCol, int endRow, int endCol);
}
