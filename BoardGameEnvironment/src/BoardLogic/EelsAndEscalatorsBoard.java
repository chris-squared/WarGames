package BoardLogic;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public class EelsAndEscalatorsBoard extends Board {
	
	EelsAndEscalatorsBoard(){
		super("Electric Eels and Super Escalators 2: Super Ultra Force", 10, 10, 1080, 1920);
	}
	
public void setTileColors() {
		
		boolean colorFlag = true;
		
		for (int row = 0; row < rowsNum; ++row) {
			for (int col = 0; col < colsNum; ++col) {
				if (colorFlag)
					getTile(row, col).setColor(Color.BLUE);
				else
					getTile(row,col).setColor(Color.GREEN);
				colorFlag = !colorFlag;
			}
			colorFlag = !colorFlag;
		}
	}

	@Override
	void setStartingTileColors() {
		setTileColors();
	}
	
	public void setStartingPieces() {
		pieces = new ArrayList<Piece>();
		
	}

}
