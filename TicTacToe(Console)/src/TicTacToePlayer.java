public class TicTacToePlayer extends Player{
	
	public TicTacToePlayer(int turn, String gamePiece){
		super(turn, gamePiece);
	}
	
	@Override
	public void addGamePiece(Board gameBoard,int column, int row) {
		gameBoard.board[row][column] = gamePiece;
	}
}
