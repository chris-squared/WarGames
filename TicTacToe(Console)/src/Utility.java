import java.util.Scanner;
public class Utility {
	
	public static void printMenu(){
		System.out.println("Welcome to TicTacToe!");
		System.out.println("");
	}
	
	public static int getTurnOrder(Scanner in){
		int turn;
		System.out.println("Would you like to take the 1st turn or 2nd turn?");
		System.out.print("Please enter 1 or 2: ");
		turn = in.nextInt();
		return turn;
	}
	
	public static int promptForColumn(Scanner in){
		int column;
		System.out.print("Please enter column number: ");
		column = in.nextInt();
		System.out.println("");
		return column;
	}
	
	public static int promptForRow(Scanner in){
		int row;
		System.out.print("Please enter row number: ");
		row = in.nextInt();
		return row;
	}

}
