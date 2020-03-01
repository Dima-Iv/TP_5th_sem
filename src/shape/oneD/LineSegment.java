package shape.oneD;

import javafx.scene.canvas.GraphicsContext;
import shape.base.Figure;
import shape.interfaces.Methods;

import java.awt.*;

/**
 * @author Dima
 * @version 1.0
 * @created 28-���-2020 18:39:58
 */
public class LineSegment extends Figure implements Methods {
    private Point endPoint;

    public LineSegment() {

    }

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