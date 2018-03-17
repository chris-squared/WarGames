package games.checkers;

public class CheckersTurn extends Turn{
	public CheckersState state;
	public CheckersLogic logic;
	CheckersPlayer player1 = new CheckersPlayer(1, "[R]");
	CheckersPlayer player2 = new CheckersPlayer(2, "[B]");

	int turnStartRow = -1;
	int turnStartCol = -1;
	
	public CheckersTurn(CheckersState state, CheckersLogic logic) {
		super(state, logic);
		this.state = state;
		this.logic = logic;
	}
	@Override
	public void executeMove(Player player, Board gameBoard, int turn, int startRow, int startCol, int endRow, int endCol) {
		boolean validMove = true;
		while(validMove) {
			System.out.println("Player " + player.turn + " turn. Current turn: " + turn + " Color: " + player.gamePiece);
			if (logic.isValidMove(player.gamePiece, startRow, startCol, endRow, endCol)) {
				player.addGamePiece(gameBoard, startRow, startCol, endRow, endCol);
				validMove = false;
			}
			else
				System.out.println("Invalid Move.");
			gameBoard.printBoard();
		}
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
