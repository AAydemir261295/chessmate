package ChessItems.WhiteFigures.Pawn;

import ChessItems.BlackFigures.BlackFigure;
import ChessItems.Items.Board;
import Engine.Directions.Diagonal.DiagonalDirection;
import Engine.Directions.Straight.StraightDirection;
import Engine.ToCoordinateParser;

public class WhitePawnMoveObserver {

    public boolean isPossible(ToCoordinateParser figurePosition, ToCoordinateParser movePosition) {
        int Ydifference = Math.abs(figurePosition.getY() - movePosition.getY());
        StraightDirection straightDirection = new StraightDirection();

        if (straightDirection.isUpDirection(figurePosition, movePosition)) {
            if (isItFirstPawnMove(Ydifference, figurePosition)) { // в случае если пешкой хотят пойти на две клетки
                return true;
            } else return Ydifference == 1;
        } else if (onLeftUpDirectionOpponent(Ydifference, figurePosition, movePosition)) {
            return true;
        } else
            return onRightUpDirectionOpponent(Ydifference, figurePosition, movePosition);
    }

    private boolean isItFirstPawnMove(int Ydifference, ToCoordinateParser figurePos) {
        return Ydifference == 2 && figurePos.getY() == 2;
    }

    private boolean onLeftUpDirectionOpponent(int Ydifference, ToCoordinateParser figurePosition, ToCoordinateParser movePosition) {
        return new DiagonalDirection().isLeftUpDirection(figurePosition, movePosition) && Ydifference == 1 &&
                new Board().getItemFromCoordinate(movePosition) instanceof BlackFigure;
    }

    private boolean onRightUpDirectionOpponent(int Ydifference, ToCoordinateParser figurePosition, ToCoordinateParser movePosition) {
        return new DiagonalDirection().isRightUpDirection(figurePosition, movePosition) && Ydifference == 1 &&
                new Board().getItemFromCoordinate(movePosition) instanceof BlackFigure;
    }

}
