package games.checkers;
import bge.BoardCoord;
import bge.GameOverException;
import bge.Logic;
import bge.Piece;
import bge.Player;
public class CheckersLogic extends Logic {

	public CheckersState state;
	public CheckersLogic(CheckersState state) {
		this.state = state;
		has_move_function = 0;
	}

	public boolean checkWinCondition(int black, int red){
		if (black == 0 || red == 0)
			return true;
		System.out.println("No Winner Yet.");
		return false;
	}
	
	public boolean isValidMove(String gamePiece, String gamePiece2, int startRow, int startColumn, int endRow, int endColumn) {
//		System.out.println("Inside Board: " + isInsideBoard(startRow, startColumn, endRow, endColumn));
//		System.out.println("Blank Space : " + isBlankSpace(state.gameBoard.board, endRow, endColumn));
//		System.out.println("One Space Away: "+isOneSpaceAway(state.gameBoard.board, startRow, startColumn, endRow, endColumn)); 
		if (gamePiece == "[R]" || gamePiece2 == "[K]") {
			if (gamePiece2 == "[K]") {
				if(isInsideBoard(startRow, startColumn, endRow, endColumn)
						&& (state.gameBoard.board[startRow][startColumn] == gamePiece2)
						&& isBlankSpace(state.gameBoard.board, endRow, endColumn)
						&& (isOneSpaceAway(state.gameBoard.board, startRow, startColumn, endRow, endColumn) 
								|| isValidJump(state.gameBoard.board, gamePiece, startRow, startColumn, endRow, endColumn)
								))
					return true;
			}
			else if (gamePiece == "[R]") {
				if(isInsideBoard(startRow, startColumn, endRow, endColumn)
				&& (gamePiece == state.gameBoard.board[startRow][startColumn])
				&& isBlankSpace(state.gameBoard.board, endRow, endColumn)
				&& (isOneSpaceAwayRed(state.gameBoard.board, startRow, startColumn, endRow, endColumn) 
						|| isValidJump(state.gameBoard.board, gamePiece, startRow, startColumn, endRow, endColumn)
						))
			return true;
			}
		}
		else if (gamePiece == "[B]" || gamePiece2 == "[K]") {
			if (gamePiece2 == "[Q]") {
				if(isInsideBoard(startRow, startColumn, endRow, endColumn)
						&& (state.gameBoard.board[startRow][startColumn] == gamePiece2)
						&& isBlankSpace(state.gameBoard.board, endRow, endColumn)
						&& (isOneSpaceAway(state.gameBoard.board, startRow, startColumn, endRow, endColumn) 
								|| isValidJump(state.gameBoard.board, gamePiece, startRow, startColumn, endRow, endColumn)
								))
					return true;
			}
			else if (gamePiece == "[B]") {
				if(isInsideBoard(startRow, startColumn, endRow, endColumn)
					&& (gamePiece == state.gameBoard.board[startRow][startColumn])
					&& isBlankSpace(state.gameBoard.board, endRow, endColumn)
					&& (isOneSpaceAwayBlack(state.gameBoard.board, startRow, startColumn, endRow, endColumn) 
							|| isValidJump(state.gameBoard.board, gamePiece, startRow, startColumn, endRow, endColumn)
							))
				return true;
			}
		}
		return false;
	}
	
	//Check if the input rows and columns you want to move to, and move from, are within the board.
	public boolean isInsideBoard(int startRow, int startColumn, int endRow, int endColumn) {
		return (startRow < state.gameBoard.board.length && startColumn < state.gameBoard.board.length
				&& endRow < state.gameBoard.board.length && endColumn < state.gameBoard.board.length
				&& startRow >= 0 && startColumn >= 0  
				&& endRow >= 0 && endColumn >= 0);
	}
	
	//Check if the input row and column you want to move to is blank.
	public boolean isBlankSpace(String[][] board, int endRow, int endColumn) {
		return (board[endRow][endColumn] == state.gameBoard.gridPiece);
	}
	
	//Checks for a simple move. If the input row and columns are one space away from each other.
	public static boolean isOneSpaceAway(String[][] board, int startRow, int startColumn, int endRow, int endColumn) {
		if (Math.abs(endRow - startRow) == 1)
			if (Math.abs(endColumn - startColumn) == 1)
				return true;
		return false;
	}
	
	//Checks for a simple move. If the input row and columns are one space away from each other.
	public static boolean isOneSpaceAwayRed(String[][] board, int startRow, int startColumn, int endRow, int endColumn) {
		if ((endRow - startRow) == 1)
			if (Math.abs(endColumn - startColumn) == 1)
				return true;
		return false;
	}
	
	//Checks for a simple move. If the input row and columns are one space away from each other.
	public static boolean isOneSpaceAwayBlack(String[][] board, int startRow, int startColumn, int endRow, int endColumn) {
		if ((endRow - startRow) == -1)
			if (Math.abs(endColumn - startColumn) == 1)
				return true;
		return false;
	}
	
	//Checks for a jump. If the input row and columns are two spaces away from each other.
	public static boolean isValidJump(String[][] board, String gamePiece, int startRow, int startColumn, int endRow, int endColumn) {
		if (Math.abs(endRow - startRow) == 2)
			if (Math.abs(endColumn - startColumn) == 2)
				if (board[(startRow + endRow)/2][(startColumn+endColumn)/2] != gamePiece)
					return true;
		return false;
	}

	@Override
	public boolean check_win_condition(Piece p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void executeMove(Player p, BoardCoord bc) throws GameOverException {
		// TODO Auto-generated method stub
		
	}
}