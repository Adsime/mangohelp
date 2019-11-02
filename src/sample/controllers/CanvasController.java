package sample.controllers;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;

public class CanvasController {

    public Canvas myCanvas;
    public ColorPicker borderColor;
    public ComboBox shapeType;
    public CheckBox filled;
    public ColorPicker fillColor;
    public Pane test;
    private List<Shape> shapes = new ArrayList<>();

    private double x, y;
    private Shape currentShape;

    public void onMousePressed(MouseEvent mouseEvent) {
        x = mouseEvent.getX();
        y = mouseEvent.getY();
    }

    private void reset() {
        this.x = this.y = -1.;
        currentShape = null;
    }

    private Shape selectShape() {
        Polygon rectangle = new Polygon(0, 0, 0, 0, 0, 0);
        rectangle.setStroke(borderColor.getValue());
        System.out.println(borderColor.getValue());
        rectangle.setFill(filled.isSelected() ? fillColor.getValue() : Color.TRANSPARENT);
        return rectangle;
    }

    public void onMouseDragged(MouseEvent mouseEvent) {
        if(currentShape == null) {
            currentShape = selectShape();
            shapes.add(currentShape);
            test.getChildren().addAll(currentShape);
        }
        ((Polygon) currentShape).getPoints()
                .setAll(x + (mouseEvent.getX() - x)/2, y,
                        x, mouseEvent.getY(),
                        mouseEvent.getX(), mouseEvent.getY()
                        );

    }

    public void clearCanvas() {
        test.getChildren().clear();
    }

    public void drawShapes() {
        //shapes.forEach(shape -> shape.draw(myCanvas.getGraphicsContext2D()));
    }


    public void onClick(MouseEvent mouseEvent) {
        if(currentShape != null) {
            return;
        }
    }

    public void onMouseReleased(MouseEvent mouseEvent) {
        this.reset();
    }
}
