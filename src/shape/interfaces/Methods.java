package shape.interfaces;

import javafx.scene.canvas.GraphicsContext;

import java.awt.*;

public interface Methods {
    /**
     * @param value
     */
    void move(Point value);

    /**
     * @param graphicsContext
     */
    void draw(GraphicsContext graphicsContext);

    Point location();
}
