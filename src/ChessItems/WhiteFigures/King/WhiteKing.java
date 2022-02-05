package ChessItems.WhiteFigures.King;


import ChessItems.Items.Board;
import ChessItems.WhiteFigures.WhiteFigure;
import ChessItems.WhiteFigures.WhiteFigures;
import Engine.*;

import java.io.Serializable;

public class WhiteKing extends WhiteFigure implements Serializable {

    private int x;
    private int y;
    private String cellColor;
    private String figure;

    private int moveCounter = 0;

    public WhiteKing() {
    }

    public WhiteKing(int x, int y, String cellColor, String figure, int moveCounter) {
        super(x, y, cellColor, figure, moveCounter);
        this.x = x;
        this.y = y;
        this.cellColor = cellColor;
        this.figure = figure;
        this.moveCounter = moveCounter;
    }

    @Override
    public int move(ToCoordinateParser figurePosition, ToCoordinateParser moveCoordinate) {
        LineIsEmptyWhiteKing lineIsEmptyWhiteKing = new LineIsEmptyWhiteKing();
        int resultOfMove = lineIsEmptyWhiteKing.checkDirection(figurePosition, moveCoordinate);

        if (itNormalMove(resultOfMove)) {
            CellDrawer temp = new CellDrawer();
            temp.drawCell(figurePosition);
            moveFigure(moveCoordinate);
            return 1;
        } else if (itCastlingMove(resultOfMove)) {
            WKingCastling kingCastling = new WKingCastling();
            kingCastling.castleFigures(figurePosition, moveCoordinate);
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
        return new LineIsEmptyWhiteKing();
    }

    private boolean itNormalMove(int a) {
        return a == 1;
    }

    private boolean itCastlingMove(int a) {
        return a == 2;
    }

    private void moveFigure(ToCoordinateParser moveCoordinate) {
        Board board = new Board();
        String cellColor = getCellColor(moveCoordinate);
        int index = board.getIndexOfCoordinate(moveCoordinate);
        int x = board.getBoard().get(index).getX();
        int y = board.getBoard().get(index).getY();

        board.getBoard().add(index, new WhiteKing(x, y, cellColor, WhiteFigures.KING.getFigure(), ++moveCounter));
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