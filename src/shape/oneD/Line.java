package shape.oneD;

import javafx.scene.paint.Color;

import java.awt.*;

/**
 * @author Dima
 * @version 1.0
 * @created 28-���-2020 18:39:58
 */
public class Line extends Ray {
    public Line(Color borderColor, Point center, Point endPoint) {
        super(borderColor, center, endPoint);
        double deltaX = endPoint.x - center.x;
        double deltaY = endPoint.y - center.y;
        if (Math.abs(deltaX) < Math.abs(deltaY)) {
            double heightE;
            double heightS;
            if (deltaY < 0) {
                heightE = -1;
                heightS = Toolkit.getDefaultToolkit().getScreenSize().getHeight() + 1;
            } else {
                heightE = Toolkit.getDefaultToolkit().getScreenSize().getHeight() + 1;
                heightS = -1;
            }
            setEndPoint(new Point((int)(deltaX / deltaY * (heightE - center.y) + center.x), (int)heightE));
            setCenter(new Point((int)(deltaX / deltaY * (heightS - center.y) + center.x), (int)heightS));
        } else {
            double widthE;
            double widthS;
            if (deltaX < 0){
                widthE = -1;
                widthS = Toolkit.getDefaultToolkit().getScreenSize().getWidth() + 1;
            } else {
                widthE = Toolkit.getDefaultToolkit().getScreenSize().getWidth() + 1;
                widthS = -1;
            }
            setEndPoint(new Point((int)widthE, (int)(deltaY / deltaX * (widthE - center.x) + center.y)));
            setCenter(new Point((int)widthS, (int)(deltaY / deltaX * (widthS - center.x) + center.y)));
        }
    }
}