package games.eelsandescalators;


//V0.1: Basic skeletal structure of a turn for Eels/Escalators

public class EelsTurn {
	
	//DiceRoller dice;
	EelsState state;
	EelsLogic logic;
	
	
	EelsTurn(EelsState s, EelsLogic l){
		state = s;
		logic = l;
	}
	
	/*makeTurn(Player p){
		//int roll = dice.roll(2);
		logic.move(p, roll);
	}*/

}
