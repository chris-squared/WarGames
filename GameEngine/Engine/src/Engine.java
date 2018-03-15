
public class Engine {

	public Logic logic;
	public State state;
	public Player player1;
	public Player player2;
	public int currentTurn = 1; /*Currently, the only working way of tracking turns is through a turn counter which is then checked whether it is odd
								 *or even in Engine.nextPlayersTurn(). I've decided to move this currentTurn variable into engine from main.
	 							 */
	
	public Engine(State state, Logic logic, Player player1, Player player2) {//Engine now also takes in the two players.
		this.state = state;
		this.logic = logic;
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public void executeMove(Player player, Board gameBoard, Turn turn, int row, int col){
		boolean validMove=true;
		while(validMove){
			if(logic.isValidMove(row, col)){//Logic class will need isValidMove function of sorts.
				player.addGamePiece(gameBoard, col, row);//!!!
				/*There needs to be some method somewhere that will actually make the move. Right now, methods to move pieces vary between
				 * the games. Eels and Escalators has a move() method in EelsLogic.java but Tic-Tac-Toe/Checkers 
				 * as the addGamePiece() method in TicTacToePlayer. Simon Says has the getPlayerPattern() method in SimonSaysLogic.java.
				 * 
				 * If we want the engine to not be an abstract class, we're going to need to have to choose a final place to 
				 * store move() method or whatever equivalent there is.
				 */
				validMove = false;
			}
		}
		gameBoard.updateBoard();//Board classes will need an updateBoard() method of sorts.
	}
	
	public boolean nextPlayersTurn(Turn turn, int row, int col){// Currently, nextPlayersTurn takes in a Turn object that does nothing. Will likely change as Turn object functionality becomes more defined.
		if(currentTurn % player2.turn == 0){//If currentTurn is an even number, it is player 2's turn.
			executeMove(player2, state.gameBoard, currentTurn, row, col);//Call the executeMove function found above to make Player 2's move.
			if(logic.checkWinCondition(player2.gamePiece)){//The Logic class will need a checkWinCondition() method.
				return false;
			}
			currentTurn = currentTurn + 1;//increment currentTurn after Player whatever makes their turn.
		}
		else{
			executeMove(player1, state.gameBoard, currentTurn, row, col);
			if(logic.checkWinCondition(player1.gamePiece)){
				return false;
			}
			currentTurn = currentTurn + 1;
		}
		return true;
	}
}
