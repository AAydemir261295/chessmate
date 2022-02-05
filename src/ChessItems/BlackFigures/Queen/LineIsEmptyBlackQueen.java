package ChessItems.BlackFigures.Queen;


import ChessItems.BlackFigures.Bishop.LineIsEmptyBlackBishop;
import ChessItems.BlackFigures.Castle.LineIsEmptyBlackCastle;
import Engine.HasDirection;
import Engine.ToCoordinateParser;

public class LineIsEmptyBlackQueen implements HasDirection {

    @Override
    public int checkDirection(ToCoordinateParser before, ToCoordinateParser after) {
        // Проверка дигонали
        // Проверка прямой линии
        LineIsEmptyBlackBishop checkDiagonal = new LineIsEmptyBlackBishop();
        LineIsEmptyBlackCastle checkStraight = new LineIsEmptyBlackCastle();
        int normalMove = 1;
        int incorrectMove = -1;

        if (checkDiagonal.checkDirection(before, after) == 1 ||
                checkStraight.checkDirection(before, after) == 1) {
            return normalMove;
        }
        return incorrectMove;
    }
}
