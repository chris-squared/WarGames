package games.eelsandescalators;
import bge.GameOverException;
import bge.Piece;
import bge.Player;
import bge.Tile;
import games.EelsAndEscalatorsBoard;
import utility.DiceRoller;
import utility.Logic;
import utility.State;


public class EelsLogic extends Logic {
	DiceRoller dr = new DiceRoller();
	EelsState state;
	EelsAndEscalatorsBoard board;

	



	
	public EelsLogic(EelsState s, EelsAndEscalatorsBoard g){
		super();
		state = s;
		board =  g;
		

	}


	//Moves the player piece based on the roll
	void move (Player p, int roll) {
		System.out.println("MOVING");
		System.out.println("PLAYER : " + p.getTurn());
		//First, get the player's tile position
		int player_tile = state.getPlayerLocation(p);
		System.out.println("GOT LOCATION: " + player_tile);
		//If the roll isn't going to push the player past the finish line...
		//NOTE: This is not just to avoid an out-of-bounds exception -- the rules of the game dictate that you must land exactly on the finish space
		if (!(player_tile + roll > 100)) {
			int newR;
			int newC;
			//...Move them x number of spaces.
			
			int curR = state.BoardPathRepository.get(player_tile).getBoardCoord().getRow();
			int curC = state.BoardPathRepository.get(player_tile).getBoardCoord().getCol();
			if (onEel(player_tile+roll) != 0) {
				 int  result = onEel(player_tile+roll);
				 state.setPlayerLocation(p, result);
				 newR = state.BoardPathRepository.get(result).getBoardCoord().getRow();
				 newC = state.BoardPathRepository.get(result).getBoardCoord().getCol();
			}
			else if (onEscalator(player_tile+roll) != 0) {
				int  result = onEscalator(player_tile+roll);
				state.setPlayerLocation(p, result);
				newR = state.BoardPathRepository.get(result).getBoardCoord().getRow();
				newC = state.BoardPathRepository.get(result).getBoardCoord().getCol();
			}
			
			else {
				state.setPlayerLocation(p, (player_tile + roll));
				newR = state.BoardPathRepository.get((player_tile+roll)).getBoardCoord().getRow();
				newC = state.BoardPathRepository.get((player_tile+roll)).getBoardCoord().getCol();}
			if(p.getTurn() == 0)
				board.movePieceP1(curR, curC, newR, newC);
			else
				board.movePieceP2(curR, curC, newR, newC);}

	}
	


	
	boolean is_winner(Player p) {
		return (state.playerLocationRepo.get(p) == 100);
	}

	//Tells if you are on an Eel and where to move you.
	int onEel(int current_tile) {
		if (state.isEelPosition(current_tile)) {
			int result_tile = state.EelsRepository.get(current_tile);
			System.out.println("ON EEL AT PLACE " + current_tile + ": MOVING TO NEW LOCATION AT TILE " + result_tile );
			return result_tile; }
		return 0; 

	}

	//Tells you if you are on an Escalator and where to move you.
	int onEscalator(int current_tile) {
		if (state.isEscalatorPosition(current_tile)) {
			int result_tile = state.EscalatorsRepository.get(current_tile);
			System.out.println("ON ESCALATOR AT PLACE " + current_tile + ": MOVING TO NEW LOCATION AT TILE " + result_tile );
			return result_tile;
		}
		return 0;

	}


	//Verifies if a piece is on the winning tile
	@Override
	public boolean check_win_condition(Piece p) {
		return (state.BoardPathRepository.get(100).getBoardCoord() == p.getBoardCoord());
	}


	@Override
	public boolean isValidMove(Piece p, Tile start, Tile end) {
		return (state.BoardPathRepository.get(100) != end);
	}


	@Override
	//Adapter to actually make the move from within the logic class -- allows a standardized function to be called in engine
	public void executeMove(Player p) throws GameOverException {
	
		int roll = dr.rollDice(2, 7);
		System.out.println(roll);
		move(p, roll);
		if (is_winner(p))
			board.throwGameIsOver();
		
	}











}
