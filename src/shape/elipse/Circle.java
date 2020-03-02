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

    public Circle() {

    }

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

    //**
    // * @param graphicsContext
    // */
    /*@Override
    public void draw(GraphicsContext graphicsContext) {
        Point borderPoint = getBorderPoint();
        Point centerPoint = getCenter();
        int width = 2 * (int)abs(borderPoint.distance(centerPoint));
        int topCornerPointX = centerPoint.x - width / 2;
        int topCornerPointY = centerPoint.y - width / 2;
        graphicsContext.setStroke(getBorderColor());
        graphicsContext.strokeOval(topCornerPointX, topCornerPointY, width, width);
        graphicsContext.setFill(getBGColor());
        graphicsContext.fillOval(topCornerPointX, topCornerPointY, width, width);
    }*/

    @Override
    public Point location() {
        return super.location();
    }

    @Override
    public Point getCenter() {
        return super.getCenter();
    }

    /**
     * @param value
     */
    @Override
    public void setCenter(Point value) {
        super.setCenter(value);
    }

    @Override
    public Point getBorderPoint() {
        return super.getBorderPoint();
    }

    /**
     * @param borderPoint
     */
    @Override
    public void setBorderPoint(Point borderPoint) {
        super.setBorderPoint(borderPoint);
    }
}