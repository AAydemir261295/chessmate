package ChessItems.WhiteFigures.Bishop;

import ChessItems.BlackFigures.BlackFigure;
import ChessItems.Items.Board;
import ChessItems.Items.Cells;
import Engine.Directions.Diagonal.CheckCellsForEmptyDIA;
import Engine.Directions.Diagonal.DiagonalDirection;
import Engine.HasDirection;
import Engine.ToCoordinateParser;

public class LineIsEmptyWhiteBishop implements HasDirection {

    public int checkDirection(ToCoordinateParser before, ToCoordinateParser after) {

        DiagonalDirection direction = new DiagonalDirection();
        CheckCellsForEmptyDIA validator = new CheckCellsForEmptyDIA();
        int xDifference = Math.abs(before.getX() - after.getX());
        int cellsOnDirection = Math.abs(before.getY() - after.getY());
        int result = xDifference - cellsOnDirection;
        int normalMove = 1;
        int incorrectMove = -1;

        if (direction.isRightUpDirection(before, after) && validator.rightUpDirectionIsEmpty(before, after)) {
            return normalMove;
        }

        if (direction.isLeftUpDirection(before, after) && validator.leftUpDirectionIsEmpty(before, after)) {
            return normalMove;
        }

        if (direction.isLeftDownDirection(before, after) && validator.leftDownDirectionIsEmpty(before, after)) {
            return normalMove;
        }

        if (direction.isRightDownDirection(before, after) && validator.rightDownDirectionIsEmpty(before, after)) {
            return normalMove;
        }

        if (cellsOnDirection == 1 && result == 0) {
            if (new Board().getItemFromCoordinate(after) instanceof Cells ||
                    new Board().getItemFromCoordinate(after) instanceof BlackFigure) {
                return normalMove;
            }
        }
        return incorrectMove;
    }
}
