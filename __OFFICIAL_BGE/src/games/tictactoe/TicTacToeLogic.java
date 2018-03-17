package games.tictactoe;

public class TicTacToeLogic extends Logic {
	
	TicTacToeState state;
	public TicTacToeLogic(TicTacToeState state) {
		super(state);
		this.state = state;
	}
	
	@Override
	public boolean checkWinCondition(String gamePiece) {
		if (rowChecker(state.gameBoard.board, gamePiece)
				|| columnChecker(state.gameBoard.board, gamePiece) 
				|| diagonalChecker(state.gameBoard.board, gamePiece)
				|| diagonalChecker2(state.gameBoard.board, gamePiece)
				)
			return true;
		return false;
	}
	
	public boolean isValidMove(int row, int column) {
		if (state.gameBoard.board[row][column] == state.gameBoard.gridPiece) {
			return true;
		} 
		System.out.println("Invalid Move.");
		return false;
	}
	
	/**Auxiliary function for checking the win conditions.*/
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
	
	/**Auxiliary function for checking the win conditions.*/
	public static boolean columnChecker(String[][] board, String gamePiece){
		int counter = 0;
		boolean winner = false;
		for (int column = 0; column < board.length; column++){
			for (int row = 0; row < board.length; row++){
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
	
	/**Auxiliary function for checking the win conditions.*/
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
	
	/**Auxiliary function for checking the win conditions.*/
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
}
