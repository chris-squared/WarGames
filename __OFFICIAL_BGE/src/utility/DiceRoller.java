package utility;
import java.util.Random;

public class DiceRoller {
	
	//Rolls the dice for any games that would need it
	//And returns the total amount of the rolls. It allows you
	//To specify how many dice, and how large the die are. 
	int rollDice(int numOfDice, int ceiling) {
		int TotalRoll=0;
		Random r = new Random();
		for(int i = 0; i < numOfDice; i++)
			TotalRoll+= r.nextInt(ceiling-1) + 1;
		return TotalRoll;
		
	}
	

}
