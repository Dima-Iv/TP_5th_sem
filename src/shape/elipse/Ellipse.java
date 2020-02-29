package shape.elipse;

import shape.base.TwoDFigure;
import shape.interfaces.Methods;

import java.awt.*;

/**
 * @author Dima
 * @version 1.0
 * @created 28-���-2020 18:39:58
 */
public class Ellipse extends TwoDFigure implements Methods {

    private Point circlePoint;

    public Ellipse() {

    }

    public Ellipse(Color borderColor, Point center, Color bgColor, Point circlePoint) {
        super(borderColor, center, bgColor);
        this.circlePoint = circlePoint;
    }

    public Point getCirclePoint() {
        return circlePoint;
    }

    /**
     * @param circlePoint
     */
    public void setCirclePoint(Point circlePoint) {
        this.circlePoint = circlePoint;
    }

    /**
     * @param value
     */
    @Override
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