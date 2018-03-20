package games.eelsandescalators;

import utility.State;
import java.util.HashMap;

import bge.Player;
import bge.Tile;

public class EelsState extends State {
	//Keep track of the order of pieces for the board -- very important for Eels and Escalators, because you don't move linearly through it
		HashMap<Integer, Tile> BoardPathRepository = new HashMap<Integer, Tile>();
		
		//Keep track of players and their locations
		HashMap<Player, Integer>playerLocationRepo = new HashMap<Player, Integer>();
		
		//Keep track of where Eels are/where they lead
		public HashMap<Integer, Integer>EelsRepository = new HashMap<Integer, Integer>();
		
		//Keep track of where Escalators are/where they lead
		public HashMap<Integer, Integer>EscalatorsRepository = new HashMap<Integer, Integer>();
		EelsAndEscalatorsBoard board; 
		
		
		//Construct a new state with the board
		public EelsState(EelsAndEscalatorsBoard b, Player P1, Player P2) {
			super(b);
			board = b;
			GenerateBoardPath();
			PopulateBoard(P1, P2);
		}
		
		void PopulateBoard(Player P1, Player P2) {
			playerLocationRepo.put(P1, 1);
			playerLocationRepo.put(P2, 1);
			addEel(3, 1);
			addEscalator(5, 10);
			addEel(8, 2);
			addEscalator(20, 24);
			addEel(33, 27);
			addEel(99, 85);
		}
		
		//Generates the path of the board and assigns each tile to a number -- this makes rolls easier to add to the system
		void GenerateBoardPath() {
			System.out.println("ENTERING LOOP");
			int rows = board.getRowsNum();
			int columns = board.getColsNum();
			int space_number = 1; 
			
			
			for (int i = rows - 1; i >= 0; i--) 
				//If the row is an odd-number, move L-R
				if (i % 2 != 0) {
					System.out.println("ROW IS ODD");
					for (int j = 0; j < columns; j++) 
						BoardPathRepository.put(space_number++, board.getTile(i, j));}
				else {
					System.out.println("ROW IS EVEN: " + i);
					for (int j = columns-1; j >=0; j--) 
						BoardPathRepository.put(space_number++, board.getTile(i, j));	}
				
				
			
		}
		
		//Check if a piece is an Eel
		boolean isEelPosition(int bp) {
			return EelsRepository.containsKey(bp);
		}
		
		public void print_Test() {
			System.out.println("HAH WHAT");
		}
		
		//Check if a piece is an Escalator
		boolean isEscalatorPosition(int bp) {
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

		@Override
		public EelsAndEscalatorsBoard getGameBoard() {
			return board;
		}
		
		//Return where the players location is on the board
		int getPlayerLocation(Player p) {
			return playerLocationRepo.get(p);
		}
		
		//Set players new location
		void setPlayerLocation(Player p, int bp) {
			playerLocationRepo.put(p, bp);
		}
		
		
}