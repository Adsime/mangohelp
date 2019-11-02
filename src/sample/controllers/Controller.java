package sample.controllers;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;

public class Controller extends AnimationTimer {

    private CanvasController canvasController;

    public Controller(FXMLLoader loader) {
        canvasController = (CanvasController) loader.getController();
        start();
    }

    @Override
    public void handle(long l) {
        //canvasController.clearCanvas();
        //canvasController.drawShapes();
    }
}
