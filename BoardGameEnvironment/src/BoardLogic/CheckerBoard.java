package BoardLogic;
import java.util.ArrayList;

import javafx.scene.paint.Color;

public class CheckerBoard extends Board {
	
	public CheckerBoard() {
		super("Test Checkers",8,8,500,500);
	}
	
	public void setTileColors() {
		
		boolean colorFlag = true;
		
		for (int row = 0; row < rowsNum; ++row) {
			for (int col = 0; col < colsNum; ++col) {
				if (colorFlag)
					getTile(row, col).setColor(Color.BLACK);
				else
					getTile(row,col).setColor(Color.WHITE);
				colorFlag = !colorFlag;
			}
			colorFlag = !colorFlag;
		}
	}

	@Override
	void setStartingTileColors() {
		setTileColors();
	}

	@Override
	void setStartingPieces() {
	}

}
