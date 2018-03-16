package NewBoard;

import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Board extends GridPane {

    private double prefWidth;
    private double prefHeight;

    private double numRows;
    private double numCols;

    public Board(){

    }

    public Board(double prefWidth, double prefHeight, double rows, double cols){
        this.prefHeight = prefHeight;
        this.prefWidth = prefWidth;
        this.numCols = cols;
        this.numRows = rows;
        this.setPrefSize(prefWidth,prefHeight);

    }

    @Override
    public boolean isResizable(){
        return true;
    }

    @Override
    public void resize(double width, double height){
        super.setWidth(width);
        super.setHeight(height);
        redraw();
    }


    public void drawBoard(){
        this.getChildren().clear();
        layOutTiles();

    }

    public void bind(AnchorPane parent){
        this.prefWidthProperty().bind(parent.widthProperty());
        this.prefHeightProperty().bind(parent.heightProperty());
    }

    public void redraw(){
        this.getChildren().clear();
        layOutTiles();
    }

    private void layOutTiles(){
        for (int row = 0; row < numRows; row++){
            for (int col = 0; col < numCols; col++){
                Tile tile = new Tile(row,col);
                tile.setTranslateX(col * getXTranslate());
                tile.setTranslateY(row * getYTranslate());
                this.getChildren().add(tile);

            }
        }
    }

    private double getXTranslate(){
        return this.getWidth()/numCols;
    }

    private double getYTranslate(){
        return this.getHeight()/numRows;
    }

    public class Tile extends StackPane {
        private int row;
        private int col;
        private Text text = new Text();
        public Tile(int row, int col) {
            this.row = row;
            this.col = col;
            Rectangle border = new Rectangle();
            border.setHeight(Board.this.getHeight()/numRows);
            border.setWidth(Board.this.getHeight()/numCols);
            border.setFill(null);
            border.setStroke(Color.BLACK);

            setAlignment(Pos.CENTER);
            border.widthProperty().bind(Board.this.widthProperty().divide(numCols));
            border.heightProperty().bind(Board.this.heightProperty().divide(numRows));

            getChildren().addAll(border, text);


            // Below is for tictactoe
            setOnMouseClicked(event -> {
                if (event.getButton() == MouseButton.PRIMARY){
                    drawX();
                    System.out.println("Row: " + row + " Col: " + col);
                }
                else if (event.getButton() == MouseButton.SECONDARY){
                    drawO();
                    System.out.println("Row: " + row + " Col: " + col);
                }
            });

        }

        public int getRow(){
            return row;
        }
        public int getCol(){
            return col;
        }

        private void drawX(){
            text.setText("X");
        }

        private void drawO(){
            text.setText("O");
        }

    }


    public double getNumRows() {
        return numRows;
    }

    public double getNumCols() {
        return numCols;
    }

    public void setNumCols(double numCols) {
        this.numCols = numCols;
    }

    public void setNumRows(double numRows){
        this.numRows = numRows;
    }
}
