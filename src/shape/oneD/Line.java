package shape.oneD;

import javafx.scene.paint.Color;

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
}