package ChessItems.Items;

import Engine.Directions.Diagonal.DiagonalDirection;
import Engine.Directions.Straight.StraightDirection;
import Engine.HasDirection;
import Engine.Moveable;

import java.io.Serializable;

public abstract class ChessItem implements Moveable, Serializable {

    private int x;
    private int y;
    private String cellColor;
    private String figure;
    private int moveCounter;

    public ChessItem() {
    }

    public ChessItem(int x, int y, String cellColor, String figure) {
        this.x = x;
        this.y = y;
        this.cellColor = cellColor;
        this.figure = figure;
    }

    public ChessItem(int x, int y, String cellColor, String figure, int moveCounter) {
        this.x = x;
        this.y = y;
        this.cellColor = cellColor;
        this.figure = figure;
        this.moveCounter = moveCounter;
    }

    public String getFigure() {
        return figure;
    }

    public String getCellColor() {
        return cellColor;
    }

    public void setCellColor(String cellColor) {
        this.cellColor = cellColor;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public abstract HasDirection getDirection();

    public DiagonalDirection getDiagonal() {
        return new DiagonalDirection();
    }

    public StraightDirection getStraight() {
        return new StraightDirection();
    }

}
