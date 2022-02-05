package ChessItems.BlackFigures.King;

import ChessItems.Items.Board;
import ChessItems.Items.Cells;
import ChessItems.WhiteFigures.WhiteFigure;
import Engine.CheckCellForAttack;
import Engine.ToCoordinateParser;

public class BlackKingMoveObserver {
    // Проверка хода короля
    public boolean isPossible(ToCoordinateParser figurePos, ToCoordinateParser movePos) {
        return isOneCellMove(figurePos, movePos) && possibleMove(movePos)
                && cellNotUnderAttack(movePos);
    }

    // на одну ли клетку он ходит
    private boolean isOneCellMove(ToCoordinateParser figurePos, ToCoordinateParser movePos) {
        int y_difference = Math.abs(figurePos.getY() - movePos.getY());
        int x_difference = Math.abs(figurePos.getX() - movePos.getX());

        if (y_difference == 1 && x_difference == 1) {
            return true;
        } else if (y_difference == 0 && x_difference == 1) {
            return true;
        } else return y_difference == 1 && x_difference == 0;
    }

    // нет ли препятсвий
    private boolean possibleMove(ToCoordinateParser movePos) {
        Board board = new Board();
        return board.getItemFromCoordinate(movePos) instanceof Cells ||
                board.getItemFromCoordinate(movePos) instanceof WhiteFigure;
    }

    //не смотрит ли противник на клетку куда хочет пойти король
    private boolean cellNotUnderAttack(ToCoordinateParser after) {
        CheckCellForAttack x = new CheckCellForAttack();
        return !(x.cellIsUnderWhiteAttack(after));
    }
}
