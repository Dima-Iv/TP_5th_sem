package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import shape.base.Figure;
import shape.elipse.Circle;
import shape.elipse.Ellipse;

import java.awt.*;

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

    @FXML
    public void initialize() {
        canvas.setStyle("-fx-background-color: white");
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        Point startPoint = new Point();

        canvas.setOnMousePressed(mouseEvent -> {
            startPoint.setLocation(mouseEvent.getX(), mouseEvent.getY());
        });

        canvas.setOnMouseDragged(mouseEvent -> {
            graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            Ellipse ellipse = new Ellipse(Color.BLACK, startPoint, Color.WHITE, new Point((int)mouseEvent.getX(), (int)mouseEvent.getY()));
            ellipse.draw(graphicsContext);
        });

        canvas.setOnMouseReleased(mouseEvent -> {
            graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            Ellipse ellipse = new Ellipse(Color.BLACK, startPoint, Color.WHITE, new Point((int)mouseEvent.getX(), (int)mouseEvent.getY()));
            ellipse.draw(graphicsContext);
        });
        /*canvas.setOnMouseDragged(event -> {
            double x = event.getX() - brushSize / 2;
            double y = event.getY() - brushSize / 2;
            graphicsContext.setFill(colorPicker.getValue());
            graphicsContext.fillRect(x, y, brushSize, brushSize);
        });*/
    }

    private void drawShapes(GraphicsContext graphicsContext, Canvas canvas) {
        Point startPoint = new Point();
        Point endPoint = new Point();
        canvas.setOnMousePressed(mouseEvent -> {
            int startPointX = (int)mouseEvent.getX();
            int startPointY = (int)mouseEvent.getY();
            startPoint.setLocation(new Point(startPointX, startPointY));
        });

        canvas.setOnMouseReleased(mouseEvent -> {
            int endPointX = (int)mouseEvent.getX();
            int endPointY = (int)mouseEvent.getY();
            endPoint.setLocation(new Point(endPointX, endPointY));
        });

        Ellipse ellipse = new Ellipse(Color.BLACK, startPoint, Color.WHITE, endPoint);
        ellipse.draw(graphicsContext);
    }

}