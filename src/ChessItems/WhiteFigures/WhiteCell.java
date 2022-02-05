package ChessItems.WhiteFigures;

import ChessItems.Items.Cells;
import Engine.HasDirection;
import Engine.ToCoordinateParser;

import java.io.Serializable;

public class WhiteCell extends Cells implements Serializable {

    private int x;
    private int y;
    private String cellColor;
    private String figure;

    public WhiteCell() {
    }

    public WhiteCell(int x, int y, String cellColor, String figure) {
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
}



