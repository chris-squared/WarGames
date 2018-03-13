import java.util.HashMap;

public class EelsState {
	
	
	
	//Keep track of the order of pieces for the board -- very important for Eels and Escalators, because you don't move linearly through it
	HashMap<int, Tile> BoardPathRepository = new HashMap<int, Tile>();
	
	//Keep track of players and their locations
	HashMap<Player, Tile>playerLocationRepo = new HashMap<Player, Tile>();
	
	//Keep track of where Eels are/where they lead
	HashMap<Tile, Tile>EelsRepository = new HashMap<Tile, Tile>();
	
	//Keep track of where Escalators are/where they lead
	HashMap<Tile, Tile>EscalatorsRepository = new HashMap<Tile, Tile>();
	Board board; 
	
	
	//Construct a new state with the board
	State(Board b) {
		board = board;
	}
	
	//Check if a piece is an Eel
	BoardPiece isEelPosition(Tile bp) {
		return EelsRepository.contains(bp);
	}
	
	//Check if a piece is an Escalator
	BoardPiece isEscalatorRepository(Tile bp) {
		return EscalatorsRepository.contains(bp);
	}
	
	
	//Add an Eel to the repository
	void addEel(Tile t_start, Tile t_end) {
		EelsRepository.put(t_start, t_end);
	}
	
	//Add an Escalator to the board
	void addEscalator(Tile t_start, Tile t_end) {
		EscalatorsRepository.put(t_start, t_end);
	}
	
	//Return where the players location is on the board
	Tile getPlayerLocation(Player p) {
		return playerLocationRepo.get(p);
	}
	
	//Set players new location
	void setPlayerLocation(Player p, Tile bp) {
		playerLocationRepo.get(p) = bp;
	}
	
	
	

		
	
	

}
