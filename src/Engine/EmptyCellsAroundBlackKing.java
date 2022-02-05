package Engine;

import ChessItems.BlackFigures.King.BlackKingMoveObserver;
import ChessItems.Items.Board;

import java.util.ArrayList;

public class EmptyCellsAroundBlackKing {

    // Подсчитывает свободные клетки вокруг короля
    // помогает для выявления мата
    public ArrayList<ToCoordinateParser> getEmptyCells(ToCoordinateParser kingPos) {
        Board board = new Board();
        ArrayList<ToCoordinateParser> emptyCells = new ArrayList<>();
        BlackKingMoveObserver move = new BlackKingMoveObserver();
        int boardSize = board.getBoard().size();
        // проходим по всему полю
        // проверяем может ли пойти на каждую из клетку король
        // и сохраняем
        for (int i = 0; i < boardSize; i++) {
            ToCoordinateParser cellNearKing = board.getCoordinate(i);
            if (move.isPossible(kingPos, cellNearKing)) {
                emptyCells.add(cellNearKing);
            }
        }
        return emptyCells;
    }
}
