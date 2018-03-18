package games.simonsays;

import java.util.ArrayList;
import java.util.Scanner;

public class SimonSaysEngine extends Engine {
	public boolean continueGame;
	public SimonSaysState state;
	public SimonSaysLogic logic;
	SimonSaysPlayer player1 = new SimonSaysPlayer(1, "p1");
	SimonSaysPlayer player2 = new SimonSaysPlayer(2, "p2");

	Color clickedColor;
	
	public SimonSaysEngine(SimonSaysState state, SimonSaysLogic logic) {
		super(state, logic);
		this.continueGame = true;
		this.state = state;
		this.logic = logic;
	}
	
	public void executeMove(SimonSaysPlayer player, SimonSaysPlayer otherPlayer, Board gameBoard, int turn, int row, int col) {
		System.out.println("Player " + player.turn + " turn. Current turn: " + turn);
		//MAYBE USE STATE??
		if (turn == 1) {
			clickedColor = SimonSaysUtility.coordsToColor(row, col);
			otherPlayer.simonPattern.add(clickedColor);
		} 
		else if (turn == 2) {
			SimonSaysBoard temp = state.gameBoard;
			System.out.println(temp.board[0][0]);
		}
		
		System.out.println();
		System.out.println("=== TESTING PURPOSES ===");
		System.out.println("Player " + player.turn + " Simon Pattern: " + player.simonPattern);
		System.out.println("Player " + otherPlayer.turn + " Simon Pattern: " + otherPlayer.simonPattern);
		System.out.println("=========================");
		System.out.println();
	}

	public void executeMove(SimonSaysPlayer player, SimonSaysPlayer otherPlayer, Board gameBoard, int turn, Scanner in) {
		System.out.println("Player " + player.turn + " turn. Current turn: " + turn);
		Color tempColor;
		ArrayList<Color> tempList = new ArrayList<Color>(player.simonPattern);
		/*First turn: P1 sets up pattern for P2*/
		if (turn == 1) {
			tempColor = SimonSaysUtility.promptToAddColor(in);
			otherPlayer.simonPattern.add(tempColor);
			
		}
		/*Second turn: P2 guesses -> IF SUCCESSFUL -> P2 sets up pattern for P1*/
		else if (turn == 2) {
			System.out.println("=== GUESSING TURN! ===");
			System.out.println("Repeat your assigned pattern: ");
			while(!tempList.isEmpty()) {
				Color guess = SimonSaysUtility.promptToGuessColor(in);
				if (tempList.get(0) != guess) {
					continueGame = false;
					return;
				}
				tempList.remove(0);
			}
			System.out.println("=== ADDING TURN! ===");
			tempColor = SimonSaysUtility.promptToAddColor(in);
			otherPlayer.simonPattern.add(tempColor);
		} 
		/*Player guesses -> Set up pattern for other player -> Repeat*/
		else {
			System.out.println("=== GUESSING TURN! ===");
			System.out.println("Repeat your assigned pattern: ");
			while(!tempList.isEmpty()) {
				Color guess = SimonSaysUtility.promptToGuessColor(in);
				if (tempList.get(0) != guess) {
					continueGame = false;
					return;
				}
				tempList.remove(0);
			}
			System.out.println("=== ADDING TURN! ===");
			tempColor = SimonSaysUtility.promptToAddColor(in);
			otherPlayer.simonPattern.add(tempColor);
		}

		System.out.println("=== TESTING PURPOSES ===");
		System.out.println("Player " + player.turn + " Simon Pattern: " + player.simonPattern);
		System.out.println("Player " + otherPlayer.turn + " Simon Pattern: " + otherPlayer.simonPattern);
		System.out.println("=========================");
		System.out.println();
	}
	
	public boolean nextPlayersTurn(int currentTurn, int row, int col) {
		if (currentTurn % player2.turn == 0) {
			executeMove(player2, player1, state.gameBoard, currentTurn, row, col);
		} else {
			executeMove(player1, player2, state.gameBoard, currentTurn, row, col);
		}
		return continueGame;
	}
	public boolean nextPlayersTurn(int currentTurn, Scanner in) {
		if (currentTurn % player2.turn == 0) {
			executeMove(player2, player1, state.gameBoard, currentTurn, in);
		} else {
			executeMove(player1, player2, state.gameBoard, currentTurn, in);
		}
		return continueGame;
	}

	
	//OVERRIDEN WITH SIMONSAYSPLAYER INSTEAD OF PLAYER
	//OVERRIDEN TO INCLUDE OTHER PLAYER FOR ADDING TO SIMON PATTERN
	@Override
	public void executeMove(Player player, Board gameBoard, int turn, Scanner in) {
		// TODO Auto-generated method stub
		
	}

}
