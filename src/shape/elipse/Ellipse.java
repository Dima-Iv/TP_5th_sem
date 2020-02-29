package shape.elipse;

import shape.base.TwoDFigure;

import java.awt.*;

/**
 * @author Dima
 * @version 1.0
 * @created 28-���-2020 18:39:58
 */
public class Ellipse extends TwoDFigure {

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