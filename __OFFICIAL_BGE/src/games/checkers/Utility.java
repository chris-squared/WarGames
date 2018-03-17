package games.checkers;
import java.util.Scanner;
public class Utility {
	
	public static void printMenu(){
		System.out.println("Welcome to Checkers!");
		System.out.println("");
	}
	
	public static int promptForStartColumn(Scanner in){
		int column;
		System.out.print("Please enter column number to move from: ");
		column = in.nextInt();
		System.out.println("");
		return column;
	}
	
	public static int promptForStartRow(Scanner in){
		int row;
		System.out.print("Please enter row number to move from: ");
		row = in.nextInt();
		return row;
	}
	
	public static int promptForEndColumn(Scanner in){
		int column;
		System.out.print("Please enter column number to move to: ");
		column = in.nextInt();
		System.out.println("");
		return column;
	}
	
	public static int promptForEndRow(Scanner in){
		int row;
		System.out.print("Please enter row number to move to: ");
		row = in.nextInt();
		return row;
	}

}
