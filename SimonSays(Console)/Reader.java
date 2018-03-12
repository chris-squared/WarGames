package SimonSays;

import java.util.Scanner;

public class Reader {
	Scanner s;
	
	public Reader() {
		s = new Scanner(System.in);
	}
	
	public String scan() {
		String input;
		if (s.hasNextLine()) {
			input = s.nextLine();
		}
		else {
			input = "ERROR";
		}
		return input.toUpperCase();
	}
	
	public void close() {
		s.close();
	}
}
