package shape.polygon;

import javafx.scene.canvas.GraphicsContext;
import shape.base.TwoDFigure;
import shape.interfaces.Methods;

import java.awt.*;

/**
 * @author Dima
 * @version 1.0
 * @created 28-���-2020 18:39:58
 */
public class RegularPolygon extends TwoDFigure implements Methods {

    private int pointCount;

    public RegularPolygon() {

    }

    public RegularPolygon(Color borderColor, Point center, Color bgColor, int pointCount) {
        super(borderColor, center, bgColor);
        this.pointCount = pointCount;
    }

    public int getPointCount() {
        return pointCount;
    }

    /**
     * @param pointCount
     */
    public void setPointCount(int pointCount) {
        this.pointCount = pointCount;
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