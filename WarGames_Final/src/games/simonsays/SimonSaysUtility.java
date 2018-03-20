package games.simonsays;

import java.util.Scanner;

public class SimonSaysUtility {
	public static void printMenu() {
		System.out.println("Welcome to Simon Says");
		for (Color c: Color.values()) {
			System.out.printf("%s\t=\t%s\n", c, c.code);
		}
		System.out.println();
	}
	
	public static Color promptToGuessColor(Scanner in) {
		System.out.print("> ");
		Color color = stringToColor(in.nextLine());
		System.out.println();
		return color;
	}
	
	public static Color promptToAddColor(Scanner in) {
		System.out.print("Please add a color to your opponent's pattern: ");
		Color color = stringToColor(in.nextLine());
		System.out.println();
		return color;
	}
	
	//HELPER FUNCTION
	public static Color coordsToColor(int row, int col) {
		Color result = null;
		if (row == 0 && col == 0) {
			result = Color.RED;
		}
		else if (row == 0 && col == 1) {
			result = Color.BLUE;
		}
		else if (row == 0 && col == 2) {
			result = Color.GREEN;
		}
		else if (row == 1 && col == 0) {
			result = Color.PINK;
		}
		else if (row == 1 && col == 1) {
			result = Color.PURPLE;
		}
		else if (row == 1 && col == 2) {
			result = Color.YELLOW;
		}
		else if (row == 2 && col == 0) {
			result = Color.ORANGE;
		}
		else if (row == 2 && col == 1) {
			result = Color.BROWN;
		}
		else if (row == 2 && col == 2) {
			result = Color.SILVER;
		} 
		return result;
	}
	
	public static Color stringToColor(String s) {
		Color result;
		switch (s.toUpperCase()) {
		case "R":
			result = Color.RED;
			break;
		case "B":
			result = Color.BLUE;
			break;
		case "G":
			result = Color.GREEN;
			break;
		case "P":
			result = Color.PINK;
			break;
		case "Y":
			result = Color.YELLOW;
			break;
		case "O":
			result = Color.ORANGE;
			break;
		case "BR": 
			result =  Color.BROWN;
			break;
		case "S":
			result =  Color.SILVER;
			break;
		default:
			result = null;
		}
		return result;
	}
}
