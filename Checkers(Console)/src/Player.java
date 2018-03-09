public class Player {
	
	public String gamePiece;
	public final int turn;
	public Player(int turn, String gamePiece){
		this.turn = turn;
		this.gamePiece = gamePiece;
	}
	
	public void executeMove(String[][] board, int startRow, int startColumn, int endRow, int endColumn) {
		board[startRow][startColumn] = Board.gridPiece;
		board[endRow][endColumn] = gamePiece;
		if (Logic.isValidJump(board, gamePiece, startRow, startColumn, endRow, endColumn)) {
			board[(startRow + endRow)/2][(startColumn+endColumn)/2] = Board.gridPiece;
		}
		
	}
	
}
