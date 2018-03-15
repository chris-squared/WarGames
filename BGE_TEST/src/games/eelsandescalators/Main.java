package games.eelsandescalators;

import games.EelsAndEscalatorsBoard;

public class Main {
	public static void main(String [] args) {
		EelsAndEscalatorsBoard board = new EelsAndEscalatorsBoard();
		EelsState testState = new EelsState(board);
		
		for (int i : testState.BoardPathRepository.keySet()) {
			System.out.println(i + " : " + testState.BoardPathRepository.get(i).getBoardCoord().getRow() + ", " +testState.BoardPathRepository.get(i).getBoardCoord().getCol() );
		}
		
	
		
	}
}
