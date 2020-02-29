package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;
import shape.base.Figure;

public class Controller {

    @FXML
    private Canvas canvas;

    @FXML
    private ListView<?> listView;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private ComboBox<Figure> comboBox;

    private double brushSize = 1;

    public void initialize() {
        canvas.setStyle("-fx-background-color: white");
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        canvas.setOnMouseDragged(event -> {
            double x = event.getX() - brushSize / 2;
            double y = event.getY() - brushSize / 2;
            graphicsContext.setFill(colorPicker.getValue());
            graphicsContext.fillRect(x, y, brushSize, brushSize);
        });
    }

}