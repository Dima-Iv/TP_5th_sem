package shape.polygon;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shape.base.TwoDFigure;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Dima
 * @version 1.0
 * @created 28-���-2020 18:39:58
 */
public class Polygon extends TwoDFigure {

    private List<Point> points;

    public Polygon(Color borderColor, Point center, Color bgColor) {
        super(borderColor, center, bgColor);
        points = new ArrayList<>();
    }

    public Polygon(Color borderColor, Point center, Color bgColor, List<Point> points) {
        super(borderColor, center, bgColor);
        this.points = points;
    }

    public Polygon(Color borderColor, Color bgColor, List<Point> points) {
        super(borderColor, bgColor);
        this.points = new ArrayList<>(points);
    }

    public List<Point> getPoints() {
        return points;
    }

    /**
     * @param points
     */
    public void setPoints(List<Point> points) {
        this.points = points;
    }

    /**
     * @param value
     */
    @Override
    public void move(Point value) {
        Point theCenter = location();
        int deltaX = value.x - theCenter.x;
        int deltaY = value.y - theCenter.y;
        points.forEach(point -> point.translate(deltaX, deltaY));
    }

    /**
     * @param graphicsContext
     */
    @Override
    public void draw(GraphicsContext graphicsContext) {
        int[] pointsX = points.stream().flatMapToInt(point -> IntStream.of(point.x)).toArray();
        int[] pointsY = points.stream().flatMapToInt(point -> IntStream.of(point.y)).toArray();
        graphicsContext.setStroke(getBorderColor());
        graphicsContext.strokePolygon(Arrays.stream(pointsX).asDoubleStream().toArray(),
                Arrays.stream(pointsY).asDoubleStream().toArray(), points.size());
        graphicsContext.setFill(getBGColor());
        graphicsContext.fillPolygon(Arrays.stream(pointsX).asDoubleStream().toArray(),
                Arrays.stream(pointsY).asDoubleStream().toArray(), points.size());
    }

    @Override
    public Point location() {
        Point centroid = new Point(0,0);
        double signedArea = 0.0;
        double x0; // Current vertex X
        double y0; // Current vertex Y
        double x1; // Next vertex X
        double y1; // Next vertex Y
        double a;  // Partial signed area

        for (int i = 0; i<points.size() - 1; ++i)
        {
            x0 = points.get(i).x;
            y0 = points.get(i).y;
            x1 = points.get(i+1).x;
            y1 = points.get(i+1).y;
            a = x0*y1 - x1*y0;
            signedArea += a;
            centroid.x += (x0 + x1)*a;
            centroid.y += (y0 + y1)*a;
        }

        x0 = points.get(points.size() - 1).x;
        y0 = points.get(points.size() - 1).y;
        x1 = points.get(0).x;
        y1 = points.get(0).y;
        a = x0*y1 - x1*y0;
        signedArea += a;
        centroid.x += (x0 + x1)*a;
        centroid.y += (y0 + y1)*a;

        signedArea *= 0.5;
        centroid.x /= (6.0*signedArea);
        centroid.y /= (6.0*signedArea);

        setCenter(centroid);

        return centroid;
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
}