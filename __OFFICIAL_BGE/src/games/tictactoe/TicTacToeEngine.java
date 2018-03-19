package games.tictactoe;
import java.util.Scanner;
public class TicTacToeEngine{
	
	public TicTacToeState state;
	public TicTacToeLogic logic;
	TicTacToePlayer player1 = new TicTacToePlayer(1, "[X]");
	TicTacToePlayer player2 = new TicTacToePlayer(2, "[O]");
	
	public TicTacToeEngine(TicTacToeState state, TicTacToeLogic logic) {
		this.state = state;
		this.logic = logic;
	}
	
	public void executeMove(TicTacToePlayer player, Board gameBoard, int turn, int row, int col) {
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
				System.out.println("player 2 wins!");
				return false;
			}
		}else{
			executeMove(player1, state.gameBoard, currentTurn, row, col);
			if (logic.checkWinCondition(player1.gamePiece)) {
				System.out.println("player 1 wins!");
				return false;
			}
		}
		return true;
	}
	
	public void addGamePiece(Board gameBoard, String gamePiece, int column, int row) {
		gameBoard.board[row][column] = gamePiece;
	}
	
}
