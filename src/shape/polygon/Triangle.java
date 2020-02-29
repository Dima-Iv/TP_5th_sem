package shape.polygon;

import java.awt.*;

/**
 * @author Dima
 * @version 1.0
 * @created 28-���-2020 18:39:59
 */
public class Triangle extends Polygon {

    public Triangle() {

    }

    public Triangle(Color borderColor, Point center, Color bgColor, Point[] points) {
        super(borderColor, center, bgColor, points);
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
}