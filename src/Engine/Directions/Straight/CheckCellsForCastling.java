package Engine.Directions.Straight;

import ChessItems.Items.Board;
import ChessItems.Items.Cells;
import Engine.ToCoordinateParser;

import java.util.ArrayList;

public class CheckCellsForCastling {

    // проверка клеток на пустоту для рокировки
    public boolean rightDirectionIsEmpty(ToCoordinateParser figurePosition, ToCoordinateParser movePosition) {
        StraightCellsOnDirection cellsOnDirection = new StraightCellsOnDirection();
        ArrayList<ToCoordinateParser> cells = cellsOnDirection.getRightCells(figurePosition, movePosition);
        int cellsCount = cells.size();
        int counter = 0;

        for (ToCoordinateParser onPosition : cells) {
            if (isCell(onPosition)) {
                counter++;
                if (allCellsOnDirectionIsEmpty(counter, cellsCount)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean leftDirectionIsEmpty(ToCoordinateParser figurePosition, ToCoordinateParser movePosition) {
        StraightCellsOnDirection cellsOnDirection = new StraightCellsOnDirection();
        ArrayList<ToCoordinateParser> cells = cellsOnDirection.getLeftCells(figurePosition, movePosition);
        int cellsCount = cells.size();
        int counter = 0;

        for (ToCoordinateParser onPosition : cells) {
            if (isCell(onPosition)) {
                counter++;
                if (allCellsOnDirectionIsEmpty(counter, cellsCount)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCell(ToCoordinateParser cellPosition) {
        return new Board().getItemFromCoordinate(cellPosition) instanceof Cells;
    }

    private boolean allCellsOnDirectionIsEmpty(int count, int cellsCount) {
        return count == (cellsCount - 1);
    }
}
