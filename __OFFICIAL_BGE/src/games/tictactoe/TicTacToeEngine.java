package games.tictactoe;
import bge.Player;
import main.Main;

import java.util.Scanner;
public class TicTacToeEngine{
	
	public TicTacToeState state;
	public TicTacToeLogic logic;
//	TicTacToePlayer player1 = new TicTacToePlayer(1, "[X]");
//	TicTacToePlayer player2 = new TicTacToePlayer(2, "[O]");
	Player player1 = Main.player1;
	Player player2 = Main.player2;
//	Player player1 = new Player("Player1",1,"[X]");
//	Player player2 = new Player("Player2",2,"[O]");


	public TicTacToeEngine(TicTacToeState state, TicTacToeLogic logic) {
		this.state = state;
		this.logic = logic;
		Main.player1.setGamePiece("[X]");
		Main.player2.setGamePiece("[O]");

	}
	
	public void executeMove(Player player, Board gameBoard, int turn, int row, int col) {
		System.out.println("Player " + player.turn + " turn. Current turn: " + turn);
		if(logic.isValidMove(row, col)) {
			addGamePiece(gameBoard, player.gamePiece, col, row);
		}
		gameBoard.printBoard();
	}
	
	public boolean nextPlayersTurn(int currentTurn, int row, int col) {
		if (currentTurn % player2.turn == 0){
			executeMove(player2, state.gameBoard, currentTurn, row, col);
			if (logic.checkWinCondition(player2.gamePiece)) {
				Main.player2.incWins();
				Main.player1.incLosses();
				System.out.println("player 2 wins! : " + Main.player2.getPlayerWins());

				return false;
			}
		}else{
			executeMove(player1, state.gameBoard, currentTurn, row, col);
			if (logic.checkWinCondition(player1.gamePiece)) {
				Main.player1.incWins();
				Main.player2.incLosses();
				System.out.println("player 1 wins! : " + Main.player1.getPlayerWins());

				return false;
			}
		}
		return true;
	}
	
	public void addGamePiece(Board gameBoard, String gamePiece, int column, int row) {
		gameBoard.board[row][column] = gamePiece;
	}
	
}
