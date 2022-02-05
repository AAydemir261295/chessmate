package ChessItems.BlackFigures.King;


import Engine.HasDirection;
import Engine.ToCoordinateParser;

public class LineIsEmptyBlackKing implements HasDirection {
    // Обычный ход или рокировочный
    @Override
    public int checkDirection(ToCoordinateParser before, ToCoordinateParser after) {

        BlackKingCastling castling = new BlackKingCastling();
        BlackKingMoveObserver moveObserver = new BlackKingMoveObserver();
        int castlingMove = 2;
        int normalMove = 1;
        int incorrectMove = -1;

        if (castling.isCastleable(before, after)) {
            return castlingMove;
        } else if (moveObserver.isPossible(before, after)) {
            return normalMove;
        }
        return incorrectMove;
    }
}
