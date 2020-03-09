package shape.oneD;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shape.base.Figure;

import java.awt.*;
import java.util.List;

/**
 * @author Dima
 * @version 1.0
 * @created 28-���-2020 18:39:58
 */
public class PolyLine extends Figure {

    public List<LineSegment> lineSegments;

    public PolyLine(Color borderColor, Point center, List<LineSegment> lineSegments) {
        super(borderColor, center);
        this.lineSegments = lineSegments;
    }

    public List<LineSegment> getLineSegments() {
        return lineSegments;
    }

    /**
     * @param values
     */
    public void setLineSegments(List<LineSegment> values) {
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
        lineSegments.forEach(lineSegment -> lineSegment.draw(graphicsContext));
    }

    @Override
    public Point location() {
        return null;
    }

    @Override
    public boolean contains(Point value) {
        return false;
    }
}