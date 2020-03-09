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
import shape.oneD.PolyLine;
import shape.oneD.Ray;
import shape.polygon.Polygon;
import shape.polygon.Rectangle;
import shape.polygon.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

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

    @FXML
    public RadioButton radioButtonRectangle;

    private int n;
    private List<Figure> figures;
    private List<Point> pointList;
    private List<LineSegment> lineSegments;
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
    private static final String RECTANGLE = "rectangle";
    private String figureName;
    private GraphicsContext graphicsContext;

    @FXML
    public void initialize() {
        figures = new ArrayList<>();
        pointList = new ArrayList<>();
        lineSegments = new ArrayList<>();
        figureName = SEGMENT;
        initializeRadioButtons();
        initializeCanvas();
        initializeButton();
        initializeColorPicker();
    }

    public void initializeColorPicker() {
        borderColorPicker.setValue(Color.BLACK);
        backgroundColorPicker.setValue(Color.WHITE);
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
        radioButtonRectangle.setToggleGroup(toggleGroup);
        radioButtonRectangle.setUserData(RECTANGLE);

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
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getWidth());
        AtomicReference<Point> point = new AtomicReference<>(new Point());

        canvas.setOnMousePressed(mouseEvent -> {
            Point startPoint = new Point((int) mouseEvent.getX(), (int) mouseEvent.getY());
            point.set(startPoint);
        });

        canvas.setOnMouseDragged(mouseEvent -> {
            Point endPoint = new Point((int) mouseEvent.getX(), (int) mouseEvent.getY());
            boolean endFigureFlag = mouseEvent.isControlDown();
            boolean moveFlag = mouseEvent.isAltDown();
            if (!moveFlag) {
                drawFigure(true, endFigureFlag, false, point.get(), endPoint);
            }
        });

        canvas.setOnMouseReleased(mouseEvent -> {
            Point endPoint = new Point((int) mouseEvent.getX(), (int) mouseEvent.getY());
            boolean endFigureFlag = mouseEvent.isControlDown();
            boolean moveFlag = mouseEvent.isAltDown();
            if (moveFlag) {
                drawFigure(true, false, true, point.get(), endPoint);
            } else {
                drawFigure(false, endFigureFlag, false, point.get(), endPoint);
            }
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

    public void dragRepaintAndSave(Figure figure, boolean dragFlag, boolean moveFlag) {
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        if (moveFlag) {
            figure.draw(graphicsContext);
        }
        for (Figure value : figures) {
            value.draw(graphicsContext);
        }
        if (!moveFlag) {
            figure.draw(graphicsContext);
        }
        if (!dragFlag) {
            figures.add(figure);
        }
    }

    public Figure moveFigure(Point startPoint, Point endPoint) {
        for (int i = figures.size() - 1; i >= 0; i--) {
            if (figures.get(i).contains(startPoint)) {
                figures.get(i).move(endPoint);
                return figures.get(i);
            }
        }
        return null;
    }

    public void drawFigure(Boolean dragFlag, Boolean endFigureFlag, Boolean moveFlag, Point startPoint, Point endPoint) {
        Color backgroundColor = backgroundColorPicker.getValue();
        Color borderColor = borderColorPicker.getValue();
        Figure figure;
        if (moveFlag) {
            Figure fig = moveFigure(startPoint, endPoint);
            if (fig != null)
                dragRepaintAndSave(fig, true, true);
        } else {
            switch (figureName) {
                case SEGMENT: {
                    figure = new LineSegment(borderColor, startPoint, endPoint);
                    dragRepaintAndSave(figure, dragFlag, false);
                    break;
                }
                case RAY: {
                    figure = new Ray(borderColor, startPoint, endPoint);
                    dragRepaintAndSave(figure, dragFlag, false);
                    break;
                }
                case LINE: {
                    figure = new Line(borderColor, startPoint, endPoint);
                    dragRepaintAndSave(figure, dragFlag, false);
                    break;
                }
                case REGULAR_SHAPE: {
                    figure = new RegularPolygon(borderColor, startPoint, endPoint, backgroundColor, n);
                    dragRepaintAndSave(figure, dragFlag, false);
                    break;
                }
                case CIRCLE: {
                    figure = new Circle(borderColor, startPoint, backgroundColor, endPoint);
                    dragRepaintAndSave(figure, dragFlag, false);
                    break;
                }
                case ELLIPSE: {
                    figure = new Ellipse(borderColor, startPoint, backgroundColor, endPoint);
                    dragRepaintAndSave(figure, dragFlag, false);
                    break;
                }
                case RHOMBUS: {
                    figure = new Rhombus(borderColor, startPoint, backgroundColor, endPoint);
                    dragRepaintAndSave(figure, dragFlag, false);
                    break;
                }
                case TRIANGLE: {
                    Triangle triangle = new Triangle(borderColor, startPoint, backgroundColor, endPoint);
                    dragRepaintAndSave(triangle, dragFlag, false);
                    break;
                }
                case RECTANGLE: {
                    figure = new Rectangle(borderColor, startPoint, backgroundColor, endPoint);
                    dragRepaintAndSave(figure, dragFlag, false);
                    break;
                }
                case POLYLINE: {
                    LineSegment lineSegment;
                    if (lineSegments.isEmpty()) {
                        figure = new PolyLine(borderColor, startPoint, lineSegments);
                        lineSegment = new LineSegment(borderColor, startPoint, endPoint);
                    } else {
                        figure = new PolyLine(borderColor, lineSegments.get(0).getCenter()
                                , lineSegments);
                        lineSegment = new LineSegment(borderColor,
                                lineSegments.get(lineSegments.size() - 1).getEndPoint()
                                , endPoint);
                    }
                    lineSegments.add(lineSegment);
                    ((PolyLine) figure).setLineSegments(cloneLineSegments());
                    dragRepaintAndSave(figure, true, false);
                    if (endFigureFlag) {
                        dragRepaintAndSave(figure, dragFlag, false);
                        lineSegments.clear();
                    }
                    break;
                }
                case ASYMMETRIC_SHAPE: {
                    Point point = new Point(endPoint);
                    if (pointList.isEmpty()) {
                        figure = new Polygon(borderColor, startPoint, backgroundColor);
                    } else {
                        figure = new Polygon(borderColor, pointList.get(0), backgroundColor);
                    }
                    pointList.add(point);
                    ((Polygon) figure).setPoints(clonePoints());
                    dragRepaintAndSave(figure, true, false);
                    if (endFigureFlag) {
                        dragRepaintAndSave(figure, dragFlag, false);
                        pointList.clear();
                    }
                    break;
                }
            }
        }
    }


    public ArrayList<LineSegment> cloneLineSegments() {
        ArrayList<LineSegment> clone = new ArrayList<>();
        for (LineSegment lineSegment : lineSegments) {
            Point center = new Point((int) lineSegment.getCenter().getX(), (int) lineSegment.getCenter().getY());
            Point endPoint = new Point((int) lineSegment.getEndPoint().getX(), (int) lineSegment.getEndPoint().getY());
            clone.add(new LineSegment(lineSegment.getBorderColor(), center, endPoint));
        }
        return clone;
    }

    public ArrayList<Point> clonePoints() {
        ArrayList<Point> clone = new ArrayList<>();
        for (Point point : pointList) {
            Point clonePoint = new Point((int) point.getX(), (int) point.getY());
            clone.add(clonePoint);
        }
        return clone;
    }
}