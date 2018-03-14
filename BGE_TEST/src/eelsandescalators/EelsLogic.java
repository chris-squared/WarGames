import BoardLogic.EelsAndEscalatorsBoard;

public class EelsLogic {
	
	EelsAndEscalatorsBoard board;
	EelsState state; 
	
	
	
	
	EelsLogic(EelsAndEscalatorsBoard g, EelsState s){
		board = g;
		state = s;
		
	}
	
	
	//Moves the player piece based on the roll
	void move (Player p, int roll) {
		//First, get the player's tile position 
		int player_tile = state.getPlayerLocation(p);
		//If the roll isn't going to push the player past the finish line...
		//NOTE: This is not just to avoid an out-of-bounds exception -- the rules of the game dictate that you must land exactly on the finish space
		if (!(player_tile + roll > 99))
			//...Move them x number of spaces. 
			state.setPlayerLocation(p, (player_tile + roll));
			
	}
	

	//Verifies if the player is the winner of the game 
	boolean is_winner(Player p, int position) {
		//If the player's location is at the last tile on the map (or somehow greater than that) they have won
		if (state.getPlayerLocation(p) >= 99) 
			return true;
		else
			//Otherwise, they haven't. 
			return false;
	}
	
	//Tells if you are on an Eel and where to move you. 
	void onEel(Player p) {
		int player_tile = state.getPlayerLocation(p);
		if (state.isEelPosition(player_tile)) {
			int result_tile = state.EscalatorsRepository.get(player_tile);
			System.out.println("ON ESCALATOR AT PLACE " + player_tile + ": MOVING TO NEW LOCATION AT TILE " + result_tile );}
		
	}
	
	//Tells you if you are on an Escalator and where to move you. 
	void onEscalator(Player p) {
		int player_tile = state.getPlayerLocation(p);
		if (state.isEscalatorPosition(player_tile)) {
			int result_tile = state.EscalatorsRepository.get(player_tile);
			System.out.println("ON ESCALATOR AT PLACE " + player_tile + ": MOVING TO NEW LOCATION AT TILE " + result_tile );
		}
		
	}
	


	
	

	

}
