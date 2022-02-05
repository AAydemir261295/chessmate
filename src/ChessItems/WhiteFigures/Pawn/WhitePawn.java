package ChessItems.WhiteFigures.Pawn;

import ChessItems.Items.Board;
import ChessItems.WhiteFigures.WhiteFigures;
import Engine.CellColorFinder;
import Engine.CellDrawer;
import Engine.HasDirection;
import Engine.ToCoordinateParser;

import java.io.Serializable;

public class WhitePawn extends W_Pawn implements Serializable {

    private int x;
    private int y;
    private String cellColor;
    private String figure;

    public WhitePawn() {
    }

    public WhitePawn(int x, int y, String cellColor, String figure) {
        super(x, y, cellColor, figure);
        this.x = x;
        this.y = y;
        this.cellColor = cellColor;
        this.figure = figure;
    }

    @Override
    public int move(ToCoordinateParser figurePosition, ToCoordinateParser moveCoordinate) {
        if (normalMove(figurePosition, moveCoordinate)) {
            CellDrawer tmp = new CellDrawer();
            tmp.drawCell(figurePosition);
            moveFigure(moveCoordinate);
            return 1;
        } else if (swappingMove(figurePosition, moveCoordinate)) {
            swapIt(figurePosition, moveCoordinate);
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

    public void swapIt(ToCoordinateParser figurePositon, ToCoordinateParser swapPosition) {
        WhitePawnSwapper whitePawnSwapper = new WhitePawnSwapper();
        whitePawnSwapper.swapIt(figurePositon, swapPosition);
    }

    public boolean isItSwapTime(ToCoordinateParser movePosition) {
        return new WhitePawnSwapper().isItSwapTime(movePosition);
    }

    @Override
    public HasDirection getDirection() {
        return new LineIsEmptyWhitePawn();
    }

    private boolean normalMove(ToCoordinateParser figurePosition, ToCoordinateParser moveCoordinate) {
        LineIsEmptyWhitePawn pawnDirection = new LineIsEmptyWhitePawn();
        return pawnDirection.checkDirection(figurePosition, moveCoordinate) == 1;
    }

    private boolean swappingMove(ToCoordinateParser figurePosition, ToCoordinateParser movePosition) {
        LineIsEmptyWhitePawn pawnDirection = new LineIsEmptyWhitePawn();
        return pawnDirection.checkDirection(figurePosition, movePosition) == 2;
    }

    private void moveFigure(ToCoordinateParser moveCoordinate) {
        Board board = new Board();
        String cellColor = getCellColor(moveCoordinate);
        int index = board.getIndexOfCoordinate(moveCoordinate);
        int x = board.getBoard().get(index).getX();
        int y = board.getBoard().get(index).getY();

        board.getBoard().add(index, new WhitePawn(x, y, cellColor, WhiteFigures.PAWN.getFigure()));
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
