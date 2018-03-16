package utility;
import bge.Board;
import bge.Piece;
import bge.Tile;



//In Progress
public class Turn {
	DiceRoller dice;
	//Logic logic;
	Board board; 
	
	
	Turn (/*Logic l,*/Board b){
		//logic = l;
		board = b; 
	}
	
	int roll(int numOfDie, int ceiling) {
		return dice.rollDice(numOfDie, ceiling);
	}
	
	
	void move(Piece p, int move_spaces) {
		
	}
	
	//Useful for E/E, since tiles are mapped to an integer
	void set(Piece p, int location) {
		
	}
	
	//If you don't have an int representation of the location, you can set on a tile using a Tile
	void set(Piece p, Tile t) {
		
	}

}
