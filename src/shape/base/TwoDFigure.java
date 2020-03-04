package shape.base;

import javafx.scene.paint.Color;

import java.awt.*;

/**
 * @author Dima
 * @version 1.0
 * @created 28-���-2020 18:39:59
 */
public abstract class TwoDFigure extends Figure {

    private Color bgColor;

    public TwoDFigure(Color borderColor, Point center, Color bgColor) {
        super(borderColor, center);
        this.bgColor = bgColor;
    }

    public TwoDFigure(Color borderColor, Color bgColor) {
        super(borderColor);
        this.bgColor = bgColor;
    }

    public Color getBGColor() {
        return bgColor;
    }

    /**
     * @param value
     */
    public void setBGColor(Color value) {
        bgColor = value;
    }

}