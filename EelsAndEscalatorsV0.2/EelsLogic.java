import BoardLogic.EelsAndEscalatorsBoard;

public class EelsLogic {
	
	EelsAndEscalatorsBoard board;
	EelsState state; 
	
	
	
	
	EelsLogic(EelsAndEscalatorsBoard g, EelsState s){
		board = g;
		state = s;
		
	}
	
	

	
	

	
	//Tells if you are on an Eel and where to move you. 
	void onEel(Player p) {
		
	}
	
	//Tells you if you are on an Escalator and where to move you. 
	void onEscalator(Player p) {
		int player_tile = state.getPlayerLocation(p);
		if (state.isEscalatorRepository(player_tile)) {
			int result_tile = state.EscalatorsRepository.get(player_tile);
			System.out.println("ON ESCALATOR AT PLACE " + player_tile + ": MOVING TO NEW LOCATION AT TILE " + result_tile );
		}
		
	}
	


	
	

	

}
