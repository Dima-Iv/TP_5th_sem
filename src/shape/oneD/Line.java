package shape.oneD;

import javafx.scene.canvas.GraphicsContext;

import java.awt.*;

/**
 * @author Dima
 * @version 1.0
 * @created 28-���-2020 18:39:58
 */
public class Line extends Ray {

    public Line() {

    }

    public Line(Color borderColor, Point center, Point endPoint) {
        super(borderColor, center, endPoint);
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