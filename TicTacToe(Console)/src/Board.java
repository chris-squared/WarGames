//import java.util.HashMap;

public class Board {
	final static int rows = 3;
	final static int columns = 3;
	final static String gridPiece = "[ ]";
	public String[][] board = new String[rows][columns]; 
//	public HashMap<Integer,Integer> gameState = new HashMap<Integer,Integer>();
	
	public Board(){
		for (int row = 0; row < board.length; row++)
			for (int column = 0; column < board[row].length; column++)
				board[row][column] = gridPiece;
		initializeGameState();
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
	
	public void initializeGameState(){
		for (int column = 0; column < columns; column++)
			gameState.put(column, 5);
	}
	
	public static void printColumnNumbers(){
		System.out.print("  ");
		for (int i = 0; i < 3; i++)
			System.out.print(" " + i + " ");
	}
}