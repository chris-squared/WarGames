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
	public HashMap<Color, Tile> ColorRepository = new HashMap<Color, Tile>();
	
	/*Constructs a new state with the board*/
	public SimonSaysState(SimonSaysBoard board) {
		gameBoard = board;
	}
	
	/*Assign each tile to a Color*/
	public void AssignTiles() {
		//Should take in an array of Colors?
	}
	public SimonSaysBoard getGameBoard() {
		return gameBoard;
	}

}
