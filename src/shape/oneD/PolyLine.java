package shape.oneD;

import shape.base.Figure;
import shape.interfaces.Methods;

import java.awt.*;

/**
 * @author Dima
 * @version 1.0
 * @created 28-���-2020 18:39:58
 */
public class PolyLine extends Figure implements Methods {

    public LineSegment[] lineSegments;

    public PolyLine() {

    }

    public PolyLine(Color borderColor, Point center, LineSegment[] lineSegments) {
        super(borderColor, center);
        this.lineSegments = lineSegments;
    }

    public LineSegment[] getLineSegments() {
        return lineSegments;
    }

    /**
     * @param values
     */
    public void setLineSegments(LineSegment[] values) {
        this.lineSegments = values;
    }

    /**
     * @param value
     */
    public void move(Point value) {

    }

    /**
     * @param graphics2D
     */
    @Override
    public void draw(Graphics2D graphics2D) {

    }

    @Override
    public Point location() {
        return null;
    }
}