import BoardLogic.EelsAndEscalatorsBoard;

public class EelsTestingMain {
	
	public static void main(String [] args) {
		EelsAndEscalatorsBoard gameBoard = new EelsAndEscalatorsBoard();
		EelsState test = new EelsState(gameBoard);
		test.addEscalator(10, 14);
		System.out.println(test.isEscalatorRepository(10));
	}

}
