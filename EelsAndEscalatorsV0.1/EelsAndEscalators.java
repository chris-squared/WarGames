
public class EelsAndEscalators {
	
	public static void main(String []args) {
		Board b = new Board(8, 8);
		State s = new State(b);
		Engine e = new Engine(s,  b);
	}

}
