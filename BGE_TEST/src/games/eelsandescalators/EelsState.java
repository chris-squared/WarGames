package games.eelsandescalators;

import java.util.HashMap;

import bge.Tile;
import boardgamerepo.EelsAndEscalatorsBoard;

public class EelsState {
	//Keep track of the order of pieces for the board -- very important for Eels and Escalators, because you don't move linearly through it
		HashMap<Integer, Tile> BoardPathRepository = new HashMap<Integer, Tile>();
		
		//Keep track of players and their locations
		//HashMap<Player, Tile>playerLocationRepo = new HashMap<Player, Tile>();
		
		//Keep track of where Eels are/where they lead
		public HashMap<Integer, Integer>EelsRepository = new HashMap<Integer, Integer>();
		
		//Keep track of where Escalators are/where they lead
		public HashMap<Integer, Integer>EscalatorsRepository = new HashMap<Integer, Integer>();
		EelsAndEscalatorsBoard board; 
		
		
		//Construct a new state with the board
		EelsState(EelsAndEscalatorsBoard b) {
			board = b;
			GenerateBoardPath();
		}
		
		//Generates the path of the board and assigns each tile to a number -- this makes rolls easier to add to the system
		void GenerateBoardPath() {
			int rows = board.getRowsNum();
			int columns = board.getColsNum();
			int space_number = 1; 
			
			
			for (int i = rows - 1; i >= 0; i--) 
				//If the row is an odd-number, move L-R
				if (rows % 2 == 0) 
					for (int j = 0; j < columns; j++) 
						BoardPathRepository.put(space_number++, board.getTile(i, j));
				else 
					for (int j = columns-1; j >=0; j--) 
						BoardPathRepository.put(space_number++, board.getTile(i, j));	
		}
		
		//Check if a piece is an Eel
		boolean isEelPosition(int bp) {
			return EelsRepository.containsKey(bp);
		}
		
		//Check if a piece is an Escalator
		boolean isEscalatorRepository(int bp) {
			return EscalatorsRepository.containsKey(bp);
		}
		
		
		//Add an Eel to the repository
		void addEel(int t_start, int t_end) {
			EelsRepository.put(t_start, t_end);
		}
		
		//Add an Escalator to the board
		void addEscalator(int t_start, int t_end) {
			EscalatorsRepository.put(t_start, t_end);
		}
		
		//Return where the players location is on the board
		/*Integer getPlayerLocation(Player p) {
			return playerLocationRepo.get(p);
		}*/
		
		//Set players new location
		/*void setPlayerLocation(Player p, Integer bp) {
			playerLocationRepo.put(p, bp);
		}*/
		
		
}