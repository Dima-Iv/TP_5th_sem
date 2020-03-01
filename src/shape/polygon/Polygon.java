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
public class Polygon extends TwoDFigure implements Methods {

    private int nPoint;
    private Point[] points;

    public Polygon() {

    }

    public Polygon(Color borderColor, Point center, Color bgColor, Point[] points) {
        super(borderColor, center, bgColor);
        this.points = points;
    }

    public Point[] getPoints() {
        return points;
    }

    /**
     * @param points
     */
    public void setPoints(Point[] points) {
        this.points = points;
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

    @Override
    public Point getCenter() {
        return super.getCenter();
    }

    /**
     * @param value
     */
    @Override
    public void setCenter(Point value) {
        super.setCenter(value);
    }
}