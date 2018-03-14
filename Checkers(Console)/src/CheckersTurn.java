import java.util.Scanner;

public class CheckersTurn extends Turn{
	public CheckersState state;
	public CheckersLogic logic;
	CheckersPlayer player1 = new CheckersPlayer(1, "[R]");
	CheckersPlayer player2 = new CheckersPlayer(2, "[B]");
	public CheckersTurn(CheckersState state, CheckersLogic logic) {
		super(state, logic);
		this.state = state;
		this.logic = logic;
	}
	@Override
	public void executeMove(Player player, Board gameBoard, int turn, Scanner in) {
		boolean validMove = true;
		while(validMove) {
		System.out.println("Player " + player.turn + " turn. Current turn: " + turn + " Color: " + player.gamePiece);
		int startRow = Utility.promptForStartRow(in);
		int startColumn = Utility.promptForStartColumn(in);
		int endRow = Utility.promptForEndRow(in);
		int endColumn = Utility.promptForEndColumn(in);
//		System.out.println(logic.isValidMove(player.gamePiece, startRow, startColumn, endRow, endColumn));
		if (logic.isValidMove(player.gamePiece, startRow, startColumn, endRow, endColumn)) {
			player.addGamePiece(gameBoard, startRow, startColumn, endRow, endColumn);
			validMove = false;
		}
		else
			System.out.println("Invalid Move.");
		gameBoard.printBoard();
		}
	}
	
	@Override
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
