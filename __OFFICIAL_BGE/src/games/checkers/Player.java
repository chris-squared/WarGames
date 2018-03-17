package games.checkers;
abstract class Player {
	public String gamePiece;
	public int turn;
	
	public Player(int turn, String gamePiece){
		this.turn = turn;
		this.gamePiece = gamePiece;
	}
	
//	public abstract void addGamePiece(Board gameBoard,int column, int row);

//	public abstract void addGamePiece(String[][] board, int startRow, int startColumn, int endRow, int endColumn);
	public abstract void addGamePiece(Board gameBoard, int startRow, int startColumn, int endRow, int endColumn) ;
}
