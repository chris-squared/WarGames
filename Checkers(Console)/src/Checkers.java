import java.util.Scanner;
/**The Checkers Class runs a new instance of the Checkers Game.*/
public class Checkers {
	/**Runs a new instance of the Checkers Game.
	 * @param args not used*/
	public static void main(String[] args) {
		//Initialize game elements
		Scanner in = new Scanner(System.in);
		Board gameBoard = new Board();
		Player player1 = new Player(1, "[R]");
		Player player2 = new Player(2, "[B]");
		Utility.printMenu();
		int turn = 1;
		gameBoard.printBoard();
		// Turn determination and win conditions
		while (true){
				if (turn % player2.turn == 0){
					Turn.playerTurn(player2, gameBoard, turn, in);
//					if (Logic.playerWinChecker(gameBoard, gameBoard.board, player2.gamePiece, player2.turn))
//						break;
				}else{
					Turn.playerTurn(player1, gameBoard, turn, in);
//					if (Logic.playerWinChecker(gameBoard, gameBoard.board, player1.gamePiece, player1.turn))
//						break;
				}
			turn += 1;
			if (turn > 9){
				System.out.println("Game has ended with a tie!");
				break;
			}
		}
	}
}