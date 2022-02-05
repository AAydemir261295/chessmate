package Engine;

import ChessItems.Items.Board;
import ChessItems.WhiteFigures.King.WhiteKingMoveObserver;

import java.util.ArrayList;

public class EmptyCellsAroundWhiteKing {

    public ArrayList<ToCoordinateParser> getEmptyCells(ToCoordinateParser kingPos) {
        Board board = new Board();
        WhiteKingMoveObserver move = new WhiteKingMoveObserver();
        ArrayList<ToCoordinateParser> emptyCells = new ArrayList<>();
        int boardSize = board.getBoard().size();

        for (int i = 0; i < boardSize; i++) {
            ToCoordinateParser cellNearKing = board.getCoordinate(i);
            if (move.isPossible(kingPos, cellNearKing)) {
                emptyCells.add(cellNearKing);
            }
        }
        return emptyCells;
    }
}
