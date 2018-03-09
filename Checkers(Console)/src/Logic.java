public class Logic {

	
	public static boolean playerWinChecker(Board gameBoard, String[][] board, String gamePiece, int turn){
		System.out.println("Player " + turn + " Wins!");
		return true;
	}
	
	public static boolean isValidMove(String[][] board, String gamePiece, int startRow, int startColumn, int endRow, int endColumn) {
		if(isInsideBoard(startRow, startColumn, endRow, endColumn)
				&& isBlankSpace(board, endRow, endColumn)
				&& (isOneSpaceAway(board, startRow, startColumn, endRow, endColumn) 
						|| isValidJump(board, gamePiece, startRow, startColumn, endRow, endColumn)
						))
			return true;
		return false;
	}
	
	//Check if the input rows and columns you want to move to, and move from, are within the board.
	public static boolean isInsideBoard(int startRow, int startColumn, int endRow, int endColumn) {
		return (startRow < Board.rows && startColumn < Board.columns 
				&& endRow < Board.rows && endColumn < Board.columns );
	}
	
	//Check if the input row and column you want to move to is blank.
	public static boolean isBlankSpace(String[][] board, int endRow, int endColumn) {
		return (board[endRow][endColumn] == Board.gridPiece);
	}
	
	//Checks for a simple move. If the input row and columns are one space away from each other.
	public static boolean isOneSpaceAway(String[][] board, int startRow, int startColumn, int endRow, int endColumn) {
		if (Math.abs(endRow - startRow) == 1)
			if (Math.abs(endColumn - startColumn) == 1)
				return true;
		return false;
	}
	
	//Checks for a jump. If the input row and columns are two spaces away from each other.
	public static boolean isValidJump(String[][] board, String gamePiece, int startRow, int startColumn, int endRow, int endColumn) {
		if (Math.abs(endRow - startRow) == 2)
			if (Math.abs(endColumn - startColumn) == 2)
				if (board[(startRow + endRow)/2][(startColumn+endColumn)/2] != gamePiece)
					return true;
		return false;
	}
}