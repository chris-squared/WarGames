public class Board {
	final static int rows = 3;
	final static int columns = 3;
	final static String gridPiece = "[ ]";
	public String[][] board = new String[rows][columns]; 
	
	public Board(){
		for (int row = 0; row < board.length; row++)
			for (int column = 0; column < board[row].length; column++)
				board[row][column] = gridPiece;
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
		for (int i = 0; i < 3; i++)
			System.out.print(" " + i + " ");
	}
}