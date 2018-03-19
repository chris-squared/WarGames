package games.checkers;

public class CheckersTurn{
	public CheckersState state;
	public CheckersLogic logic;
	public static int red = 12;
	public static int black = 12;
	public CheckersPlayer player1 = new CheckersPlayer(1, "[R]", "[K]");
	public CheckersPlayer player2 = new CheckersPlayer(2, "[B]", "[Q]");

	int turnStartRow = -1;
	int turnStartCol = -1;
	
	public CheckersTurn(CheckersState state, CheckersLogic logic) {
		this.state = state;
		this.logic = logic;
	}
	public void executeMove(CheckersPlayer player, Board gameBoard, int turn, int startRow, int startCol, int endRow, int endCol) {
		System.out.println("Player " + player.turn + " turn. Current turn: " + turn + " Color: " + player.gamePiece);
		if (logic.isValidMove(player.gamePiece, gameBoard.board[startRow][startCol], startRow, startCol, endRow, endCol)) {
			if (gameBoard.board[startRow][startCol] == "[K]")
				kingMove(gameBoard, player.gamePiece2, startRow, startCol, endRow, endCol);
			else if (gameBoard.board[startRow][startCol] == "[Q]")
				kingMove2(gameBoard, player.gamePiece, startRow, startCol, endRow, endCol);
			else if (player.gamePiece == "[B]" && endRow == 0)
				addGameKing2(gameBoard, startRow, startCol, endRow, endCol);
			else if (player.gamePiece == "[R]" && endRow == (gameBoard.columns - 1))
				addGameKing(gameBoard, startRow, startCol, endRow, endCol);
			else
				addGamePiece(gameBoard, player.gamePiece, startRow, startCol, endRow, endCol);
		}
		else
			System.out.println("Invalid Move.");
		gameBoard.printBoard();
		}
	
	public boolean nextPlayersTurn(int currentTurn, int startRow, int startCol, int endRow, int endCol) {
		if (currentTurn % player2.turn == 0){
			//System.out.println("///////////////// Player 2 turn");
			if(logic.isValidMove(player2.gamePiece, state.gameBoard.board[startRow][startCol], startRow, startCol, endRow, endCol)){
				executeMove(player2, state.gameBoard, currentTurn, startRow, startCol, endRow, endCol);
				return true;
			}
			if (logic.checkWinCondition(player2.gamePiece)) {
				System.out.println("player 2 wins!");
				return false;
			}
		}else{
			//System.out.println("//////////////////////// Player 1 turn");
			if(logic.isValidMove(player1.gamePiece, state.gameBoard.board[startRow][startCol], startRow, startCol, endRow, endCol)){
			executeMove(player1, state.gameBoard, currentTurn, startRow, startCol, endRow, endCol);
			return true;
			}
			if (logic.checkWinCondition(player1.gamePiece)) {
				System.out.println("player 1 wins!");
				return false;
			}
		}
		return false;
	}
	
	public void addGamePiece(Board gameBoard, String gamePiece, int startRow, int startColumn, int endRow, int endColumn) {
	gameBoard.board[startRow][startColumn] = "[ ]";
	gameBoard.board[endRow][endColumn] = gamePiece;
	if (CheckersLogic.isValidJump(gameBoard.board, gamePiece, startRow, startColumn, endRow, endColumn)) {
		executeJump(gameBoard,startRow, startColumn, endRow, endColumn);	
		}
	}
	
	public void executeJump(Board gameBoard, int startRow, int startColumn, int endRow, int endColumn) {
		if (gameBoard.board[(startRow + endRow)/2][(startColumn+endColumn)/2].equals("[R]"))
			CheckersTurn.red -= 1;
		else {
			CheckersTurn.black -= 1;
		}
		System.out.println("Red Remaining: " + CheckersPlayer.red + "Black Remaining: " + CheckersPlayer.black);
		gameBoard.board[(startRow + endRow)/2][(startColumn+endColumn)/2] = "[ ]";
	}
	
	public void addGameKing(Board gameBoard, int startRow, int startColumn, int endRow, int endColumn) {
		gameBoard.board[startRow][startColumn] = "[ ]";
		gameBoard.board[endRow][endColumn] = "[K]";
	}

	public void addGameKing2(Board gameBoard, int startRow, int startColumn, int endRow, int endColumn) {
		gameBoard.board[startRow][startColumn] = "[ ]";
		gameBoard.board[endRow][endColumn] = "[Q]";
	}
	
	public void kingMove(Board gameBoard, String gamePiece, int startRow, int startColumn, int endRow, int endColumn) {
		gameBoard.board[startRow][startColumn] = "[ ]";
		gameBoard.board[endRow][endColumn] = "[K]";
		if (CheckersLogic.isValidJump(gameBoard.board, gamePiece, startRow, startColumn, endRow, endColumn)) {
			executeJump(gameBoard,startRow, startColumn, endRow, endColumn);
		}
	}
	
	public void kingMove2(Board gameBoard, String gamePiece, int startRow, int startColumn, int endRow, int endColumn) {
		gameBoard.board[startRow][startColumn] = "[ ]";
		gameBoard.board[endRow][endColumn] = "[Q]";
		if (CheckersLogic.isValidJump(gameBoard.board, gamePiece, startRow, startColumn, endRow, endColumn)) {
			executeJump(gameBoard,startRow, startColumn, endRow, endColumn);
		}
	}
	
	public int getTurnStartRow() {
		return turnStartRow;
	}
	public void setTurnStartRow(int turnStartRow) {
		this.turnStartRow = turnStartRow;
	}
	public int getTurnStartCol() {
		return turnStartCol;
	}
	public void setTurnStartCol(int turnStartCol) {
		this.turnStartCol = turnStartCol;
	}
}
