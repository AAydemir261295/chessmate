package ChessItems.WhiteFigures.Knight;

import ChessItems.BlackFigures.BlackFigure;
import ChessItems.Items.Board;
import ChessItems.Items.Cells;
import Engine.HasDirection;
import Engine.ToCoordinateParser;

public class LineIsEmptyWhiteKnight implements HasDirection {

    @Override
    public int checkDirection(ToCoordinateParser figurePos, ToCoordinateParser figureMove) {
        int correctMove = 1;
        int incorrectMove = -1;

        if (onCellIsOpponent(figureMove)
                && isPossibleMove(figurePos, figureMove)) {
            return correctMove;
        }
        return incorrectMove;
    }

    private boolean onCellIsOpponent(ToCoordinateParser moveCoordinate) {
        return new Board().getItemFromCoordinate(moveCoordinate) instanceof BlackFigure
                || new Board().getItemFromCoordinate(moveCoordinate) instanceof Cells;
    }

    private boolean isPossibleMove(ToCoordinateParser figurePosition, ToCoordinateParser moveCoordinate) {
        int yDifference = Math.abs(figurePosition.getY() - moveCoordinate.getY());
        int xDifference = Math.abs(figurePosition.getX() - moveCoordinate.getX());

        if (yDifference == 1 && xDifference == 2) {
            return true;
        } else return yDifference == 2 && xDifference == 1;
    }
}
