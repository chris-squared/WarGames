package gui;

import bge.Board;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class BoardController {

    public Parent createContent(Board board){
        Pane boardGrid = new Pane();

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                Tile tile = new Tile();
                tile.setTranslateX(j * 200);
                tile.setTranslateY(i * 200);
                boardGrid.getChildren().add(tile);
            }
        }
        return boardGrid;
    }

    private class Tile extends StackPane {
        private Text text = new Text();
        public Tile() {
            Rectangle border = new Rectangle();
            border.setFill(null);
            border.setStroke(Color.BLACK);

            setAlignment(Pos.CENTER);
            getChildren().addAll(border, text);

            setOnMouseClicked(event -> {
                if (event.getButton() == MouseButton.PRIMARY){
                    drawX();
                }
                else if (event.getButton() == MouseButton.SECONDARY){
                    drawO();
                }
            });

        }

        private void drawX(){
            text.setText("X");
        }

        private void drawO(){
            text.setText("O");
        }
    }


}
