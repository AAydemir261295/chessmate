package ChessItems.BlackFigures.Castle;

import ChessItems.BlackFigures.BlackFigures;
import ChessItems.Items.Board;
import Engine.CellColorFinder;
import Engine.CellDrawer;
import Engine.HasDirection;
import Engine.ToCoordinateParser;

import java.io.Serializable;

public class BlackCastle extends B_Castle implements Serializable {

    private int x;
    private int y;
    private String cellColor;
    private String figure = BlackFigures.CASTLE.getFigure();

    private int moveCounter = 0;

    public BlackCastle() {
    }

    public BlackCastle(int x, int y, String cellColor, String figure, int moveCounter) {
        super(x, y, cellColor, figure, moveCounter);
        this.x = x;
        this.y = y;
        this.cellColor = cellColor;
        this.figure = figure;
        this.moveCounter = moveCounter;
    }

    @Override
    public int move(ToCoordinateParser figurePosition, ToCoordinateParser moveCoordinate) {
        if (moveIsCorrect(figurePosition, moveCoordinate)) {
            CellDrawer tmp = new CellDrawer();
            tmp.drawCell(figurePosition);
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
        return new LineIsEmptyBlackCastle();
    }

    private boolean moveIsCorrect(ToCoordinateParser before, ToCoordinateParser after) {
        LineIsEmptyBlackCastle castleDirection = new LineIsEmptyBlackCastle();
        return castleDirection.checkDirection(before, after) == 1;
    }

    private void moveFigure(ToCoordinateParser moveCoordinate) {
        Board board = new Board();
        String cellColor = getCellColor(moveCoordinate);
        int index = board.getIndexOfCoordinate(moveCoordinate);
        int x = board.getBoard().get(index).getX();
        int y = board.getBoard().get(index).getY();

        board.getBoard().add(index, new BlackCastle(x, y, cellColor, BlackFigures.CASTLE.getFigure(), ++moveCounter));
        board.getBoard().remove(index + 1);
    }

    private String getCellColor(ToCoordinateParser coord) {
        CellColorFinder saveCellColor = new CellColorFinder();
        return saveCellColor.getCellColor(coord);
    }

    public String getFigure() {
        return figure;
    }

    public int getMoveCounter() {
        return moveCounter;
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }
}

