package ChessItems.WhiteFigures.King;


import Engine.HasDirection;
import Engine.ToCoordinateParser;

public class LineIsEmptyWhiteKing implements HasDirection {

    public int checkDirection(ToCoordinateParser before, ToCoordinateParser after) {
        WhiteKingCastling castling = new WhiteKingCastling();
        WhiteKingMoveObserver moveObserver = new WhiteKingMoveObserver();
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
