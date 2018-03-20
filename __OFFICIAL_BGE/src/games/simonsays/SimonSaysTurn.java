package games.simonsays;

import java.util.ArrayList;
import java.util.Arrays;

public class SimonSaysTurn extends Turn {
	public SimonSaysState state;
	public SimonSaysLogic logic;
	public SimonSaysPlayer player1 = new SimonSaysPlayer("Tron", 1, "[*]");
	public SimonSaysPlayer player2 = new SimonSaysPlayer("CLU", 2, "[*]");
	
	public boolean continueGame = true;
	public boolean isGuessing = false;
	
	public int turnStartRow = -1;
	public int turnStartCol = -1;
	
	public SimonSaysTurn(SimonSaysState state, SimonSaysLogic logic) {
		super(state, logic);
		this.state = state;
		this.logic = logic;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean nextPlayersTurn(int currentTurn, int startRow, int startCol, int endRow, int endCol) {
		// TODO Auto-generated method stub
		if (currentTurn % player2.turn == 0) {
			System.out.println("****YEE-HAW! ITS PLAYER 2'S TURN*****");
			executeMove(player2, player1, state.gameBoard, currentTurn, startRow, startCol, endRow, endCol);
		} else {
			System.out.println("****YEE-HAW! ITS PLAYER 2'S TURN*****");
			executeMove(player1, player2, state.gameBoard, currentTurn, startRow, startCol, endRow, endCol);
		}
		return continueGame;
}

	public void executeMove(SimonSaysPlayer player, SimonSaysPlayer otherPlayer, Board gameBoard, int turn, int startRow, int startCol, int endRow,
			int endCol) {
		Color tempColor;
		if (turn == 1) {
			System.out.println("=== PLAYER " + player.turn + "'s ADDING TURN! ===");
			tempColor = SimonSaysUtility.coordsToColor(endRow, endCol);
			otherPlayer.simonPattern.add(tempColor);
			otherPlayer.reloadCopy();
			return;
		} 
		else {
			System.out.println("=== PLAYER " + player.turn + "'s GUESSING TURN! ===");
			isGuessing = true;
			Color guess = SimonSaysUtility.coordsToColor(endRow, endCol);
			System.out.println("> " + guess);
			if (!player.simonCopy.isEmpty()) {
				if (guess == player.simonCopy.get(0)) {
					player.simonCopy.remove(0);
				}
				else if (guess != player.simonCopy.get(0)) {
					System.out.println("Player " + otherPlayer.turn + " wins!");
					System.out.println("Player " + player.turn + " loses!");
					System.out.println("Correct pattern was : " + player.simonPattern);
					continueGame = false;
				}
				return;
			}
			
			if (player.simonCopy.isEmpty()) {
				isGuessing = false;
				System.out.println("=== PLAYER " + player.turn + "'s ADDING TURN! ===");
				tempColor = SimonSaysUtility.coordsToColor(endRow, endCol);
				otherPlayer.simonPattern.add(tempColor);
				otherPlayer.reloadCopy();
				return;
			}
			
			System.out.println("===TESTING===");
			System.out.println("player: " + player.turn);
			System.out.println("player pattern: " + player.simonPattern);
			System.out.println("other player pattern: " + otherPlayer.simonPattern);
			System.out.println("==============");
			
		}
	}


	

	public int getTurnStartRow() {
		return turnStartRow;
	}
	
	public void setTurnStartRow(int turnStartRow) {
		this.turnStartRow = turnStartRow;
	}
	public int getTurnStartCol() {
		return turnStartCol;
	}
	public void setTurnStartCol(int turnStartCol) {
		this.turnStartCol = turnStartCol;
	}

	@Override
	public void executeMove(Player player, Board gameBoard, int turn, int startRow, int startCol, int endRow,
			int endCol) {
		// TODO Auto-generated method stub
		
	}
}
