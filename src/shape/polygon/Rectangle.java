package shape.polygon;

import javafx.scene.canvas.GraphicsContext;

import java.awt.*;

/**
 * @author Dima
 * @version 1.0
 * @created 28-���-2020 18:39:58
 */
public class Rectangle extends Polygon {

    public Rectangle() {

    }

    public Rectangle(Color borderColor, Point center, Color bgColor, Point[] points) {
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
     * @param graphicsContext
     */
    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
    }

    @Override
    public Point location() {
        return super.location();
    }

}