package games.simonsays;

public class SimonSaysBoard extends Board {

	public SimonSaysBoard(int rows, int columns, String gridPiece) {
		super(rows, columns, gridPiece);
		for (Color c: Color.values()) {
			int row = c.index[0];
			int column = c.index[1];
			board[row][column]	= "[" + c.code + "]";
		}
	}

}
