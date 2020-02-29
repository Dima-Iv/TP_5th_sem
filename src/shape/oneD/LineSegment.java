package shape.oneD;

import shape.base.Figure;

import java.awt.*;

/**
 * @author Dima
 * @version 1.0
 * @created 28-���-2020 18:39:58
 */
public class LineSegment extends Figure {
    private Point endPoint;

    public LineSegment() {

    }

    public LineSegment(Color borderColor, Point center, Point endPoint) {
        super(borderColor, center);
        this.endPoint = endPoint;
    }

    /**
     * @param value
     */
    @Override
    public void move(Point value) {

    }

    @Override
    public void draw(Graphics2D graphics2D) {

    }

    @Override
    public Point location() {
        return null;
    }
}