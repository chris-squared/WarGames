package games.simonsays;

import java.awt.Color;
import java.util.HashMap;

import bge.Board;
import bge.Tile;
import games.SimonSaysBoard;
import utility.State;

public class SimonSaysState extends State {
	public SimonSaysBoard gameBoard;
	
	/*Keeps track of color tiles on the board*/
	public HashMap<Tile, Color> ColorRepository = new HashMap<Tile, Color>();
	
	/*Constructs a new state with the board*/
	public SimonSaysState(SimonSaysBoard board) {
		super(board);
	}
	
	public SimonSaysBoard getGameBoard() {
		return gameBoard;
	}

}
