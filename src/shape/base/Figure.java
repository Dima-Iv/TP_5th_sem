package shape.base;

import java.awt.*;

/**
 * @author Dima
 * @version 1.0
 * @created 28-фев-2020 18:39:58
 */
public abstract class Figure {

    private Color borderColor = Color.BLACK;
    private Point center;

    public Figure() {

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