package shape.elipse;

import java.awt.*;

/**
 * @author Dima
 * @version 1.0
 * @created 28-���-2020 18:39:58
 */
public class Circle extends Ellipse {

    public Circle() {

    }

    public Circle(Color borderColor, Point center, Color bgColor, Point circlePoint) {
        super(borderColor, center, bgColor, circlePoint);
    }

    /**
     * @param value
     */
    @Override
    public void move(Point value) {
        super.move(value);
    }

    /**
     * @param graphics2D
     */
    @Override
    public void draw(Graphics2D graphics2D) {
        super.draw(graphics2D);
    }

    @Override
    public Point location() {
        return super.location();
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

    @Override
    public Point getCirclePoint() {
        return super.getCirclePoint();
    }

    /**
     * @param circlePoint
     */
    @Override
    public void setCirclePoint(Point circlePoint) {
        super.setCirclePoint(circlePoint);
    }
}