package shape.base;

import javafx.scene.paint.Color;
import shape.interfaces.Methods;

import java.awt.*;

/**
 * @author Dima
 * @version 1.0
 * @created 28-фев-2020 18:39:58
 */
public abstract class Figure implements Methods {

    private Color borderColor;
    private Point center;

    public Figure(Color borderColor) {
        this.borderColor = borderColor;
    }

    public Figure(Color borderColor, Point center) {
        this.borderColor = borderColor;
        this.center = center;
    }

    public Point getCenter() {
        return center;
    }

    /**
     * @param value
     */
    public void setCenter(Point value) {
        center = value;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    /**
     * @param value
     */
    public void setBorderColor(Color value) {
        borderColor = value;
    }

}