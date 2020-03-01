package shape.elipse;

import javafx.scene.canvas.GraphicsContext;

import java.awt.*;

import static java.lang.Math.abs;

/**
 * @author Dima
 * @version 1.0
 * @created 28-���-2020 18:39:58
 */
public class Circle extends Ellipse {

    public Circle() {

    }

    public Circle(Color borderColor, Point center, Color bgColor, Point circlePoint) {
        super(borderColor, center, bgColor, circlePoint);
    }

    /**
     * @param value
     */
    @Override
    public void move(Point value) {
        Point centerPoint = getCenter();
        Point borderPoint = getBorderPoint();
        borderPoint.translate(value.x - centerPoint.x, value.y - centerPoint.y);
        setCenter(value);
    }

    /**
     * @param graphicsContext
     */
    @Override
    public void draw(GraphicsContext graphicsContext) {
        Point borderPoint = getBorderPoint();
        Point centerPoint = getCenter();
        int width = 2 * (int)abs(borderPoint.distance(centerPoint));
        int topCornerPointX = centerPoint.x - width / 2;
        int topCornerPointY = centerPoint.y - width / 2;
        graphicsContext.setStroke(javafx.scene.paint.Color.BLACK);
        graphicsContext.strokeOval(topCornerPointX, topCornerPointY, width, width);
        graphicsContext.setFill(javafx.scene.paint.Color.WHITE);
        graphicsContext.fillOval(topCornerPointX, topCornerPointY, width, width);
    }

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