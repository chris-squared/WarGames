package utility;
import bge.Board;
import bge.Piece;
import bge.Player;
import bge.Tile;



//In Progress
public class Turn {
	DiceRoller dice;
	Board board; 
	Player currentPlayer; 
	
	
	Turn (Board b, Player p){
		currentPlayer = p;
		board = b; 
	}
	
	int roll(int numOfDie, int ceiling) {
		return dice.rollDice(numOfDie, ceiling);
	}
	
	
	

}
