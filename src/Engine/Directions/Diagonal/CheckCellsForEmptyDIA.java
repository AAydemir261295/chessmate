package Engine.Directions.Diagonal;

import ChessItems.BlackFigures.BlackFigure;
import ChessItems.Items.Board;
import ChessItems.Items.Cells;
import ChessItems.WhiteFigures.WhiteFigure;
import Engine.ToCoordinateParser;

import java.util.ArrayList;

public class CheckCellsForEmptyDIA {

    // проверка на пустоту клеток на пути по диагонали
    // подсчет клеток на пути
    // проверка каждой клетки на пустоту
    // если на последней клетке противник то ход возможен
    public boolean rightUpDirectionIsEmpty(ToCoordinateParser figurePos, ToCoordinateParser figureMove) {
        DiagonalCellsOnDirection cellsOnDirection = new DiagonalCellsOnDirection();
        ArrayList<ToCoordinateParser> cells = cellsOnDirection.getRightUpCells(figurePos, figureMove);
        int cellsCount = cells.size();
        int counter = 0;

        for (ToCoordinateParser onPosition : cells) {
            if (isCell(onPosition)) {
                counter++;
                if (allCellsIsEmpty(counter, cellsCount)) {
                    return true;
                }
            } else if (lastCellNotEmpty(counter, cellsCount) &&
                    onLastCellOpponent(figurePos, onPosition)) {
                return true;
            }
        }
        return false;
    }

    public boolean rightDownDirectionIsEmpty(ToCoordinateParser figurePos, ToCoordinateParser figureMove) {
        DiagonalCellsOnDirection cellsOnDirection = new DiagonalCellsOnDirection();
        ArrayList<ToCoordinateParser> cells = cellsOnDirection.getRightDownCells(figurePos, figureMove);
        int cellsCount = cells.size();
        int counter = 0;

        for (ToCoordinateParser onPosition : cells) {
            if (isCell(onPosition)) {
                counter++;
                if (allCellsIsEmpty(counter, cellsCount)) {
                    return true;
                }
            } else if (lastCellNotEmpty(counter, cellsCount) &&
                    onLastCellOpponent(figurePos, onPosition)) {
                return true;
            }
        }
        return false;
    }

    public boolean leftUpDirectionIsEmpty(ToCoordinateParser figurePos, ToCoordinateParser figureMove) {
        DiagonalCellsOnDirection cellsOnDirection = new DiagonalCellsOnDirection();
        ArrayList<ToCoordinateParser> cells = cellsOnDirection.getLeftUpCells(figurePos, figureMove);
        int cellsCount = cells.size();
        int counter = 0;

        for (ToCoordinateParser onPosition : cells) {
            if (isCell(onPosition)) {
                counter++;
                if (allCellsIsEmpty(counter, cellsCount)) {
                    return true;
                }
            } else if (lastCellNotEmpty(counter, cellsCount) &&
                    onLastCellOpponent(figurePos, onPosition)) {
                return true;
            }
        }
        return false;
    }

    public boolean leftDownDirectionIsEmpty(ToCoordinateParser figurePos, ToCoordinateParser figureMove) {
        DiagonalCellsOnDirection cellsOnDirection = new DiagonalCellsOnDirection();
        ArrayList<ToCoordinateParser> cells = cellsOnDirection.getLeftDownCells(figurePos, figureMove);
        int cellsCount = cells.size();
        int counter = 0;

        for (ToCoordinateParser onPosition : cells) {
            if (isCell(onPosition)) {
                counter++;
                if (allCellsIsEmpty(counter, cellsCount)) {
                    return true;
                }
            } else if (lastCellNotEmpty(counter, cellsCount) &&
                    onLastCellOpponent(figurePos, onPosition)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCell(ToCoordinateParser cellPosition) {
        return new Board().getItemFromCoordinate(cellPosition) instanceof Cells;

    }

    private boolean allCellsIsEmpty(int count, int cellsCount) {
        return count == cellsCount;
    }

    private boolean onLastCellOpponent(ToCoordinateParser figurePos, ToCoordinateParser onLastCellInDirection) {
        if (isWhiteMove(figurePos) && isBlack(onLastCellInDirection)) {
            return true;
        } else return isBlackMove(figurePos) && isWhite(onLastCellInDirection);
    }

    private boolean isWhite(ToCoordinateParser lastCellOnMove) {
        return new Board().getItemFromCoordinate(lastCellOnMove) instanceof WhiteFigure;
    }

    private boolean isBlack(ToCoordinateParser lastCellOnMove) {
        return new Board().getItemFromCoordinate(lastCellOnMove) instanceof BlackFigure;
    }

    private boolean isWhiteMove(ToCoordinateParser figurePos) {
        return new Board().getItemFromCoordinate(figurePos) instanceof WhiteFigure;
    }

    private boolean isBlackMove(ToCoordinateParser figurePos) {
        return new Board().getItemFromCoordinate(figurePos) instanceof BlackFigure;
    }

    private boolean lastCellNotEmpty(int count, int cellsCount) {
        return count == (cellsCount - 1);
    }
}
