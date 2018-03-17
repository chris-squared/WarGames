package games.checkers;
public class CheckersBoard extends Board { 

	public CheckersBoard(int rows, int columns, String gridPiece){
		super(8,8, "[ ]");
		for (int row = 0; row < board.length/2 -1; row++) {
			for (int column = 0; column < columns; column += 2) {
				if (row == 1) {
					board[row][column] = "[R]";
				}
				if (row == 0 || row == 2) {
					board[row][column+1] = "[R]";
				}
			}
		}
		for (int row = 5; row < board.length; row++) {
			for (int column = 0; column < columns; column += 2) {
				if (row == 5 || row == 7) {
					board[row][column] = "[B]";
				}
				if (row == 6) {
					board[row][column+1] = "[B]";
				}
			}
		}
	}
}