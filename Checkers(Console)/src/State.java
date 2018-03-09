// Currently doesn't do anything, but it contains an arraylist that can save the board during each turn.
import java.util.ArrayList;
public class State {
	public static ArrayList<Board> gameBoards = new ArrayList<Board>();
	
	public static void addBoard(Board board){
		gameBoards.add(board);
	}
	
	public static void printBoard(){
		for (int i = 0; i < gameBoards.size(); i++)
			System.out.println(gameBoards.get(i).board);
	}
}
