package shape.oneD;

import java.awt.*;

/**
 * @author Dima
 * @version 1.0
 * @created 28-���-2020 18:39:58
 */
public class Ray extends LineSegment {

    public Ray() {

    }

    public Ray(Color borderColor, Point center, Point endPoint) {
        super(borderColor, center, endPoint);
    }

    /**
     * @param value
     */
    @Override
    public void move(Point value) {
        super.move(value);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        super.draw(graphics2D);
    }

    @Override
    public Point location() {
        return super.location();
    }

}