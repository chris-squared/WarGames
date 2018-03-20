package gui;

import bge.Board;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import main.Main;
import utility.Engine;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class FXMLGameEnvironmentController implements Initializable{
	Engine engine;
    private BGE_GUI bge;
    private Board newBoard;
    private Stage primaryStage;

    @FXML
    private GridPane boardgrid;

    @FXML
    private AnchorPane gridPaneParent;

    @FXML
    private Label playerTurn;

    @FXML
    private Label player1Name;

    @FXML
    private Label player2Name;

    public FXMLGameEnvironmentController(Board newBoard, Stage primaryStage){
        System.out.println("GameEnvironmentController set the new board");
        this.newBoard = newBoard;
        this.primaryStage = primaryStage;
    }
    
    
    public void setEngine(Engine e) {
    	engine = e;
    }
    @FXML
    public String getPlayerTurn(){
        return playerTurn.getText();
    }

    @FXML
    public void setPlayerTurn(String playerName){
        playerTurn.setText(playerName);
    }

    @FXML
    public void setPlayer1Name(String name){
        player1Name.setText(name);
    }

    @FXML
    public void setPlayer2Name(String name){
        player2Name.setText(name);
    }

    @FXML
    protected void whosTurn(){
        if (newBoard.turn % 2 == 0){
            setPlayerTurn(player1Name.getText());
        }else{
            setPlayerTurn(player2Name.getText());
        }
    }


    @FXML
    protected void playerStatsAlert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("War Games");
        alert.setHeaderText("Player Stats");
        alert.setContentText(null);


        Label label = new Label("Player Info: ");

        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setWrapText(true);

        String text = "";
        for (Iterator iterator = Main.playerProfile.playerJSONMap.keySet().iterator();iterator.hasNext();){
            String key = (String)iterator.next();
            text += key;
            text += "\n";
            text += Main.playerProfile.playerJSONMap.get(key);
            text += "\n";
        }
        textArea.setText(text);



        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);


        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

// Set expandable Exception into the dialog pane.
        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        System.out.println("GameEnvironment Initialized");
        bge = new BGE_GUI(engine, primaryStage, gridPaneParent.getPrefHeight(), gridPaneParent.getPrefWidth());
        bge.updateDisplay();
        gridPaneParent.getChildren().clear();
        gridPaneParent.getChildren().addAll(bge.getGrid());
		bge.mouseClickListener();
        bge.getGrid().addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                whosTurn();
            }
        });

    }

}
