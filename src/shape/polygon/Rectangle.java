package shape.polygon;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dima
 * @version 1.0
 * @created 28-���-2020 18:39:58
 */
public class Rectangle extends Polygon {

    public Rectangle() {

    }

    public Rectangle(Color borderColor, Point center, Color bgColor, Point endPoint) {
        super(borderColor, center, bgColor);
        List<Point> pointsList = new ArrayList<>();
        pointsList.add(center);
        pointsList.add(new Point(center.x, endPoint.y));
        pointsList.add(endPoint);
        pointsList.add(new Point(endPoint.x, center.y));
        setPoints(pointsList);
    }
}