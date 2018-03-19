package games.checkers;
public class CheckersPlayer{

	public static int red = 12;
	public static int black = 12;
	public String gamePiece;
	public String gamePiece2;
	public int turn;
	
	public CheckersPlayer(int turn, String gamePiece, String gamePiece2){
		this.turn = turn;
		this.gamePiece = gamePiece;
	}
	
}
