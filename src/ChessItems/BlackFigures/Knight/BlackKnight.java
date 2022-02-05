package ChessItems.BlackFigures.Knight;

import ChessItems.BlackFigures.BlackFigure;
import ChessItems.BlackFigures.BlackFigures;
import ChessItems.Items.Board;
import Engine.CellColorFinder;
import Engine.CellDrawer;
import Engine.HasDirection;
import Engine.ToCoordinateParser;

import java.io.Serializable;

public class BlackKnight extends BlackFigure implements Serializable {

    private int x;
    private int y;
    private String cellColor;
    private String figure;

    public BlackKnight() {
    }

    public BlackKnight(int x, int y, String cellColor, String figure) {
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
        return new LineIsEmptyBlackKnight();
    }

    public String getFigure() {
        return figure;
    }

    private boolean moveIsCorrect(ToCoordinateParser figurePosition, ToCoordinateParser moveCoordinate) {
        LineIsEmptyBlackKnight knightDirection = new LineIsEmptyBlackKnight();
        return knightDirection.checkDirection(figurePosition, moveCoordinate) == 1;
    }

    private void moveFigure(ToCoordinateParser moveCoordinate) {
        Board board = new Board();
        String cellColor = getCellColor(moveCoordinate);
        int index = board.getIndexOfCoordinate(moveCoordinate);
        int x = board.getBoard().get(index).getX();
        int y = board.getBoard().get(index).getY();

        board.getBoard().add(index, new BlackKnight(x, y, cellColor, BlackFigures.KNIGHT.getFigure()));
        board.getBoard().remove(index + 1);
    }

    private String getCellColor(ToCoordinateParser coord) {
        CellColorFinder saveCellColor = new CellColorFinder();
        return saveCellColor.getCellColor(coord);
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }
}
