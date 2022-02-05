package ChessItems.BlackFigures.Pawn;

import ChessItems.Items.Board;
import ChessItems.WhiteFigures.WhiteFigure;
import Engine.Directions.Diagonal.DiagonalDirection;
import Engine.Directions.Straight.StraightDirection;
import Engine.ToCoordinateParser;

public class BlackPawnMoveObserver {

    public boolean isPossible(ToCoordinateParser figurePosition, ToCoordinateParser movePosition) {
        int Ydifference = Math.abs(movePosition.getY() - figurePosition.getY());
        StraightDirection straightDirection = new StraightDirection();

        //если ход на две клетки
        //если ход на одну клетку
        // если она бьет противник ли на клетке
        if (straightDirection.isDownDirection(figurePosition, movePosition)) {
            if (isItFirstPawnMove(Ydifference, figurePosition)) {
                return true;
            } else return Ydifference == 1;
        } else if (onLeftDownDirectionOpponent(Ydifference, figurePosition, movePosition)) {
            return true;
        } else return onRightDownDirectionOpponent(Ydifference, figurePosition, movePosition);
    }

    private boolean isItFirstPawnMove(int Ydifference, ToCoordinateParser figurePos) {
        return Ydifference == 2 && figurePos.getY() == 7;
    }

    private boolean onLeftDownDirectionOpponent(int Ydifference, ToCoordinateParser figurePos, ToCoordinateParser movePos) {
        return new DiagonalDirection().isLeftDownDirection(figurePos, movePos) && Ydifference == 1 &&
                new Board().getItemFromCoordinate(movePos) instanceof WhiteFigure;
    }

    private boolean onRightDownDirectionOpponent(int Ydifference, ToCoordinateParser figurePos, ToCoordinateParser movePos) {
        return new DiagonalDirection().isRightDownDirection(figurePos, movePos) && Ydifference == 1 &&
                new Board().getItemFromCoordinate(movePos) instanceof WhiteFigure;
    }

}
