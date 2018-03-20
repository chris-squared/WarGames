package utility;

import bge.Board;
import bge.Player;
import games.CheckersBoard;
import games.EelsAndEscalatorsBoard;
import games.SimonSaysBoard;
import games.checkers.CheckersLogic;
import games.checkers.CheckersState;
import games.eelsandescalators.*;
import games.simonsays.SimonSaysLogic;
import games.simonsays.SimonSaysState;
import games.tictactoe.TicTacToeBoard;
import games.tictactoe.TicTacToeLogic;

//This is where you go if you want to add a new game. Cleaner interface makes adding a game easy! 

public class EngineBuilder {
	public static Engine  BuildEngine(String gamename, Player p1, Player p2) throws Exception {
		  Board board = null;
		  Logic logic = null;
		if (gamename.equals("Electric Eels and Super Escalators 2: Super Ultra Force")) {
			  
			   board = new EelsAndEscalatorsBoard();
			   EelsState state = new EelsState((EelsAndEscalatorsBoard)board, p1, p2);
			   logic = new EelsLogic(state, (EelsAndEscalatorsBoard)board);
			   Engine engine = new Engine(logic, board, p1, p2);
			   engine.addState(state);
			   return engine; 
			  
		   }
		   
		   else if (gamename.equals("Tic-Tac-Toe")){
			   board = new TicTacToeBoard();
			   logic = new TicTacToeLogic((TicTacToeBoard)board);
		   }
		   
		   else if (gamename.equals("Checkers")) {
			   board = new CheckersBoard();
			   CheckersState ch = new CheckersState();
			   logic = new CheckersLogic(ch);
			   
			   
		   }
		   
		   else if (gamename.equals("Simon Says")) {
			   board = new SimonSaysBoard();
			   SimonSaysState ss = new SimonSaysState();
			   logic = new SimonSaysLogic(ss);
			  
		   }
		 Engine engine = new Engine(logic, board, p1, p2);
		 return engine;
		  
	   }}

