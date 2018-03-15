package games.tictactoe;
/**The base board class*/
abstract class Board {
	public int rows;
	public int columns;
	public String gridPiece;
	public String[][] board;
	
	/** Board class constructor. Takes in the dimensions of the board and a string
	 * is currently used as a grid piece. Will be changed to the GUI equivalent.*/
	public Board(int rows, int columns, String gridPiece) {
		this.gridPiece = gridPiece; 
		this.rows = rows;
		this.columns = columns;
		board = new String[rows][columns];
		for (int row = 0; row < board.length; row++)
			for (int column = 0; column < board[row].length; column++)
				board[row][column] = gridPiece;
	}
	
	/**printBoard is only necessary for the console version of games. Used for debugging
	 * purposes.*/
	public void printBoard()
	{
		for (int row = 0; row < board.length; row++){
			System.out.print(row + " ");
			for (int column = 0; column < board[row].length; column++)
				System.out.print(board[row][column]);
			System.out.println("");
		}
		printColumnNumbers();
		System.out.println(" ");
		System.out.println(" ");
	}
	
	/**print Column Numbers is an auxiliary function for printBoard and 
	 * should only be necessary for the console version of games.*/
	public void printColumnNumbers(){
		System.out.print("  ");
		for (int row = 0; row < board.length; row++)
			System.out.print(" " + row + " ");
	}
	
}
