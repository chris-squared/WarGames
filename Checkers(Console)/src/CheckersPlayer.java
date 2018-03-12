public class CheckersPlayer extends Player{

	public CheckersPlayer(int turn, String gamePiece){
		super(turn, gamePiece);
	}
	
	public void addGamePiece(Board gameBoard, int startRow, int startColumn, int endRow, int endColumn) {
		gameBoard.board[startRow][startColumn] = "[ ]";
		gameBoard.board[endRow][endColumn] = gamePiece;
		if (CheckersLogic.isValidJump(gameBoard.board, gamePiece, startRow, startColumn, endRow, endColumn)) {
			gameBoard.board[(startRow + endRow)/2][(startColumn+endColumn)/2] = "[ ]";
		}
	}
	
}
