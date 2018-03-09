import java.util.HashMap;

public class State {
	int currentnum = 0;
	//Keep track of players
	Player[] PlayerRepo = new Player[2];
	
	//Keep track of player locations
	HashMap<Player, int[]>playerLocationRepo = new HashMap<Player, int[]>();
	
	//Keep track of where Eels are/where they lead
	HashMap<int[], int[]>EelsRepository = new HashMap<int[], int[]>();
	
	//Keep track of where Escalators are/where they lead
	HashMap<int[], int[]>EscalatorsRepository = new HashMap<int[], int[]>();
	Board b; 
	
	
	State(Board board) {
		b = board;
	}
	
	void addPlayer (Player p){
		PlayerRepo[currentnum++] = p;
	}
	
	void addEel(int[] start, int[] end) {
		EelsRepository.put(start, end);
	}
	
	//Add an Escalator to the board
	void addEscalator(int[] start, int[] end) {
		EscalatorsRepository.put(start, end);
	}
	
	int[] getPlayerLocation(Player p) {
		return playerLocationRepo.get(p);
	}
	
	
	void setPlayerLocation(Player p, int r, int c) {
		System.out.println("PLACING AT : " + r + "," + c);
		if (playerLocationRepo.get(p) != null) {
			int row = playerLocationRepo.get(p)[0];
			int col = playerLocationRepo.get(p)[1];
			b.board[row][col] = "[ ]";
			playerLocationRepo.get(p)[0] = r;
			playerLocationRepo.get(p)[1] = c;
		}
		else
			playerLocationRepo.put(p, new int[] {r, c});
	}
	
	void update(ConsoleGUI g) {
		for (Player p: playerLocationRepo.keySet() ){
			int row = playerLocationRepo.get(p)[0];
			int col = playerLocationRepo.get(p)[1];
			b.board[row][col] = p.name;
		}
		g.printBoard();
	}
	

		
	
	

}
