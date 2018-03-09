package SimonSays;

public class ConsoleDriver extends Driver {
	public void play() {
		Reader r = new Reader();
		SimonSaysLogic ssl = new SimonSaysLogic(r);
		while(!ssl.finished) {
			if (ssl.errorMade) {
				ssl.setGameFinished();
				break;
			}
			ssl.setSimonPattern();
			ssl.getPlayerPattern();
		}
		r.close();
	}
	
	public static void main(String[] args) {
		ConsoleDriver cd = new ConsoleDriver();
		cd.play();
	}
}

