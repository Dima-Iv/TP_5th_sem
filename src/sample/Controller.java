package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import shape.base.Figure;
import shape.elipse.Circle;
import shape.elipse.Ellipse;
import shape.oneD.Line;
import shape.oneD.LineSegment;
import shape.oneD.Ray;
import shape.polygon.RegularPolygon;
import shape.polygon.Rhombus;

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
    @FXML
    private RadioButton radioButtonRhombus;

    private double brushSize = 1;
    private int n;
    private List<Figure> figures;
    private Figure figure;
    private static final String SEGMENT = "segment";
    private static final String RAY = "ray";
    private static final String LINE = "line";
    private static final String POLYLINE = "polyline";
    private static final String ASYMMETRIC_SHAPE = "asymmetricShape";
    private static final String SYMMETRIC_SHAPE = "symmetricShape";
    private static final String REGULAR_SHAPE = "regularShape";
    private static final String CIRCLE = "circle";
    private static final String ELLIPSE = "ellipse";
    private static final String RHOMBUS = "rhombus";
    private static final String TRIANGLE = "triangle";
    private String figureName;
    private Point startPoint;
    private Point endPoint;
    private GraphicsContext graphicsContext;

    @FXML
    public void initialize() {
        figures = new ArrayList<>();
        initializeRadioButtons();
        initializeCanvas();
        initializeButton();
    }

    public void initializeRadioButtons() {
        ToggleGroup toggleGroup = new ToggleGroup();
        radioButtonSegment.setToggleGroup(toggleGroup);
        radioButtonSegment.setUserData(SEGMENT);
        radioButtonSegment.setSelected(true);
        radioButtonRay.setToggleGroup(toggleGroup);
        radioButtonRay.setUserData(RAY);
        radioButtonLine.setToggleGroup(toggleGroup);
        radioButtonLine.setUserData(LINE);
        radioButtonPolyLine.setToggleGroup(toggleGroup);
        radioButtonPolyLine.setUserData(POLYLINE);
        radioButtonAsymmetricShape.setToggleGroup(toggleGroup);
        radioButtonAsymmetricShape.setUserData(ASYMMETRIC_SHAPE);
        radioButtonRegularShape.setToggleGroup(toggleGroup);
        radioButtonRegularShape.setUserData(REGULAR_SHAPE);
        radioButtonSymmetricShape.setToggleGroup(toggleGroup);
        radioButtonSymmetricShape.setUserData(SYMMETRIC_SHAPE);
        radioButtonCircle.setToggleGroup(toggleGroup);
        radioButtonCircle.setUserData(CIRCLE);
        radioButtonEllipse.setToggleGroup(toggleGroup);
        radioButtonEllipse.setUserData(ELLIPSE);
        radioButtonRhombus.setToggleGroup(toggleGroup);
        radioButtonRhombus.setUserData(RHOMBUS);
        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov,
                                Toggle old_toggle, Toggle new_toggle) {
                if (toggleGroup.getSelectedToggle() != null) {
                    figureName = (String) toggleGroup.getSelectedToggle().getUserData();
                }
            }
        });
    }

    public void initializeCanvas() {
        graphicsContext = canvas.getGraphicsContext2D();
        startPoint = new Point();
        endPoint = new Point();
        canvas.setOnMousePressed(mouseEvent -> {
            startPoint.setLocation(mouseEvent.getX(), mouseEvent.getY());
        });

        canvas.setOnMouseReleased(mouseEvent -> {
            endPoint.setLocation(mouseEvent.getX(), mouseEvent.getY());
            drawFigure();
        });
    }

    public void initializeButton() {
        buttonNumberPoints.setOnAction(event -> {
            try {
                n = Integer.parseInt(numberPointsTextField.getText());
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Please, input correct value");
                alert.showAndWait();
            }
        });
    }

    public void drawFigure() {
        Color backgroundColor = backgroundColorPicker.getValue();
        Color borderColor = borderColorPicker.getValue();
        switch (figureName) {
            case SEGMENT: {
                LineSegment lineSegment = new LineSegment(borderColor, startPoint, endPoint);
                lineSegment.draw(graphicsContext);
                figures.add(lineSegment);
            }
            case RAY: {
                Ray ray = new Ray(borderColor, startPoint, endPoint);
                ray.draw(graphicsContext);
                figures.add(ray);
            }
            case LINE: {
                Line line = new Line(borderColor, startPoint, endPoint);
                line.draw(graphicsContext);
                figures.add(line);
            }
            case POLYLINE: {
                //todo
//                PolyLine polyLine = new PolyLine(borderColor, startPoint, endPoint);
//                polyLine.draw(graphicsContext);
                //figures.add(polyLine);
            }
            case ASYMMETRIC_SHAPE: {
                //todo
            }
            case REGULAR_SHAPE: {
                RegularPolygon lineSegment = new RegularPolygon(borderColor, startPoint, endPoint, backgroundColor, n);
                lineSegment.draw(graphicsContext);
                figures.add(lineSegment);
            }
            case SYMMETRIC_SHAPE: {
                //todo
            }
            case CIRCLE: {
                Circle circle = new Circle(borderColor, startPoint, backgroundColor, endPoint);
                circle.draw(graphicsContext);
                figures.add(circle);
            }
            case ELLIPSE: {
                Ellipse ellipse = new Ellipse(borderColor, startPoint, backgroundColor, endPoint);
                ellipse.draw(graphicsContext);
                figures.add(ellipse);
            }
            case RHOMBUS: {
                Rhombus rhombus = new Rhombus(borderColor, startPoint, backgroundColor, endPoint);
                rhombus.draw(graphicsContext);
                figures.add(rhombus);
            }
            case TRIANGLE: {
                //todo
//                Triangle triangle = new Triangle(borderColor, startPoint, backgroundColor, endPoint);
//                triangle.draw(graphicsContext);
                //figures.add(triangle);
            }
        }
    }
}