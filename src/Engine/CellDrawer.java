package Engine;

import ChessItems.BlackFigures.BlackCell;
import ChessItems.BlackFigures.BlackFigures;
import ChessItems.Items.Board;
import ChessItems.WhiteFigures.WhiteCell;
import ChessItems.WhiteFigures.WhiteFigures;

public class CellDrawer {

    // рисует клетку по заданным координатам

    public void drawCell(ToCoordinateParser coordinate) {

        if (cellIsWhite(coordinate)) {
            drawWhiteCellOnCoord(coordinate);
        } else if (cellIsBlack(coordinate)) {
            drawBlackCellOnCoord(coordinate);
        }
    }

    private void drawBlackCellOnCoord(ToCoordinateParser coordinate) {
        Board board = new Board();
        int index = board.getIndexOfCoordinate(coordinate);
        int x = board.getBoard().get(index).getX();
        int y = board.getBoard().get(index).getY();

        board.getBoard().add(index, new BlackCell(x, y, "black", BlackFigures.CELL.getFigure()));
        board.getBoard().remove(index + 1);
    }

    private void drawWhiteCellOnCoord(ToCoordinateParser coordinate) {
        Board board = new Board();
        int index = board.getIndexOfCoordinate(coordinate);
        int x = board.getBoard().get(index).getX();
        int y = board.getBoard().get(index).getY();

        board.getBoard().add(index, new WhiteCell(x, y, "white", WhiteFigures.CELL.getFigure()));
        board.getBoard().remove(index + 1);
    }

    private boolean cellIsBlack(ToCoordinateParser coord) {
        String cellColor = new CellColorFinder().getCellColor(coord);  //!!!!
        return cellColor.equals("black");
    }

    private boolean cellIsWhite(ToCoordinateParser coord) {
        String cellColor = new CellColorFinder().getCellColor(coord);
        return cellColor.equals("white");
    }

}
