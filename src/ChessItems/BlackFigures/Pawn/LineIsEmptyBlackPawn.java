package ChessItems.BlackFigures.Pawn;

import Engine.Directions.Straight.CheckCellsForEmptySTR;
import Engine.Directions.Straight.StraightDirection;
import Engine.HasDirection;
import Engine.ToCoordinateParser;


public class LineIsEmptyBlackPawn implements HasDirection {

    // выявляет ход пешки обычный, удар, или обмен
    @Override
    public int checkDirection(ToCoordinateParser figurePosition, ToCoordinateParser moveCoordinate) {

        StraightDirection strDirection = new StraightDirection();
        CheckCellsForEmptySTR strCheck = new CheckCellsForEmptySTR();
        BlackPawnMoveObserver moveObserver = new BlackPawnMoveObserver();
        int swappingMove = 2;
        int normalMove = 1;
        int incorrectMove = -1;

        if (strDirection.isUpDirection(figurePosition, moveCoordinate) && strCheck.upDirectionIsEmpty(figurePosition, moveCoordinate)
                && moveObserver.isPossible(figurePosition, moveCoordinate)) {
            return normalMove;
        } else if (moveObserver.isPossible(figurePosition, moveCoordinate) && !(pawnOnSwapCoordinate(moveCoordinate))) {
            return normalMove;
        } else if (pawnOnSwapCoordinate(moveCoordinate)) {
            return swappingMove;
        }
        return incorrectMove;
    }

    private boolean pawnOnSwapCoordinate(ToCoordinateParser pawnPosition) {
        BlackPawnSwapper x = new BlackPawnSwapper();
        return x.isItSwapTime(pawnPosition);
    }
}

