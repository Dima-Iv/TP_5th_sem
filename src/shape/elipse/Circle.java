package shape.elipse;

import javafx.scene.paint.Color;

import java.awt.*;

import static java.lang.Math.abs;
import static java.lang.Math.min;

/**
 * @author Dima
 * @version 1.0
 * @created 28-���-2020 18:39:58
 */
public class Circle extends Ellipse {

    public Circle(Color borderColor, Point center, Color bgColor, Point borderPoint) {
        super(borderColor, center, bgColor, borderPoint);
        int width = abs(borderPoint.x - center.x);
        int height = abs(borderPoint.y - center.y);
        int min = min(width, height);
        borderPoint.setLocation(center.x + min, center.y + min);
        this.setBorderColor(borderColor);
        this.setCenter(center);
        this.setBGColor(bgColor);
    }
}