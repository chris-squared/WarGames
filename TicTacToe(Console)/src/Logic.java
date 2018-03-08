public class Logic {
	
	public static boolean rowChecker(String[][] board, String gamePiece){
		int counter = 0;
		boolean winner = false;
		for (int row = 0; row < board.length; row++){
			for (int column = 0; column < board[row].length; column++){
				if (board[row][column] == gamePiece){
					counter++;
					if (counter >= 3)
						winner = true;
					}
				else
					counter = 0;
			}
			counter = 0;
		}
		return winner;
	}
	
	public static boolean columnChecker(String[][] board, String gamePiece){
		int counter = 0;
		boolean winner = false;
		for (int column = 0; column < Board.columns; column++){
			for (int row = 0; row < Board.rows; row++){
				if (board[row][column] == gamePiece){
					counter++;
					if (counter >= 3)
						winner = true;
				}
				else
					counter = 0;
			}
			counter = 0;
		}
		return winner;
	}
	
	public static boolean diagonalChecker(String[][] board, String gamePiece){
		// Forward Diagonal Checker
		int counter = 0;
		boolean winner = false;
		for (int row = 0; row < 1; row++){
			for (int column = 0; column < 1; column++){
				if (board[row][column] == gamePiece){
					counter++;
					for (int i = 1; i < 3; i++){
						if (board[row+i][column+i] == gamePiece){
							counter++;
							if (counter >= 3)
								winner = true;
						}
						else
							counter = 0;
					}
					counter = 0;
				}
			}
		}
		return winner;
	}
	
	public static boolean diagonalChecker2(String[][] board, String gamePiece){
		// Backward Diagonal
		int counter = 0;
		boolean winner = false;
		for (int row = 2; row < 3; row++){
			for (int column = 0; column < 1; column++){
				if (board[row][column] == gamePiece){
					counter++;
					for (int i = 1; i < 3; i++){
						if (board[row-i][column+i] == gamePiece){
							counter++;
							if (counter >= 3)
								winner = true;
						}
						else
							counter = 0;
					}
					counter = 0;
				}
			}
		}
		return winner;
	}
	
	public static boolean playerWinChecker(Board gameBoard, String[][] board, String gamePiece, int turn){
		if (rowChecker(board, gamePiece) 
				|| columnChecker(board, gamePiece) 
				|| diagonalChecker(board, gamePiece)
				|| diagonalChecker2(board, gamePiece)
				){
			System.out.println("Player " + turn + " Wins!");
			return true;
		}
		return false;
	}
}
