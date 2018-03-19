package bge;

public class Player {

	private String username;

	private int playerWins = 0;
	private int playerLosses = 0;
	public int turn;
	public String gamePiece;

	public Player(){

	}

	public Player(String username, int turn, String gamePiece) {
		this.username = username;
		this.turn = turn;
		this.gamePiece = gamePiece;
	}


	public void incWins(){
		this.playerWins++;
	}

	public void incLosses(){
		this.playerLosses++;
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

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public String getGamePiece() {
		return gamePiece;
	}

	public void setGamePiece(String gamePiece) {
		this.gamePiece = gamePiece;
	}
}
