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
import shape.polygon.Polygon;
import shape.polygon.RegularPolygon;
import shape.polygon.Rhombus;
import shape.polygon.Triangle;

import java.awt.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

import static java.lang.Math.abs;

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
    private RadioButton radioButtonTriangle;

    @FXML
    private RadioButton radioButtonCircle;

    @FXML
    private RadioButton radioButtonEllipse;

    @FXML
    private TextField numberPointsTextField;
    @FXML
    private RadioButton radioButtonRhombus;

    private int n;
    private List<Figure> figures;
    private List<Point> pointList;
    private static final String SEGMENT = "segment";
    private static final String RAY = "ray";
    private static final String LINE = "line";
    private static final String POLYLINE = "polyline";
    private static final String ASYMMETRIC_SHAPE = "asymmetricShape";
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
        pointList = new ArrayList<>();
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
        radioButtonTriangle.setToggleGroup(toggleGroup);
        radioButtonTriangle.setUserData(TRIANGLE);
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
        figureName = SEGMENT;

        canvas.setOnMouseClicked(mouseEvent -> {
            pointList.add(new Point((int)mouseEvent.getX(), (int)mouseEvent.getY()));
            drawFigure(false);
        });

        canvas.setOnMousePressed(mouseEvent -> {
            startPoint.setLocation(mouseEvent.getX(), mouseEvent.getY());
        });

        canvas.setOnMouseDragged(mouseEvent -> {
            endPoint.setLocation(mouseEvent.getX(), mouseEvent.getY());
            graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            drawFigure(true);
        });

        canvas.setOnMouseReleased(mouseEvent -> {
            endPoint.setLocation(mouseEvent.getX(), mouseEvent.getY());
            drawFigure(false);
            System.out.println(figures);
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

    public void drawFigure(Boolean dragFlag) {
        Color backgroundColor = backgroundColorPicker.getValue();
        Color borderColor = borderColorPicker.getValue();
        switch (figureName) {
            case SEGMENT: {
                LineSegment lineSegment = new LineSegment(borderColor, startPoint, endPoint);
                lineSegment.draw(graphicsContext);
                if(!dragFlag){
                    figures.add(lineSegment);
                }
                break;
            }
            case RAY: {
                Ray ray = new Ray(borderColor, startPoint, endPoint);
                ray.draw(graphicsContext);
                if(!dragFlag){
                    figures.add(ray);
                }
                break;
            }
            case LINE: {
                Line line = new Line(borderColor, startPoint, endPoint);
                line.draw(graphicsContext);
                if(!dragFlag){
                figures.add(line);
                }
               break;
            }
            case POLYLINE: {
                //todo
//                PolyLine polyLine = new PolyLine(borderColor, startPoint, endPoint);
//                polyLine.draw(graphicsContext);
                //figures.add(polyLine);
                break;
            }
            case ASYMMETRIC_SHAPE: {
                Polygon polygon = new Polygon(borderColor, startPoint, backgroundColor, pointList);
                polygon.draw(graphicsContext);
                if(!dragFlag) {
                    figures.add(polygon);
                }
                break;
            }
            case REGULAR_SHAPE: {
                RegularPolygon regularPolygon = new RegularPolygon(borderColor, startPoint, endPoint, backgroundColor, n);
                regularPolygon.draw(graphicsContext);
                if(!dragFlag)
                    figures.add(regularPolygon);
                break;
            }
            case CIRCLE: {
                Circle circle = new Circle(borderColor, startPoint, backgroundColor, endPoint);
                circle.draw(graphicsContext);
                if(!dragFlag) {
                    figures.add(circle);
                }
                break;
            }
            case ELLIPSE: {
                Ellipse ellipse = new Ellipse(borderColor, startPoint, backgroundColor, endPoint);
                ellipse.draw(graphicsContext);
                if(!dragFlag) {
                    figures.add(ellipse);
                }
                break;
            }
            case RHOMBUS: {
                Rhombus rhombus = new Rhombus(borderColor, startPoint, backgroundColor, endPoint);
                rhombus.draw(graphicsContext);
                if(!dragFlag){
                figures.add(rhombus);
                }
                break;
            }
            case TRIANGLE: {
                Triangle triangle = new Triangle(borderColor, startPoint, backgroundColor, endPoint);
                triangle.draw(graphicsContext);
                if(!dragFlag) {
                    figures.add(triangle);
                }
                break;
            }
        }
    }
}