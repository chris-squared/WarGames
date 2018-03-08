public class Player {
	
	public String gamePiece;
	public final int turn;
	public Player(int turn, String gamePiece){
		this.turn = turn;
		this.gamePiece = gamePiece;
	}
	
	public void addGamePiece(Board gameBoard,int column, int row) {
		gameBoard.board[row][column] = gamePiece;
	}
	
}
