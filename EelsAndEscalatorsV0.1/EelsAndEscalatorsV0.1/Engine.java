
public class Engine {
	State s;
	Logic l;
	Board b; 
	ConsoleGUI g; 
	Turn t;
	Player player1;
	Player player2;
	boolean running; 
	Engine(State state, Board board){
		s = state;
		b = board;
		g = new ConsoleGUI(b);
		l = new Logic(b, s, g);
		
		running = true; 
		t = new Turn (s, l, b);
		
		//Populate the Board with pieces 
		for (int row = 0; row < b.board.length; row++)
			for(int column = 0; column < (b.board[row].length); column++)
				b.board[row][column]= "[ ]";
		
		//Set the finishing piece of the board
		
		b.board[0][0] = "[F]";
		
		
		
		
		//Generate players
		player1 = new Player("[C]");
		s.addPlayer(player1);
		
		//Set player at start
		s.setPlayerLocation(player1, 7, 0);
		s.update(g);
		
		//SET TEST ESCALATOR
		int[] test = new int[] {7,2};
		int[] test1 = new int[] {5, 3};
		s.addEscalator(test, test1);
		l.onEscalator(player1);
		
		t.makeTurn(player1, 1);
		t.makeTurn(player1, 1);
	
	}
	
	
	}


	

