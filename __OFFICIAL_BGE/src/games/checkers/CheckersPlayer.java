package games.checkers;

import bge.Player;

public class CheckersPlayer extends Player{
	public String gamePiece;
	public String gamePiece2;
	public int turn;
	
	public CheckersPlayer(String name, int turn, String gamePiece, String gamePiece2){
		super(name, turn, gamePiece);
		this.turn = turn;
		this.gamePiece = gamePiece;
	}
	
}
