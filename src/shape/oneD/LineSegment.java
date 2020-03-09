package shape.oneD;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shape.base.Figure;

import java.awt.*;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

/**
 * @author Dima
 * @version 1.0
 * @created 28-���-2020 18:39:58
 */
public class LineSegment extends Figure {
    private Point endPoint;

    public LineSegment(Color borderColor, Point center, Point endPoint) {
        super(borderColor, center);
        this.endPoint = endPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    /**
     * @param endPoint
     */
    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    /**
     * @param value
     */
    @Override
    public void move(Point value) {
        Point prevStartPoint = location();
        setCenter(value);
        setEndPoint(new Point(endPoint.x + value.x - prevStartPoint.x, endPoint.y + value.y - prevStartPoint.y));
    }

    /**
     * @param graphicsContext
     */
    @Override
    public void draw(GraphicsContext graphicsContext) {
        Point startPoint = getCenter();
        graphicsContext.setStroke(getBorderColor());
        graphicsContext.strokeLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
    }

    @Override
    public Point location() {
        return getCenter();
    }

    @Override
    public boolean contains(Point value) {
            Point theCenter = location();
            int a = endPoint.y - theCenter.y;
            int b = endPoint.x - theCenter.x;
            double d = (a * value.x - b * value.y + b * theCenter.y - a * theCenter.x) / (sqrt(a * a + b * b));
            return abs(d) < 1;
    }
}