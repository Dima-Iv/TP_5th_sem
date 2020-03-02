package shape.polygon;

import javafx.scene.paint.Color;
import shape.interfaces.Methods;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dima
 * @version 1.0
 * @created 28-���-2020 18:39:58
 */
public class RegularPolygon extends Polygon implements Methods {

    public RegularPolygon() {

    }

    public RegularPolygon(Color borderColor, Point center, Point endPoint, Color bgColor, int pointCount) {
        super(borderColor, center, bgColor);
        setPolygonPoints(center, endPoint, pointCount);
    }

    public Point location() {
        return getCenter();
    }

    private void setPolygonPoints(Point center, Point endPoint, int pointCount) {
        List<Point> points = new ArrayList<>(pointCount + 1);
        double radius = Math.sqrt(Math.pow((endPoint.x) - center.x, 2) + Math.pow(endPoint.y - center.y, 2));
        double z;
        double angle = 360.0 / pointCount;
            if (pointCount % 2 != 0)
                z = 90;
            else
                z = 90 - angle / 2;
        for (int i = 0; i < pointCount; i++) {
            points.add(new Point(center.x + (int) (Math.cos(z / 180 * Math.PI) * radius),
                    center.y - (int) (Math.sin(z / 180 * Math.PI) * radius)));
            z = z + angle;
        }
        setPoints(points);
    }
}