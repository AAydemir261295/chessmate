package ChessItems.BlackFigures;

import ChessItems.Items.Cells;
import Engine.HasDirection;
import Engine.ToCoordinateParser;

import java.io.Serializable;

public class BlackCell extends Cells implements Serializable {

    private int x;
    private int y;
    private String cellColor;
    String figure;

    public BlackCell() {
    }

    public BlackCell(int x, int y, String cellColor, String figure) {
        super(x, y, cellColor, figure);
        this.x = x;
        this.y = y;
        this.cellColor = cellColor;
        this.figure = figure;
    }

    @Override
    public int move(ToCoordinateParser before, ToCoordinateParser after) {
        return -1;
    }

    @Override
    public HasDirection getDirection() {
        return null;
    }

    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }
}
