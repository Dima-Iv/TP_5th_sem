package shape.oneD;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shape.base.Figure;

import java.awt.*;

/**
 * @author Dima
 * @version 1.0
 * @created 28-���-2020 18:39:58
 */
public class PolyLine extends Figure {

    public LineSegment[] lineSegments;

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
     * @param graphicsContext
     */
    @Override
    public void draw(GraphicsContext graphicsContext) {

    }

    @Override
    public Point location() {
        return null;
    }
}