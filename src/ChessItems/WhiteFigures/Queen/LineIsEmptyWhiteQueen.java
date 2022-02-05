package ChessItems.WhiteFigures.Queen;


import ChessItems.WhiteFigures.Bishop.LineIsEmptyWhiteBishop;
import ChessItems.WhiteFigures.Castle.LineIsEmptyWhiteCastle;
import Engine.HasDirection;
import Engine.ToCoordinateParser;

public class LineIsEmptyWhiteQueen implements HasDirection {

    public int checkDirection(ToCoordinateParser before, ToCoordinateParser after) {

        LineIsEmptyWhiteBishop checkDiagonal = new LineIsEmptyWhiteBishop();
        LineIsEmptyWhiteCastle checkStraight = new LineIsEmptyWhiteCastle();
        int correctMove = 1;
        int incorrectMove = -1;

        if (checkDiagonal.checkDirection(before, after) == 1 ||
                checkStraight.checkDirection(before, after) == 1) {
            return correctMove;
        }
        return incorrectMove;
    }
}
