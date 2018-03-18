package games.checkers;

public class CheckersTurn extends Turn{
	public CheckersState state;
	public CheckersLogic logic;
	public CheckersPlayer player1 = new CheckersPlayer(1, "[R]", "[K]");
	public CheckersPlayer player2 = new CheckersPlayer(2, "[B]", "[Q]");

	int turnStartRow = -1;
	int turnStartCol = -1;
	
	public CheckersTurn(CheckersState state, CheckersLogic logic) {
		super(state, logic);
		this.state = state;
		this.logic = logic;
	}
	@Override
	public void executeMove(Player player, Board gameBoard, int turn, int startRow, int startCol, int endRow, int endCol) {
		System.out.println("Player " + player.turn + " turn. Current turn: " + turn + " Color: " + player.gamePiece);
		if (logic.isValidMove(player.gamePiece, gameBoard.board[startRow][startCol], startRow, startCol, endRow, endCol)) {
			if (gameBoard.board[startRow][startCol] == "[K]")
				player.kingMove(gameBoard, startRow, startCol, endRow, endCol);
			else if (gameBoard.board[startRow][startCol] == "[Q]")
				player.kingMove2(gameBoard, startRow, startCol, endRow, endCol);
			else if (player.gamePiece == "[B]" && endRow == 0)
				player.addGameKing2(gameBoard, startRow, startCol, endRow, endCol);
			else if (player.gamePiece == "[R]" && endRow == (gameBoard.columns - 1))
				player.addGameKing(gameBoard, startRow, startCol, endRow, endCol);
			else
				player.addGamePiece(gameBoard, startRow, startCol, endRow, endCol);
		}
		else
			System.out.println("Invalid Move.");
		gameBoard.printBoard();
		}
	
	@Override
	public boolean nextPlayersTurn(int currentTurn, int startRow, int startCol, int endRow, int endCol) {
		if (currentTurn % player2.turn == 0){
			executeMove(player2, state.gameBoard, currentTurn, startRow, startCol, endRow, endCol);
			if (logic.checkWinCondition(player2.gamePiece)) {
				System.out.println("player 2 wins!");
				return false;
			}
		}else{
			executeMove(player1, state.gameBoard, currentTurn, startRow, startCol, endRow, endCol);
			if (logic.checkWinCondition(player1.gamePiece)) {
				System.out.println("player 1 wins!");
				return false;
			}
		}
		return true;
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
