package shape.oneD;

import javafx.scene.paint.Color;

import java.awt.*;

/**
 * @author Dima
 * @version 1.0
 * @created 28-���-2020 18:39:58
 */
public class Ray extends LineSegment {
    public Ray(Color borderColor, Point center, Point endPoint) {
        super(borderColor, center, endPoint);
        double deltaX = endPoint.x - center.x;
        double deltaY = endPoint.y - center.y;
        if (Math.abs(deltaX) < Math.abs(deltaY)) {
            double height;
            if (deltaY < 0)
                height = -1;
            else
                height = Toolkit.getDefaultToolkit().getScreenSize().getHeight() + 1;
            setEndPoint(new Point((int)(deltaX / deltaY * (height - center.y) + center.x), (int)height));
        } else {
            double width;
            if (deltaX < 0)
                width = -1;
            else
                width = Toolkit.getDefaultToolkit().getScreenSize().getWidth() + 1;
            setEndPoint(new Point((int)width, (int)(deltaY / deltaX * (width - center.x) + center.y)));
        }
    }
}