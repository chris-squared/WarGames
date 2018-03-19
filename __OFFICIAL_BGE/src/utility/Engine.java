package utility;

import bge.Board;

public class Engine {
	State state; 
	Logic logic;
	Board board;

	
	Engine(State s, Logic l, Board b){
		state = s;
		logic = l;
		board = b; 
		
	}
	//TODO: Loop for turns(?)
	
	void ExecuteMove() {
		logic.executeMove();
	}
	
	void Update() {
		board.updateBoard();
	}
}
