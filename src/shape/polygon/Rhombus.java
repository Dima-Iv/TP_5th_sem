package shape.polygon;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dima
 * @version 1.0
 * @created 28-���-2020 18:39:59
 */
public class Rhombus extends Polygon {

    public Rhombus() {

    }

    public Rhombus(Color borderColor, Point center, Color bgColor, Point endPoint) {
        super(borderColor, center, bgColor);
        List<Point> pointList = new ArrayList<>(4);
        pointList.add(new Point((endPoint.x - center.x) / 2 + center.x, center.y));
        pointList.add(new Point(center. x, (endPoint.y - center.y) / 2 + center.y));
        pointList.add(new Point((endPoint.x - center.x) / 2 + center.x, endPoint.y));
        pointList.add(new Point(endPoint.x, (endPoint.y - center.y) / 2 + center.y));
        setPoints(pointList);

    }

    /**
     * @param value
     */
    @Override
    public void move(Point value) {
        super.move(value);
    }

    /**
     * @param graphicsContext
     */
    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
    }

    @Override
    public Point location() {
        return super.location();
    }
}