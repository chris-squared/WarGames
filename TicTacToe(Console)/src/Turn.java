import java.util.Scanner;

public class Turn {
	
	public static void playerTurn(Player player, Board gameBoard, int turn, Scanner in){
		System.out.println("Player 1 turn. Current turn: " + turn);
		int row = Utility.promptForRow(in);
		int column = Utility.promptForColumn(in);
		player.addGamePiece(gameBoard, column, row);
		State.addBoard(gameBoard);
		gameBoard.printBoard();
	}
}
