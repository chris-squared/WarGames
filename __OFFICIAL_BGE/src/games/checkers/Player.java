package games.checkers;
abstract class Player {
	public String gamePiece;
	public String gamePiece2;
	public int turn;
	
	public Player(int turn, String gamePiece){
		this.turn = turn;
		this.gamePiece = gamePiece;
	}
	
	public Player(int turn, String gamePiece, String gamePiece2){
		this.turn = turn;
		this.gamePiece = gamePiece;
		this.gamePiece2 = gamePiece2;
	}
	
//	public abstract void addGamePiece(Board gameBoard,int column, int row);

//	public abstract void addGamePiece(String[][] board, int startRow, int startColumn, int endRow, int endColumn);
	public abstract void addGamePiece(Board gameBoard, int startRow, int startColumn, int endRow, int endColumn) ;

	public abstract void addGameKing(Board gameBoard, int startRow, int startCol, int endRow, int endCol) ;

	public abstract void kingMove(Board gameBoard, int startRow, int startCol, int endRow, int endCol);

	public abstract void kingMove2(Board gameBoard, int startRow, int startCol, int endRow, int endCol);

	public abstract void addGameKing2(Board gameBoard, int startRow, int startCol, int endRow, int endCol);
}
