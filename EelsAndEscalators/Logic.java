


public class Logic {

	Board GameBoard;
	State s; 
	ConsoleGUI GUI;
	
	
	
	Logic(Board g, State state, ConsoleGUI c){
		GameBoard = g;
		s = state;
		GUI = c;
	}
	
	

	
	

	
	//Tells if you are on an Eel and where to move you. 
	void onEel(Player p) {
		for (int[] i: s.EelsRepository.keySet()) {
			int currentR = s.playerLocationRepo.get(p)[0];
			int currentC = s.playerLocationRepo.get(p)[1];
			if (currentR == i[0] && currentC == i[1]) {
				int[] newLocation = s.EelsRepository.get(i);
				s.setPlayerLocation(p, newLocation[0], newLocation[1]);
				s.update(GUI);
			}
			
			
		}
	}
	
	//Tells you if you are on an Escalator and where to move you. 
	void onEscalator(Player p) {
		for (int[] i: s.EscalatorsRepository.keySet()) {
			int currentR = s.playerLocationRepo.get(p)[0];
			int currentC = s.playerLocationRepo.get(p)[1];
			if (currentR == i[0] && currentC == i[1]) {
				int[] newLocation = s.EscalatorsRepository.get(i);
				s.setPlayerLocation(p, newLocation[0], newLocation[1]);
				s.update(GUI);
			}
			
			
		}
		
		
	}
	
	//Checks to see if you've won
	//TODO: Accurately write win-condition
	boolean wonGame(int pos) {
		return (pos == 0);
	}
	
	
	//Takes the dice roll and uses it to find the new position on the board, updating the state as it does. 
	void calculateNewPosition(Player p, int roll) {
		
		
		int[] location = s.getPlayerLocation(p);
		//FIRST CASE: ROW IS ODD: MOVE L->R
		if (location[0] % 2 != 0) {
				//Check we don't need to go down a row
			if (roll < 0 && location[1] == 0 && location[0] < GameBoard.rows -1)
				s.setPlayerLocation(p, location[0]+roll, location[1]);
			
			//If we're at the edge of the row (I.E., our next move moves us up
			if (location[1] == GameBoard.cols-1 && roll > 0) {
				s.setPlayerLocation(p, location[0]-roll, location[1]);
			}
			
			//Otherwise, make sure if we go back one space, we're not going to crash
			else 
				if(location[1] != 0 || roll > 0) {
					s.setPlayerLocation(p, location[0], location[1]+roll);}
			}
		
		//SECOND CASE: ROW IS EVEN: MOVE R->L
		else {
			//Likewise again, make sure we don't need to go down a row
			if (roll < 0 && location[1] == GameBoard.cols - 1 && location[0] < GameBoard.rows -1)
				s.setPlayerLocation(p, location[0]-roll, location[0]);
			
			//If we're at an edge, go up
			if(location[1] == 0 && roll > 0) {
				s.setPlayerLocation(p, location[1]+roll, location[0]);
			}
			
			else
				s.setPlayerLocation(p, location[0], location[1]-roll);	
		}
		s.update(GUI);
	}
	
	
	
		
	}
	
	//Used when we move backwards from an edge. 
	
	

	
	
	

