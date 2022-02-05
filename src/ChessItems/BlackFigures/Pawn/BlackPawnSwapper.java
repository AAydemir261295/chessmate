package ChessItems.BlackFigures.Pawn;

import ChessItems.BeatenFigures.BlackBeatenFigures;
import ChessItems.BlackFigures.Bishop.BlackBishop;
import ChessItems.BlackFigures.BlackFigures;
import ChessItems.BlackFigures.Castle.BlackCastle;
import ChessItems.BlackFigures.Knight.BlackKnight;
import ChessItems.BlackFigures.Queen.BlackQueen;
import ChessItems.Items.Board;
import ChessItems.Items.ChessItem;
import Engine.CellColorFinder;
import Engine.CellDrawer;
import Engine.ToCoordinateParser;

public class BlackPawnSwapper {

    // проверяет возможен ли обмен
    // меняет фигуру и удаляет пешку с клетки перед ходом

    public boolean isItSwapTime(ToCoordinateParser movePosition) {
        return new Board().getItemFromCoordinate(movePosition).getY() == 1 &&
                new BlackBeatenFigures().getBlackFigures().size() > 0;
    }

    public void swapIt(ToCoordinateParser previousPosition, ToCoordinateParser swapPosition) {
        drawSwappedFigure(swapPosition);
        deletePawn(previousPosition);
    }

    private void drawSwappedFigure(ToCoordinateParser swapPosition) {
        Board board = new Board();
        ChessItem item = getFigure();

        int index = board.getIndexOfCoordinate(swapPosition);
        String cellColor = getCellColor(swapPosition);
        int x = board.getBoard().get(index).getX();
        int y = board.getBoard().get(index).getY();

        board.getBoard().add(index, getItem(item, x, y, cellColor));
        board.getBoard().remove(index + 1);
    }

    private ChessItem getItem(ChessItem item, int x, int y, String cellColor) {
        if (item instanceof BlackBishop) {
            return new BlackBishop(x, y, cellColor, BlackFigures.BISHOP.getFigure());
        } else if (item instanceof BlackCastle) {
            return new BlackCastle(x, y, cellColor, BlackFigures.CASTLE.getFigure(), 1);
        } else if (item instanceof BlackKnight) {
            return new BlackKnight(x, y, cellColor, BlackFigures.KNIGHT.getFigure());
        } else if (item instanceof BlackQueen) {
            return new BlackQueen(x, y, cellColor, BlackFigures.QUEEN.getFigure());
        }
        return null;
    }

    private void deletePawn(ToCoordinateParser previousPosition){
        CellDrawer cellDrawer = new CellDrawer();
        cellDrawer.drawCell(previousPosition);
    }

    private ChessItem getFigure() {
        BlackBeatenFigures blackBeatenFigures = new BlackBeatenFigures();
        return blackBeatenFigures.swapFigure();
    }

    private String getCellColor(ToCoordinateParser coord) {
        CellColorFinder saveCellColor = new CellColorFinder();
        return saveCellColor.getCellColor(coord);
    }
}
