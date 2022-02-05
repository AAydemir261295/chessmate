package ChessItems.BlackFigures.Bishop;

import ChessItems.Items.Board;
import ChessItems.Items.Cells;
import ChessItems.WhiteFigures.WhiteFigure;
import Engine.Directions.Diagonal.CheckCellsForEmptyDIA;
import Engine.Directions.Diagonal.DiagonalDirection;
import Engine.HasDirection;
import Engine.ToCoordinateParser;

public class LineIsEmptyBlackBishop implements HasDirection {
    //проверяет направление слона
    // пустые ли клетки на пути
    // а так же возможен ли этот ход по правилам шахмат
    @Override
    public int checkDirection(ToCoordinateParser before, ToCoordinateParser after) {
        Board board = new Board();
        DiagonalDirection direction = new DiagonalDirection();
        CheckCellsForEmptyDIA validator = new CheckCellsForEmptyDIA();
        int cellsOnDirection = Math.abs(before.getY() - after.getY());
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
        if (cellsOnDirection == 1) {
            if (board.getItemFromCoordinate(after) instanceof Cells ||
                    board.getItemFromCoordinate(after) instanceof WhiteFigure) {
                return normalMove;
            }
        }
        return incorrectMove;
    }
}
