package games.eelsandescalators;

import bge.Board;
import games.EelsAndEscalatorsBoard;

public class EelsEngine {
	EelsAndEscalatorsBoard board;
	EelsState state;
	EelsLogic logic;
	
	public EelsEngine(EelsAndEscalatorsBoard b, EelsState s, EelsLogic l){
		board = b;
		state = s;
		logic = l; 
		setPlayer();
		printConsoleBoard();
		printBoardPath(); 
	}

	public void printBoardPath() {
		for (int i : state.BoardPathRepository.keySet())
			System.out.println("SPACE NUM: " + i + " COORD: " + state.BoardPathRepository.get(i).getBoardCoord().getRow() + "," + state.BoardPathRepository.get(i).getBoardCoord().getCol() );
	}
	
	public void setPlayer() {
		board.setStartingPieces();
	}
	public void printConsoleBoard() {
		System.out.println("INITIALIZING BOARD...");
		for (int i = 0; i < board.getRowsNum(); i++) {
			for (int j = 0; j < board.getColsNum(); j++)
				if (board.getPieceP1(i, j) != null)
					System.out.print("[X]");
				else
					System.out.print("[ ]");
			System.out.println("");}
	}
	
	

}
