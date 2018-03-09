public class Board {
	final static int rows = 8;
	final static int columns = 8;
	final static String gridPiece = "[ ]";
	public String[][] board = new String[rows][columns]; 

	public Board(){
		for (int row = 0; row < board.length; row++)
			for (int column = 0; column < board[row].length; column++) 
				board[row][column] = gridPiece;
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
	
	public void printBoard(){
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
	
	public static void printColumnNumbers(){
		System.out.print("  ");
		for (int i = 0; i < columns; i++)
			System.out.print(" " + i + " ");
	}
}