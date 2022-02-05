package ChessItems.WhiteFigures.Castle;


import ChessItems.BlackFigures.BlackFigure;
import ChessItems.Items.Board;
import ChessItems.Items.Cells;
import Engine.Directions.Straight.CheckCellsForEmptySTR;
import Engine.Directions.Straight.StraightDirection;
import Engine.HasDirection;
import Engine.ToCoordinateParser;

public class LineIsEmptyWhiteCastle implements HasDirection {

    @Override
    public int checkDirection(ToCoordinateParser before, ToCoordinateParser after) {
        StraightDirection direction = new StraightDirection();
        CheckCellsForEmptySTR validator = new CheckCellsForEmptySTR();
        int cellsOnUpDirection = Math.abs(before.getY() - after.getY());
        int cellsOnDownDirection = Math.abs(before.getY() - after.getY());
        int normalMove = 1;
        int incorrectMove = -1;

        if (direction.isUpDirection(before, after) && validator.upDirectionIsEmpty(before, after)) {
            return normalMove;
        }
        if (direction.isDownDirection(before, after) && validator.downDirectionIsEmpty(before, after)) {
            return normalMove;
        }
        if (direction.isRightDirection(before, after) && validator.rightDirectionIsEmpty(before, after)) {
            return normalMove;
        }
        if (direction.isLeftDirection(before, after) && validator.leftDirectionIsEmpty(before, after)) {
            return normalMove;
        }

        if (cellsOnUpDirection == 1 || cellsOnDownDirection == 1) {
            if (direction.isPossibleMove(before, after)) {
                if (new Board().getItemFromCoordinate(after) instanceof Cells ||
                        new Board().getItemFromCoordinate(after) instanceof BlackFigure) {
                    return normalMove;
                }
            }
        }
        return incorrectMove;
    }
}



