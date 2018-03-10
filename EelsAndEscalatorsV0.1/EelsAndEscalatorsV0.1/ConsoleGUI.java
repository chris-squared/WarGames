
public class ConsoleGUI {
	Board gameBoard;
	
	ConsoleGUI(Board b){
		gameBoard = b; 
	}
	
	void printBoard() {
		 for (int row = 0; row < gameBoard.board.length; row++) {
			 System.out.print(row + " ");
			 for (int column = 0; column < gameBoard.board[row].length; column++)
				 System.out.print(gameBoard.board[row][column]);
			 System.out.println("");
		 }
		 System.out.print ("  ");
		 for (int i = 0; i < gameBoard.cols; i ++) {
			 System.out.print (" "+ i + " ");
		
		 }
		 System.out.print("\n\n");
	 }
	
	

}
