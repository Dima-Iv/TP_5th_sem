package shape.elipse;

import javafx.scene.canvas.GraphicsContext;
import shape.base.TwoDFigure;
import shape.interfaces.Methods;

import java.awt.*;

import static java.lang.Math.abs;

/**
 * @author Dima
 * @version 1.0
 * @created 28-���-2020 18:39:58
 */
public class Ellipse extends TwoDFigure implements Methods {

    private Point borderPoint;

    public Ellipse() {

    }

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
        graphicsContext.setLineWidth(2);
        Point bottomCornerPoint = borderPoint;
        Point topCornerPoint = getCenter();
        int width = abs(bottomCornerPoint.x - topCornerPoint.x);
        int height = abs(bottomCornerPoint.y - topCornerPoint.y);
        graphicsContext.setStroke(javafx.scene.paint.Color.BLACK);
        graphicsContext.setFill(javafx.scene.paint.Color.WHITE);
        if(topCornerPoint.x > bottomCornerPoint.x && topCornerPoint.y > bottomCornerPoint.y) {
            graphicsContext.strokeOval(bottomCornerPoint.x, bottomCornerPoint.y, width, height);
            graphicsContext.fillOval(bottomCornerPoint.x, bottomCornerPoint.y, width, height);
        }
        if(topCornerPoint.x < bottomCornerPoint.x && topCornerPoint.y < bottomCornerPoint.y){
            graphicsContext.strokeOval(topCornerPoint.x, topCornerPoint.y, width, height);
            graphicsContext.fillOval(topCornerPoint.x, topCornerPoint.y, width, height);
        }
        if(topCornerPoint.x > bottomCornerPoint.x && topCornerPoint.y < bottomCornerPoint.y){
            graphicsContext.strokeOval(bottomCornerPoint.x, topCornerPoint.y, width, height);
            graphicsContext.fillOval(bottomCornerPoint.x, topCornerPoint.y, width, height);
        }
        if(topCornerPoint.x < bottomCornerPoint.x && topCornerPoint.y > bottomCornerPoint.y){
            graphicsContext.strokeOval(topCornerPoint.x, bottomCornerPoint.y, width, height);
            graphicsContext.fillOval(topCornerPoint.x, bottomCornerPoint.y, width, height);
        }
    }

    @Override
    public Point location() {
        return getCenter();
    }
}