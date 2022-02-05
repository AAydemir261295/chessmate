package ChessItems.WhiteFigures.Pawn;

import Engine.Directions.Straight.CheckCellsForEmptySTR;
import Engine.Directions.Straight.StraightDirection;
import Engine.HasDirection;
import Engine.ToCoordinateParser;


public class LineIsEmptyWhitePawn implements HasDirection {

    public int checkDirection(ToCoordinateParser figurePosition, ToCoordinateParser moveCoordinate) {

        StraightDirection strDirection = new StraightDirection();
        CheckCellsForEmptySTR cellsOn = new CheckCellsForEmptySTR();
        WhitePawnMoveObserver moveObserver = new WhitePawnMoveObserver();
        int swappingMove = 2;
        int correctMove = 1;
        int incorrectMove = -1;

        if (strDirection.isUpDirection(figurePosition, moveCoordinate)
                && cellsOn.upDirectionIsEmpty(figurePosition, moveCoordinate)
                && moveObserver.isPossible(figurePosition, moveCoordinate)) {
            return correctMove;
        } else if (moveObserver.isPossible(figurePosition, moveCoordinate) && !(pawnOnSwapCoordinate(moveCoordinate))) {
            return correctMove;
        } else if (pawnOnSwapCoordinate(moveCoordinate)) {
            return swappingMove;
        }
        return incorrectMove;
    }

    private boolean pawnOnSwapCoordinate(ToCoordinateParser pawnPosition) {
        WhitePawnSwapper x = new WhitePawnSwapper();
        return x.isItSwapTime(pawnPosition);
    }
}

