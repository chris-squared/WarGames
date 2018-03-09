package SimonSays;

import java.util.ArrayList;

public class SimonSaysLogic {
	protected boolean finished;
	protected boolean errorMade;
	protected ArrayList<String> simonPattern;
	protected Reader reader;
	
	
	public SimonSaysLogic(Reader r){
		finished = false;
		errorMade = false;
		simonPattern = new ArrayList<String>();
		reader = r;
	}
	
	public void setGameFinished() {
		finished = true;
	}
	
	public boolean getGameFinished() {
		return finished;
	}
	
	public void setSimonPattern() {
		System.out.print("Enter a new color (R,G,B,Y) to the pattern: ");
		String color = reader.scan();
		simonPattern.add(color);
	}
	
	public void getPlayerPattern() {
		System.out.print("Enter the entire pattern: ");
		String playerPattern = reader.scan();
		String simonPatternString = String.join("", simonPattern);
		if (!playerPattern.equals(simonPatternString)) {
			errorMade = true;
			System.out.println("\nYou lose! The correct pattern was '" + simonPatternString + "'\n");
		}
		else{
			System.out.println("\nYour pattern was correct!\n");
		}
	}
	
	public void printSimonPattern() {
		String stringSimonPattern = String.join("", simonPattern);
		System.out.println(stringSimonPattern);
	}
}
