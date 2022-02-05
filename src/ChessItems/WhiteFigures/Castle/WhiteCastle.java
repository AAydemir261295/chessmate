package ChessItems.WhiteFigures.Castle;

import ChessItems.Items.Board;
import ChessItems.WhiteFigures.WhiteFigures;
import Engine.CellColorFinder;
import Engine.CellDrawer;
import Engine.HasDirection;
import Engine.ToCoordinateParser;

import java.io.Serializable;

public class WhiteCastle extends W_Castle implements Serializable {

    private int x;
    private int y;
    private String cellColor;
    private String figure;

    private int moveCounter = 0;

    public WhiteCastle() {
    }

    public WhiteCastle(int x, int y, String cellColor, String figure, int moveCounter) {
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
        return new LineIsEmptyWhiteCastle();
    }

    private boolean moveIsCorrect(ToCoordinateParser figurePosition, ToCoordinateParser moveCoordinate) {
        LineIsEmptyWhiteCastle castleDirection = new LineIsEmptyWhiteCastle();
        return castleDirection.checkDirection(figurePosition, moveCoordinate) == 1;
    }

    public String getFigure() {
        return figure;
    }

    public int getMoveCounter() {
        return moveCounter;
    }

    private void moveFigure(ToCoordinateParser moveCoordinate) {
        Board board = new Board();
        String cellColor = getCellColor(moveCoordinate);
        int index = board.getIndexOfCoordinate(moveCoordinate);
        int x = board.getBoard().get(index).getX();
        int y = board.getBoard().get(index).getY();

        board.getBoard().add(index, new WhiteCastle(x, y, cellColor, WhiteFigures.CASTLE.getFigure(), ++moveCounter));
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

