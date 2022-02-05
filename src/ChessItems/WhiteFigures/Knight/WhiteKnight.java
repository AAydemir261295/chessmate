package ChessItems.WhiteFigures.Knight;


import ChessItems.Items.Board;
import ChessItems.WhiteFigures.WhiteFigure;
import ChessItems.WhiteFigures.WhiteFigures;
import Engine.CellColorFinder;
import Engine.CellDrawer;
import Engine.HasDirection;
import Engine.ToCoordinateParser;

import java.io.Serializable;

public class WhiteKnight extends WhiteFigure implements Serializable {

    private int x;
    private int y;
    private String cellColor;
    private String figure;

    public WhiteKnight() {
    }

    public WhiteKnight(int x, int y, String cellColor, String figure) {
        super(x, y, cellColor, figure);
        this.x = x;
        this.y = y;
        this.cellColor = cellColor;
        this.figure = figure;
    }

    @Override
    public int move(ToCoordinateParser figurePosition, ToCoordinateParser moveCoordinate) {
        if (moveIsCorrect(figurePosition, moveCoordinate)) {
            CellDrawer temp = new CellDrawer();
            temp.drawCell(figurePosition);
            moveFigure(moveCoordinate);
            return 1;
        }
        return -1;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public String getCellColor() {
        return cellColor;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void setCellColor(String cellColor) {
        this.cellColor = cellColor;
    }

    @Override
    public HasDirection getDirection() {
        return new LineIsEmptyWhiteKnight();
    }

    private boolean moveIsCorrect(ToCoordinateParser figurePosition, ToCoordinateParser moveCoordinate) {
        LineIsEmptyWhiteKnight knightDirection = new LineIsEmptyWhiteKnight();
        return knightDirection.checkDirection(figurePosition, moveCoordinate) == 1;
    }

    private void moveFigure(ToCoordinateParser moveCoordinate) {
        Board board = new Board();
        String cellColor = getCellColor(moveCoordinate);
        int index = board.getIndexOfCoordinate(moveCoordinate);
        int x = board.getBoard().get(index).getX();
        int y = board.getBoard().get(index).getY();

        board.getBoard().add(index, new WhiteKnight(x, y, cellColor, WhiteFigures.KNIGHT.getFigure()));
        board.getBoard().remove(index + 1);
    }

    private String getCellColor(ToCoordinateParser coord) {
        CellColorFinder saveCellColor = new CellColorFinder();
        return saveCellColor.getCellColor(coord);
    }

    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }
}
