package ChessItems.BlackFigures.Knight;

import ChessItems.Items.Board;
import ChessItems.Items.Cells;
import ChessItems.WhiteFigures.WhiteFigure;
import Engine.HasDirection;
import Engine.ToCoordinateParser;

public class LineIsEmptyBlackKnight implements HasDirection {

    @Override
    public int checkDirection(ToCoordinateParser figurePosition, ToCoordinateParser moveCoordinate) {
        int normalMove = 1;
        int incorrectMove = -1;

        if (isWhiteFigureOn(moveCoordinate) &&
                isPossibleMove(figurePosition, moveCoordinate)) {
            return normalMove;
        }
        return incorrectMove;
    }

    // не союзник ли на клетке и пуста ли она
    private boolean isWhiteFigureOn(ToCoordinateParser moveCoordinate) {
        return new Board().getItemFromCoordinate(moveCoordinate) instanceof WhiteFigure ||
                new Board().getItemFromCoordinate(moveCoordinate) instanceof Cells;
    }

    // проверка хода коня согласно шахматным правилам
    private boolean isPossibleMove(ToCoordinateParser figurePosition, ToCoordinateParser moveCoordinate) {
        int yDifference = Math.abs(figurePosition.getY() - moveCoordinate.getY());
        int xDifference = Math.abs(figurePosition.getX() - moveCoordinate.getX());

        if (yDifference == 1 && xDifference == 2) {
            return true;
        } else return yDifference == 2 && xDifference == 1;
    }
}
