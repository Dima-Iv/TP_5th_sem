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
        Point prevCenter = getCenter();
        Point prevBorderPoint = getBorderPoint();
        int width = abs(prevBorderPoint.x - prevCenter.x);
        int height = abs(prevBorderPoint.y - prevCenter.y);
        Point newBorderPoint = new Point(value.x + width, value.y + height);
        setCenter(value);
        setBorderPoint(newBorderPoint);
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

    @Override
    public boolean contains(Point value) {
        Point center = getCenter();
        int width = 2 * abs(borderPoint.x - center.x);
        int height = 2 * abs(borderPoint.y - center.y);
        double alpha = (double) (value.x - center.x) / width;
        double beta = (double) (value.y - center.y) / height;
        return 4 * (alpha * alpha + beta * beta) < 1;
    }
}