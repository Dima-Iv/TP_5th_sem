package shape.polygon;

import javafx.scene.paint.Color;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dima
 * @version 1.0
 * @created 28-���-2020 18:39:59
 */
public class Triangle extends Polygon {

    public Triangle(Color borderColor, Point center, Color bgColor, Point endPoint) {
        super(borderColor, center, bgColor);
        List<Point> pointList = new ArrayList<>(3);
        pointList.add(new Point((endPoint.x - center.x) / 2 + center.x, center.y));
        pointList.add(new Point(center.x, endPoint.y));
        pointList.add(new Point(endPoint.x, endPoint.y));
        setPoints(pointList);
    }
}