package games.eelsandescalators;

import utility.State;
import java.util.HashMap;

import bge.Player;
import bge.Tile;
import games.EelsAndEscalatorsBoard;
import javafx.scene.paint.Color;

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
			super();
			setBoard(b);
			board = b;
			GenerateBoardPath();
			PopulateBoard(P1, P2);
			setColors();
		}
		
		void PopulateBoard(Player P1, Player P2) {
			playerLocationRepo.put(P1, 1);
			playerLocationRepo.put(P2, 1);
			
			//Rule of Thumb: One escalator/Eel per row
			
			//First Row:
			addEel(5, 2);
			addEscalator(7, 11);
			
			//Second row
			addEel(13, 8);
			addEscalator(16, 22);
			
			//ThirdRow
			addEel(26, 20);
			addEscalator(29, 34);
			
			//Fourth Row
			addEel(30, 23);
			addEscalator(38, 47);
			
			//Fifth Row
			addEel(45, 39);
			addEscalator(46, 59);
			
			//Sixth Row
			addEel(50, 40);
			addEscalator(55, 60);
			
			//Seventh Row
			addEel(64, 53);
			addEscalator(67, 72);
			
			//Eighth Row
			addEel(71, 64);
			addEel(76, 60);
			
			//Ninth Row
			addEscalator(81, 85);
			addEel(84, 78);
		
			//Final Row
			addEel(99, 82);
			
			
		}
		
		void setColors() {
			for (int i : EelsRepository.keySet()) {
				int startR = BoardPathRepository.get(i).getBoardCoord().getRow();
				int startC = BoardPathRepository.get(i).getBoardCoord().getCol();
				
				int endR = BoardPathRepository.get(EelsRepository.get(i)).getBoardCoord().getRow();
				int endC = BoardPathRepository.get(EelsRepository.get(i)).getBoardCoord().getCol();
				
				board.getTile(startR, startC).setColor(Color.GREENYELLOW);
				board.getTile(endR,  endC).setColor(Color.GREENYELLOW);
			}
			
			for (int j : EscalatorsRepository.keySet()) {
				int startR = BoardPathRepository.get(j).getBoardCoord().getRow();
				int startC = BoardPathRepository.get(j).getBoardCoord().getCol();
				
				int endR = BoardPathRepository.get(EscalatorsRepository.get(j)).getBoardCoord().getRow();
				int endC = BoardPathRepository.get(EscalatorsRepository.get(j)).getBoardCoord().getCol();
				
				board.getTile(startR, startC).setColor(Color.BURLYWOOD);
				board.getTile(endR,  endC).setColor(Color.BURLYWOOD);
			}
		}
		
		//Generates the path of the board and assigns each tile to a number -- this makes rolls easier to add to the system
		void GenerateBoardPath() {
			
			int rows = board.getRowsNum();
			int columns = board.getColsNum();
			int space_number = 1; 
			
			
			for (int i = rows - 1; i >= 0; i--) 
				//If the row is an odd-number, move L-R
				if (i % 2 != 0) {
					for (int j = 0; j < columns; j++) 
						BoardPathRepository.put(space_number++, board.getTile(i, j));}
				else {
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