
public class Profile {
	/*
	Profile class created because each game seems to use a Player class differently. Furthermore, it doesn't really make sense to me to 
	keep attributes specific to games inside of the profile when they're going to be reset or tossed out (or not even used, depending on the game).
	Thus, a new class.
	
	POTENTIAL CHANGES:
	1. Merge with unified player class, depending on what we decide during refactoring?
	2. ???
	*/
	
	private String username;
	private int wins = 0;
	private int losses = 0;
	
	public Profile(String uName){
		this.username = uName;
	}
	public float getWLratio(){//returns the profile's win/loss ratio.
		return this.wins/this.losses;
	}
	
	public void addWin(){//increments wins counter by 1.
		this.wins += 1;
	}
	
	public void addLoss(){//increments losses counter by 1.
		this.losses +=1;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getWins() {
		return wins;
	}
	
	public void setWins(int wins) {
		this.wins = wins;
	}
	
	public int getLosses() {
		return losses;
	}
	
	public void setLosses(int losses) {
		this.losses = losses;
	}
	
	
	
}
