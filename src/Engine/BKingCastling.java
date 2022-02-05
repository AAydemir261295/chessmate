package Engine;

import ChessItems.BlackFigures.BlackFigures;
import ChessItems.BlackFigures.Castle.BlackCastle;
import ChessItems.BlackFigures.King.BlackKing;
import ChessItems.Items.Board;
import ChessItems.WhiteFigures.Castle.WhiteCastle;
import ChessItems.WhiteFigures.King.WhiteKing;
import ChessItems.WhiteFigures.WhiteFigures;
import Engine.Directions.Straight.StraightDirection;

public class BKingCastling {

    // рокирует ладью и короля черных фигур
    // рокировка по левому направлению
    // рокировка по правому направлению
    public void castleFigures(ToCoordinateParser kingPosition, ToCoordinateParser castlePosition) {
        StraightDirection direction = new StraightDirection();

        if (direction.isLeftDirection(kingPosition, castlePosition)) {
            leftCastling(kingPosition, castlePosition);
        } else if (direction.isRightDirection(kingPosition, castlePosition)) {
            rightCastling(kingPosition, castlePosition);
        }
    }

    private void leftCastling(ToCoordinateParser kingPosition, ToCoordinateParser castlePosition) {
        Board board = new Board();
        int futureKingIndex = board.getIndexOfCoordinate(kingPosition) - 2;
        int futureCastleIndex = board.getIndexOfCoordinate(kingPosition) - 1;
        drawCellAndMoveFigures(kingPosition, castlePosition, futureKingIndex, futureCastleIndex);

    }

    private void rightCastling(ToCoordinateParser kingPosition, ToCoordinateParser castlePosition) {
        Board board = new Board();
        int futureKingIndex = board.getIndexOfCoordinate(castlePosition) - 1;
        int futureCastleIndex = board.getIndexOfCoordinate(kingPosition) + 1;
        drawCellAndMoveFigures(kingPosition, castlePosition, futureKingIndex, futureCastleIndex);
    }

    private void drawCellAndMoveFigures(ToCoordinateParser kingPosition, ToCoordinateParser castlePosition,
                                        int futureKingIndex, int futureCastleIndex) {
        drawCell(kingPosition);
        drawCell(castlePosition);
        moveForKing(futureKingIndex);
        moveForCastle(futureCastleIndex);
    }

    private void moveForKing(int futureKingIndex){
        Board board = new Board();
        ToCoordinateParser futureKingCoord = getFigureCoordinate(futureKingIndex);
        String cellColor = getCellColor(futureKingCoord);
        int x = getX(futureKingCoord);
        int y = getY(futureKingCoord);
        board.getBoard().add(futureKingIndex, new BlackKing(x, y, cellColor, BlackFigures.KING.getFigure(), 1));
        board.getBoard().remove(futureKingIndex + 1);
    }

    private void moveForCastle(int futureCastleIndex){
        Board board = new Board();
        ToCoordinateParser futureCastleCoord = getFigureCoordinate(futureCastleIndex);
        String cellColor = getCellColor(futureCastleCoord);
        int x = getX(futureCastleCoord);
        int y = getY(futureCastleCoord);
        board.getBoard().add(futureCastleIndex, new BlackCastle(x, y, cellColor, BlackFigures.CASTLE.getFigure(), 1));
        board.getBoard().remove(futureCastleIndex + 1);
    }

    private void drawCell(ToCoordinateParser figurePosition) {
        CellDrawer cellDrawer = new CellDrawer();
        cellDrawer.drawCell(figurePosition);
    }

    private String getCellColor(ToCoordinateParser coord) {
        CellColorFinder saveCellColor = new CellColorFinder();
        return saveCellColor.getCellColor(coord);
    }

    private ToCoordinateParser getFigureCoordinate(int index) {
        Board board = new Board();
        return new ToCoordinateParser(board.getCoordinate(index).getX(), board.getCoordinate(index).getY());
    }

    private int getX(ToCoordinateParser coord){
        return new Board().getItemFromCoordinate(coord).getX();
    }

    private int getY(ToCoordinateParser coord){
        return new Board().getItemFromCoordinate(coord).getY();
    }
}
