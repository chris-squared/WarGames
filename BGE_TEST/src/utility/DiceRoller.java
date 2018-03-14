package utility;
import java.util.Random;

public class DiceRoller {
	
	int rollDice(int numOfDice, int ceiling) {
		int TotalRoll=0;
		Random r = new Random();
		for(int i = 0; i < numOfDice; i++)
			TotalRoll+= r.nextInt(ceiling-1) + 1;
		return TotalRoll;
		
	}
	

}
