package shape.interfaces;

import java.awt.*;

public interface Methods {
    /**
     * @param value
     */
    void move(Point value);

    /**
     * @param graphics2D
     */
    void draw(Graphics2D graphics2D);

    Point location();
}
