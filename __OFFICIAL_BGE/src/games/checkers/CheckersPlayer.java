//package games.checkers;
//public class CheckersPlayer extends Player{
//
//	public static int red = 12;
//	public static int black = 12;
//	
//	public CheckersPlayer(int turn, String gamePiece){
//		super(turn, gamePiece);
//	}
//	
//	public void addGamePiece(Board gameBoard, int startRow, int startColumn, int endRow, int endColumn) {
//		gameBoard.board[startRow][startColumn] = "[ ]";
//		gameBoard.board[endRow][endColumn] = gamePiece;
//		if (CheckersLogic.isValidJump(gameBoard.board, gamePiece, startRow, startColumn, endRow, endColumn)) {
//			if (gameBoard.board[(startRow + endRow)/2][(startColumn+endColumn)/2].equals("[R]"))
//				CheckersPlayer.red -= 1;
//			else {
//				CheckersPlayer.black -= 1;
//			}
//			System.out.println("Red Remaining: " + CheckersPlayer.red + "Black Remaining: " + CheckersPlayer.black);
//			gameBoard.board[(startRow + endRow)/2][(startColumn+endColumn)/2] = "[ ]";
//		}
//	}
//	
//}
package games.checkers;
public class CheckersPlayer extends Player{

	public static int red = 12;
	public static int black = 12;
	
	public CheckersPlayer(int turn, String gamePiece, String gamePiece2){
		super(turn, gamePiece);
	}
	
	public void addGamePiece(Board gameBoard, int startRow, int startColumn, int endRow, int endColumn) {
		gameBoard.board[startRow][startColumn] = "[ ]";
		gameBoard.board[endRow][endColumn] = gamePiece;
		if (CheckersLogic.isValidJump(gameBoard.board, gamePiece, startRow, startColumn, endRow, endColumn)) {
			executeJump(gameBoard,startRow, startColumn, endRow, endColumn);	
		}
	}
	
	public void addGameKing(Board gameBoard, int startRow, int startColumn, int endRow, int endColumn) {
		gameBoard.board[startRow][startColumn] = "[ ]";
		gameBoard.board[endRow][endColumn] = "[K]";
	}

	public void addGameKing2(Board gameBoard, int startRow, int startColumn, int endRow, int endColumn) {
		gameBoard.board[startRow][startColumn] = "[ ]";
		gameBoard.board[endRow][endColumn] = "[Q]";
	}
	
	public void kingMove(Board gameBoard, int startRow, int startColumn, int endRow, int endColumn) {
		gameBoard.board[startRow][startColumn] = "[ ]";
		gameBoard.board[endRow][endColumn] = "[K]";
		if (CheckersLogic.isValidJump(gameBoard.board, gamePiece, startRow, startColumn, endRow, endColumn)) {
			executeJump(gameBoard,startRow, startColumn, endRow, endColumn);
		}
	}
	
	public void kingMove2(Board gameBoard, int startRow, int startColumn, int endRow, int endColumn) {
		gameBoard.board[startRow][startColumn] = "[ ]";
		gameBoard.board[endRow][endColumn] = "[Q]";
		if (CheckersLogic.isValidJump(gameBoard.board, gamePiece, startRow, startColumn, endRow, endColumn)) {
			executeJump(gameBoard,startRow, startColumn, endRow, endColumn);
		}
	}
	
	public void executeJump(Board gameBoard, int startRow, int startColumn, int endRow, int endColumn) {
		if (gameBoard.board[(startRow + endRow)/2][(startColumn+endColumn)/2].equals("[R]"))
			CheckersPlayer.red -= 1;
		else {
			CheckersPlayer.black -= 1;
		}
		System.out.println("Red Remaining: " + CheckersPlayer.red + "Black Remaining: " + CheckersPlayer.black);
		gameBoard.board[(startRow + endRow)/2][(startColumn+endColumn)/2] = "[ ]";
		
	}
	
}
