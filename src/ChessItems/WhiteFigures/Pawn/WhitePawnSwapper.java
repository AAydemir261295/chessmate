package ChessItems.WhiteFigures.Pawn;

import ChessItems.BeatenFigures.WhiteBeatenFigures;
import ChessItems.Items.Board;
import ChessItems.Items.ChessItem;
import ChessItems.WhiteFigures.Bishop.WhiteBishop;
import ChessItems.WhiteFigures.Castle.WhiteCastle;
import ChessItems.WhiteFigures.Knight.WhiteKnight;
import ChessItems.WhiteFigures.Queen.WhiteQueen;
import ChessItems.WhiteFigures.WhiteFigures;
import Engine.CellColorFinder;
import Engine.CellDrawer;
import Engine.ToCoordinateParser;

public class WhitePawnSwapper {

    public boolean isItSwapTime(ToCoordinateParser movePosition) {
        return new Board().getItemFromCoordinate(movePosition).getY() == 8 &&
                new WhiteBeatenFigures().getWhiteFigures().size() > 0;
    }

    public void swapIt(ToCoordinateParser previousPosition, ToCoordinateParser swapPosition) {
        drawSwappedFigure(swapPosition);
        deletePawn(previousPosition);
    }

    private void drawSwappedFigure(ToCoordinateParser swapPosition) {
        Board board = new Board();
        String cellColor = getCellColor(swapPosition);
        ChessItem item = getFigure();
        int index = board.getIndexOfCoordinate(swapPosition);
        int x = board.getBoard().get(index).getX();
        int y = board.getBoard().get(index).getY();

        board.getBoard().add(index, getItem(item, x, y, cellColor));
        board.getBoard().remove(index + 1);
    }

    private ChessItem getItem(ChessItem item, int x, int y, String cellColor) {
        if (item instanceof WhiteBishop) {
            return new WhiteBishop(x, y, cellColor, WhiteFigures.BISHOP.getFigure());
        } else if (item instanceof WhiteCastle) {
            return new WhiteCastle(x, y, cellColor, WhiteFigures.CASTLE.getFigure(), 1);
        } else if (item instanceof WhiteKnight) {
            return new WhiteKnight(x, y, cellColor, WhiteFigures.KNIGHT.getFigure());
        } else if (item instanceof WhiteQueen) {
            return new WhiteQueen(x, y, cellColor, WhiteFigures.QUEEN.getFigure());
        }
        return null;
    }

    private void deletePawn(ToCoordinateParser previousPosition){
        CellDrawer cellDrawer = new CellDrawer();
        cellDrawer.drawCell(previousPosition);
    }

    private ChessItem getFigure() {
        WhiteBeatenFigures whiteBeatenFigures = new WhiteBeatenFigures();
        return whiteBeatenFigures.swapFigure();
    }

    private String getCellColor(ToCoordinateParser coord) {
        CellColorFinder saveCellColor = new CellColorFinder();
        return saveCellColor.getCellColor(coord);
    }
}
