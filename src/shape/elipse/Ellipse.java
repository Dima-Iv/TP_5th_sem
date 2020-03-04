package shape.elipse;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shape.base.TwoDFigure;

import java.awt.*;

import static java.lang.Math.abs;

/**
 * @author Dima
 * @version 1.0
 * @created 28-���-2020 18:39:58
 */
public class Ellipse extends TwoDFigure {

    private Point borderPoint;

    public Ellipse(Color borderColor, Point center, Color bgColor, Point borderPoint) {
        super(borderColor, center, bgColor);
        this.borderPoint = borderPoint;
    }

    public Point getBorderPoint() {
        return borderPoint;
    }

    /**
     * @param borderPoint
     */
    public void setBorderPoint(Point borderPoint) {
        this.borderPoint = borderPoint;
    }

    /**
     * @param value
     */
    @Override
    public void move(Point value) {
        Point topCornerPoint = getCenter();
        int centerPointX = (topCornerPoint.x + borderPoint.x) / 2;
        int centerPointY = (topCornerPoint.y + borderPoint.y) / 2;
        borderPoint.translate(value.x - centerPointX, value.y - centerPointY);
        setCenter(value);
    }

    /**
     * @param graphicsContext
     */
    @Override
    public void draw(GraphicsContext graphicsContext) {
        Point borderPoint = getBorderPoint();
        Point centerPoint = getCenter();
        int width = abs(borderPoint.x - centerPoint.x);
        int height = abs(borderPoint.y - centerPoint.y);
        int topCornerPointX = centerPoint.x - width;
        int topCornerPointY = centerPoint.y - height;
        graphicsContext.setStroke(getBorderColor());
        graphicsContext.strokeOval(topCornerPointX, topCornerPointY, 2 * width, 2 * height);
        graphicsContext.setFill(getBGColor());
        graphicsContext.fillOval(topCornerPointX, topCornerPointY, 2 * width, 2 * height);
    }

    @Override
    public Point location() {
        return getCenter();
    }
}