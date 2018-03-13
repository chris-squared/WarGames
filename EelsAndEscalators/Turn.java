
public class Turn {
	DiceRoller roller; 
	State s;
	Logic l;
	Board b; 
	
	
	Turn(State st, Logic lo, Board bo){
		s = st;
		l = lo;
		b = bo;
		roller = new DiceRoller(); 
	}
	
	void makeTurn(Player p, int test){
		int roll = roller.rollDice(test);
		System.out.println("YOU ROLLED A : " + roll);
		l.calculateNewPosition(p, roll);
		spaceCheck(p);
	}
	
	void spaceCheck(Player p) {
		int[] location = s.getPlayerLocation(p);
		System.out.println(s.playerLocationRepo.get(p)[1]);
		System.out.println("LOCATION IS " + location[0] + ", " + location[1]);
		l.onEel(p);
		l.onEscalator(p);
	
}
}
