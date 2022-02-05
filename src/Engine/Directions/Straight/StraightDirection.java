package Engine.Directions.Straight;

import Engine.ToCoordinateParser;

public class StraightDirection {

    //методы нужны для выявления направления а так же проверка правильности прямой линии хода
    public boolean isUpDirection(ToCoordinateParser figurePosition, ToCoordinateParser figureMove) {
        return figurePosition.getX() == figureMove.getX() &&
                figurePosition.getY() < figureMove.getY();
    }

    public boolean isDownDirection(ToCoordinateParser figurePosition, ToCoordinateParser figureMove) {
        return figurePosition.getX() == figureMove.getX() &&
                figurePosition.getY() > figureMove.getY();
    }

    public boolean isLeftDirection(ToCoordinateParser figurePosition, ToCoordinateParser figureMove) {
        return figurePosition.getX() > figureMove.getX() &&
                figurePosition.getY() == figureMove.getY();
    }

    public boolean isRightDirection(ToCoordinateParser figurePosition, ToCoordinateParser figureMove) {
        return figurePosition.getX() < figureMove.getX() &&
                figurePosition.getY() == figureMove.getY();
    }

    //еще одна альтернативная проверка
    public boolean isPossibleMove(ToCoordinateParser figurePosition, ToCoordinateParser figureMove) {
        int xDifference = Math.abs(figurePosition.getX() - figureMove.getX());
        int yDifference = Math.abs(figurePosition.getY() - figureMove.getY());

        if (xDifference == 0 && yDifference > 0) {
            return true;
        } else return xDifference > 0 && yDifference == 0;
    }

}
