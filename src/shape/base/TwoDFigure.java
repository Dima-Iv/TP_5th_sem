package shape.base;

import javafx.scene.paint.Color;

import java.awt.*;

/**
 * @author Dima
 * @version 1.0
 * @created 28-���-2020 18:39:59
 */
public abstract class TwoDFigure extends Figure {

    private javafx.scene.paint.Color bgColor;

    public TwoDFigure() {

    }

    public TwoDFigure(javafx.scene.paint.Color borderColor, Point center, javafx.scene.paint.Color bgColor) {
        super(borderColor, center);
        this.bgColor = bgColor;
    }

    public javafx.scene.paint.Paint getBGColor() {
        return bgColor;
    }

    /**
     * @param value
     */
    public void setBGColor(Color value) {
        bgColor = value;
    }

}