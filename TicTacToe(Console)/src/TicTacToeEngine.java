import java.util.Scanner;
public class TicTacToeEngine extends Engine{
	
	public TicTacToeState state;
	public TicTacToeLogic logic;
	TicTacToePlayer player1 = new TicTacToePlayer(1, "[X]");
	TicTacToePlayer player2 = new TicTacToePlayer(2, "[O]");
	
	public TicTacToeEngine(TicTacToeState state, TicTacToeLogic logic) {
		super(state, logic);
		this.state = state;
		this.logic = logic;
	}
	
	public void executeMove(Player player, Board gameBoard, int turn, Scanner in){
		boolean validMove = true;
		while (validMove) {
			System.out.println("Player " + player.turn + " turn. Current turn: " + turn);
			int row = Utility.promptForRow(in);
			int column = Utility.promptForColumn(in);
			if(logic.isValidMove(row, column)) {
				player.addGamePiece(gameBoard, column, row);
				validMove = false;
			}
		}
		gameBoard.printBoard();
	}
	
	public boolean nextPlayersTurn(int currentTurn, Scanner in) {
		if (currentTurn % player2.turn == 0){
			executeMove(player2, state.gameBoard, currentTurn, in);
			if (logic.checkWinCondition(player2.gamePiece)) {
				System.out.println("player 2 wins!");
				return false;
			}
		}else{
			executeMove(player1, state.gameBoard, currentTurn, in);
			if (logic.checkWinCondition(player1.gamePiece)) {
				System.out.println("player 1 wins!");
				return false;
			}
		}
		return true;
	}
	
}
