package Engine.Directions.Diagonal;

import Engine.ToCoordinateParser;

public class DiagonalDirection {

    //выявление направления и проверка на соответствие шахматным правилам
    public boolean isRightUpDirection(ToCoordinateParser figurePosition, ToCoordinateParser figureMove) {
        return figurePosition.getY() < figureMove.getY() &&
                figurePosition.getX() < figureMove.getX() &&
                isPossibleMove(figurePosition, figureMove);
    }

    public boolean isRightDownDirection(ToCoordinateParser figurePosition, ToCoordinateParser figureMove) {
        return figurePosition.getY() > figureMove.getY() &&
                figurePosition.getX() < figureMove.getX() &&
                isPossibleMove(figurePosition, figureMove);
    }

    public boolean isLeftUpDirection(ToCoordinateParser figurePosition, ToCoordinateParser figureMove) {
        return figurePosition.getY() < figureMove.getY() &&
                figurePosition.getX() > figureMove.getX() &&
                isPossibleMove(figurePosition, figureMove);
    }

    public boolean isLeftDownDirection(ToCoordinateParser figurePosition, ToCoordinateParser figureMove) {
        return figurePosition.getY() > figureMove.getY() &&
                figurePosition.getX() > figureMove.getX() &&
                isPossibleMove(figurePosition, figureMove);
    }

    public boolean isPossibleMove(ToCoordinateParser figurePosition, ToCoordinateParser figureMove) {
        int y_difference = Math.abs(figurePosition.getY() - figureMove.getY());
        int x_difference = Math.abs(figurePosition.getX() - figureMove.getX());
        return y_difference == x_difference;
    }

}
