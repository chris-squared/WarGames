package app.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class GUIWindow {

    private double xSize = 400;
    private double ySize = 400;
    private String title = "";
    private Scene scene;
    private Stage stage;

    public GUIWindow(Stage stage){
        this.stage = stage;
    }
    
    public Stage getStage() {
        return stage;
    }

    public void setStage() {
        this.stage.setTitle(title);
        this.stage.setScene(scene);
    }

    public void setxSize(double xSize){
        this.xSize = xSize;
    }

    public double getxSize() {
        return xSize;
    }

    public double getySize() {
        return ySize;
    }

    public void setySize(double ySize) {
        this.ySize = ySize;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene){
        this.scene = scene;
    }
}
