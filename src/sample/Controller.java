package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import shape.elipse.Circle;
import shape.elipse.Ellipse;
import shape.polygon.*;
import shape.polygon.Polygon;
import shape.polygon.Rectangle;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    private Canvas canvas;

    @FXML
    private ColorPicker backgroundColorPicker;

    @FXML
    private Button buttonNumberPoints;

    @FXML
    private ColorPicker borderColorPicker;

    @FXML
    private RadioButton radioButtonSegment;

    @FXML
    private RadioButton radioButtonRay;

    @FXML
    private RadioButton radioButtonLine;

    @FXML
    private RadioButton radioButtonPolyLine;

    @FXML
    private RadioButton radioButtonAsymmetricShape;

    @FXML
    private RadioButton radioButtonRegularShape;

    @FXML
    private RadioButton radioButtonSymmetricShape;

    @FXML
    private RadioButton radioButtonCircle;

    @FXML
    private RadioButton radioButtonEllipse;

    @FXML
    private TextField numberPointsTextField;

    private double brushSize = 1;

    @FXML
    public void initialize() {
        initializeRadioButtons();
        initializeCanvas();
        initializeButton();
    }

    public void initializeRadioButtons() {
        ToggleGroup toggleGroup = new ToggleGroup();
        radioButtonSegment.setToggleGroup(toggleGroup);
        radioButtonSegment.setSelected(true);
        radioButtonRay.setToggleGroup(toggleGroup);
        radioButtonLine.setToggleGroup(toggleGroup);
        radioButtonPolyLine.setToggleGroup(toggleGroup);
        radioButtonAsymmetricShape.setToggleGroup(toggleGroup);
        radioButtonRegularShape.setToggleGroup(toggleGroup);
        radioButtonSymmetricShape.setToggleGroup(toggleGroup);
        radioButtonCircle.setToggleGroup(toggleGroup);
        radioButtonEllipse.setToggleGroup(toggleGroup);
    }

    public void initializeCanvas() {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        /*List<Point> pointList = new ArrayList<>();

        canvas.setOnMouseClicked(mouseEvent -> {
            pointList.add(new Point((int)mouseEvent.getX(), (int)mouseEvent.getY()));
            Polygon polygon = new Polygon(borderColorPicker.getValue(), backgroundColorPicker.getValue(),
                    pointList);
            polygon.draw(graphicsContext);
        });*/

        Point startPoint = new Point();

        canvas.setOnMousePressed(mouseEvent -> {
            startPoint.setLocation(mouseEvent.getX(), mouseEvent.getY());
        });

        canvas.setOnMouseDragged(mouseEvent -> {
            graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            Triangle ellipse = new Triangle(borderColorPicker.getValue(), startPoint,
                    backgroundColorPicker.getValue(), new Point((int)mouseEvent.getX(), (int)mouseEvent.getY()));
            ellipse.draw(graphicsContext);
        });

        canvas.setOnMouseReleased(mouseEvent -> {
            graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            Triangle ellipse = new Triangle(borderColorPicker.getValue(), startPoint,
                    backgroundColorPicker.getValue(), new Point((int)mouseEvent.getX(), (int)mouseEvent.getY()));
            ellipse.draw(graphicsContext);
        });
    }

    public void initializeButton() {
        buttonNumberPoints.setOnAction(event -> {
            try {
                int numberPoints = Integer.parseInt(numberPointsTextField.getText());
                //TODO
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Please, input correct value");
                alert.showAndWait();
            }
        });
    }

    private void drawShapes(GraphicsContext graphicsContext, Canvas canvas) {
        Point startPoint = new Point();
        Point endPoint = new Point();
        canvas.setOnMousePressed(mouseEvent -> {
            int startPointX = (int) mouseEvent.getX();
            int startPointY = (int) mouseEvent.getY();
            startPoint.setLocation(new Point(startPointX, startPointY));
        });

        canvas.setOnMouseReleased(mouseEvent -> {
            int endPointX = (int) mouseEvent.getX();
            int endPointY = (int) mouseEvent.getY();
            endPoint.setLocation(new Point(endPointX, endPointY));
        });

        Ellipse ellipse = new Ellipse(Color.BLACK, startPoint, Color.WHITE, endPoint);
        ellipse.draw(graphicsContext);
    }
}