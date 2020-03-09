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
    private int pointCounter = 0;
    private int lineSegmentCounter = 0;
    private List<Figure> figures;
    private List<List<Point>> pointList;
    private List<List<LineSegment>> lineSegments;
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
        for (int i = 0; i < 100; i++) {
            pointList.add(new ArrayList<>());
        }
        lineSegments = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            lineSegments.add(new ArrayList<>());
        }
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

    public void repaint() {
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (Figure value : figures) {
            value.draw(graphicsContext);
        }
    }

    public void dragRepaint(Figure figure) {
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (Figure value : figures) {
            value.draw(graphicsContext);
        }
        figure.draw(graphicsContext);
    }

    public void moveFigure(Point startPoint, Point endPoint) {
        for (int i = figures.size() - 1; i >= 0; i--) {
            if (figures.get(i).contains(startPoint)) {
                figures.get(i).move(endPoint);
                break;
            }
        }
    }

    public void drawFigure(Boolean dragFlag, Boolean endFigureFlag, Boolean moveFlag, Point startPoint, Point endPoint) {
        Color backgroundColor = backgroundColorPicker.getValue();
        Color borderColor = borderColorPicker.getValue();
        switch (figureName) {
            case SEGMENT: {
                if (moveFlag) {
                    moveFigure(startPoint, endPoint);
                    repaint();
                } else {
                    LineSegment lineSegment = new LineSegment(borderColor, startPoint, endPoint);
                    dragRepaint(lineSegment);
                    if (!dragFlag) {
                        figures.add(lineSegment);
                    }
                }
                break;
            }
            case RAY: {
                if (moveFlag) {
                    moveFigure(startPoint, endPoint);
                    repaint();
                } else {
                    Ray ray = new Ray(borderColor, startPoint, endPoint);
                    dragRepaint(ray);
                    if (!dragFlag) {
                        figures.add(ray);
                    }
                }
                break;
            }
            case LINE: {
                if (moveFlag) {
                    moveFigure(startPoint, endPoint);
                    repaint();
                } else {
                    Line line = new Line(borderColor, startPoint, endPoint);
                    dragRepaint(line);
                    if (!dragFlag) {
                        figures.add(line);
                    }
                }
                break;
            }
            case POLYLINE: {
                if (moveFlag) {
                    moveFigure(startPoint, endPoint);
                    repaint();
                } else {
                    PolyLine polyLine;
                    LineSegment lineSegment;
                    if (lineSegments.get(lineSegmentCounter).isEmpty()) {
                        polyLine = new PolyLine(borderColor, startPoint, lineSegments.get(lineSegmentCounter));
                        lineSegment = new LineSegment(borderColor, startPoint, endPoint);
                    } else {
                        polyLine = new PolyLine(borderColor, lineSegments.get(lineSegmentCounter).get(0).getCenter()
                                , lineSegments.get(lineSegmentCounter));
                        lineSegment = new LineSegment(borderColor,
                                lineSegments.get(lineSegmentCounter).get(lineSegments.get(lineSegmentCounter).size() - 1).getEndPoint()
                                , endPoint);
                    }
                    lineSegments.get(lineSegmentCounter).add(lineSegment);
                    polyLine.setLineSegments(lineSegments.get(lineSegmentCounter));
                    dragRepaint(polyLine);
                    if (!dragFlag && endFigureFlag) {
                        figures.add(polyLine);
                        lineSegmentCounter++;
                    }
                }
                break;
            }
            case ASYMMETRIC_SHAPE: {
                if (moveFlag) {
                    moveFigure(startPoint, endPoint);
                    repaint();
                } else {
                    Polygon polygon;
                    Point point = new Point(endPoint);
                    if (pointList.get(pointCounter).isEmpty()) {
                        polygon = new Polygon(borderColor, startPoint, backgroundColor);

                    } else {
                        polygon = new Polygon(borderColor, pointList.get(pointCounter).get(0), backgroundColor);
                    }
                    pointList.get(pointCounter).add(point);
                    polygon.setPoints(pointList.get(pointCounter));
                    dragRepaint(polygon);
                    if (!dragFlag && endFigureFlag) {
                        figures.add(polygon);
                        pointCounter++;
                    }
                }
                break;
            }
            case REGULAR_SHAPE: {
                if (moveFlag) {
                    moveFigure(startPoint, endPoint);
                    repaint();
                } else {
                    RegularPolygon regularPolygon = new RegularPolygon(borderColor, startPoint, endPoint, backgroundColor, n);
                    dragRepaint(regularPolygon);
                    if (!dragFlag) {
                        figures.add(regularPolygon);
                    }
                }
                break;
            }
            case CIRCLE: {
                if (moveFlag) {
                    moveFigure(startPoint, endPoint);
                    repaint();
                } else {
                    Circle circle = new Circle(borderColor, startPoint, backgroundColor, endPoint);
                    dragRepaint(circle);
                    if (!dragFlag) {
                        figures.add(circle);
                    }
                }
                break;
            }
            case ELLIPSE: {
                if (moveFlag) {
                    moveFigure(startPoint, endPoint);
                    repaint();
                } else {
                    Ellipse ellipse = new Ellipse(borderColor, startPoint, backgroundColor, endPoint);
                    dragRepaint(ellipse);
                    if (!dragFlag) {
                        figures.add(ellipse);
                    }
                }
                break;
            }
            case RHOMBUS: {
                if (moveFlag) {
                    moveFigure(startPoint, endPoint);
                    repaint();
                } else {
                    Rhombus rhombus = new Rhombus(borderColor, startPoint, backgroundColor, endPoint);
                    dragRepaint(rhombus);
                    if (!dragFlag) {
                        figures.add(rhombus);
                    }
                }
                break;
            }
            case TRIANGLE: {
                if (moveFlag) {
                    moveFigure(startPoint, endPoint);
                    repaint();
                } else {
                    Triangle triangle = new Triangle(borderColor, startPoint, backgroundColor, endPoint);
                    dragRepaint(triangle);
                    if (!dragFlag) {
                        figures.add(triangle);
                    }
                }
                break;
            }
            case RECTANGLE: {
                if (moveFlag) {
                    moveFigure(startPoint, endPoint);
                    repaint();
                } else {
                    Rectangle rectangle = new Rectangle(borderColor, startPoint, backgroundColor, endPoint);
                    dragRepaint(rectangle);
                    if (!dragFlag) {
                        figures.add(rectangle);
                    }
                }
                break;
            }
        }
    }
}