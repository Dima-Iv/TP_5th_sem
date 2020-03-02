package shape.polygon;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.List;

/**
 * @author Dima
 * @version 1.0
 * @created 28-���-2020 18:39:59
 */
public class Triangle extends Polygon {

    public Triangle() {

    }

    public Triangle(Color borderColor, Point center, Color bgColor, List<Point> points) {
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