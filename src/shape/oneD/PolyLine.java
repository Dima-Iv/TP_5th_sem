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
        lineSegments.get(0).move(value);
        for (int i = 1; i < lineSegments.size(); i++) {
            lineSegments.get(i).move(lineSegments.get(i - 1).getEndPoint());
        }
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
        return lineSegments.get(0).getCenter();
    }

    @Override
    public boolean contains(Point value) {
        for (LineSegment linesegment : lineSegments) {
            if (linesegment.contains(value)) {
                return true;
            }
        }
        return false;
    }
}