import java.util.Scanner;

public class Turn {
	
	public static void playerTurn(Player player, Board gameBoard, int turn, Scanner in){
		System.out.println("Player " + player.turn + " turn. Current turn: " + turn + " Color: " + player.gamePiece);
		int startRow = Utility.promptForStartRow(in);
		int startColumn = Utility.promptForStartColumn(in);
		int endRow = Utility.promptForEndRow(in);
		int endColumn = Utility.promptForEndColumn(in);
		System.out.println(Logic.isValidMove(gameBoard.board, player.gamePiece, startRow, startColumn, endRow, endColumn));
		if (Logic.isValidMove(gameBoard.board, player.gamePiece, startRow, startColumn, endRow, endColumn)) {
			player.executeMove(gameBoard.board, startRow, startColumn, endRow, endColumn);
		}
		gameBoard.printBoard();
//		State.addBoard(gameBoard);
	}
	
	
}
