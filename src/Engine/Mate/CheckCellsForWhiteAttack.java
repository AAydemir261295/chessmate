package Engine.Mate;

import ChessItems.Items.Board;
import ChessItems.Items.ChessItem;
import ChessItems.WhiteFigures.WhiteFigure;
import Engine.EmptyCellsAroundBlackKing;
import Engine.ToCoordinateParser;

import java.util.ArrayList;

public class CheckCellsForWhiteAttack {


    public boolean emptyCellsUnderAttack(ToCoordinateParser kingPos) {

        Board board = new Board();
        EmptyCellsAroundBlackKing tmp = new EmptyCellsAroundBlackKing();

        ArrayList<ToCoordinateParser> cellsUnderAttack = new ArrayList<>();
        ArrayList<ToCoordinateParser> emptyCells = tmp.getEmptyCells(kingPos);

        for (int i = 0; i < board.getBoard().size(); i++) {
            if (isWhiteFigure(board.getBoard().get(i))) {
                ChessItem whiteFigure = board.getBoard().get(i);
                ToCoordinateParser whiteFigurePos = getFigureCoordinate(whiteFigure);
                for (ToCoordinateParser emptyCell : emptyCells) {
                    if (cellUnderAttack(whiteFigure, whiteFigurePos, emptyCell) == 1) {
                        cellsUnderAttack.add(emptyCell);
                    }
                }
            }
        }
        return possibleCellsForMove(cellsUnderAttack, emptyCells);
    }

    private ToCoordinateParser getFigureCoordinate(ChessItem item) {
        return new ToCoordinateParser(item.getX(), item.getY());
    }

    private boolean isWhiteFigure(ChessItem figure) {
        return figure instanceof WhiteFigure;
    }

    private int cellUnderAttack(ChessItem figure, ToCoordinateParser opponentPos, ToCoordinateParser emptyCell) {
        return figure.getDirection().checkDirection(opponentPos, emptyCell);
    }

    private boolean possibleCellsForMove(ArrayList<ToCoordinateParser> cellsUnderAttack, ArrayList<ToCoordinateParser> emptyCells) {
        return cellsUnderAttack.size() == emptyCells.size();
    }

}
