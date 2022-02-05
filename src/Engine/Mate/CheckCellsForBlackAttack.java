package Engine.Mate;

import ChessItems.BlackFigures.BlackFigure;
import ChessItems.Items.Board;
import ChessItems.Items.ChessItem;
import Engine.EmptyCellsAroundWhiteKing;
import Engine.ToCoordinateParser;

import java.util.ArrayList;

public class CheckCellsForBlackAttack {

    // находим все пустые клетки вокруг короля
    // перебираем фигуры оппонента
    // проверяем смотрят ли они на эти пустые клетки
    // если есть клетки не под угрозой
    public boolean emptyCellsUnderAttack(ToCoordinateParser kingPos) {

        Board board = new Board();
        EmptyCellsAroundWhiteKing tmp = new EmptyCellsAroundWhiteKing();

        ArrayList<ToCoordinateParser> cellsUnderAttack = new ArrayList<>();
        ArrayList<ToCoordinateParser> emptyCells = tmp.getEmptyCells(kingPos);

        for (int i = 0; i < board.getBoard().size(); i++) {
            if (isBlackFigure(board.getBoard().get(i))) {
                ChessItem blackFigure = board.getBoard().get(i);
                ToCoordinateParser blackFigurePos = getFigureCoordinate(blackFigure);
                for (ToCoordinateParser emptyCell : emptyCells) {
                    if (cellUnderAttack(blackFigure, blackFigurePos, emptyCell) == 1) {
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

    private boolean isBlackFigure(ChessItem figure) {
        return figure instanceof BlackFigure;
    }

    private int cellUnderAttack(ChessItem figure, ToCoordinateParser opponentPos, ToCoordinateParser emptyCell) {
        return figure.getDirection().checkDirection(opponentPos, emptyCell);
    }

    private boolean possibleCellsForMove(ArrayList<ToCoordinateParser> cellsUnderAttack, ArrayList<ToCoordinateParser> emptyCells) {
        return cellsUnderAttack.size() == emptyCells.size();
    }

}
