package bge;

public class Player {
	
	private String username;

	private int playerWins = 0;
	private int playerLosses = 0;


	public Player(String username) {

		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPlayerWins() {
		return playerWins;
	}

	public void setPlayerWins(int playerWins) {
		this.playerWins = playerWins;
	}

	public int getPlayerLosses() {
		return playerLosses;
	}

	public void setPlayerLosses(int playerLosses) {
		this.playerLosses = playerLosses;
	}
}
