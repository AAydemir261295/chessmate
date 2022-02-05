package Engine.Directions.Straight;

import ChessItems.BlackFigures.BlackFigure;
import ChessItems.Items.Board;
import ChessItems.Items.Cells;
import ChessItems.WhiteFigures.WhiteFigure;
import Engine.ToCoordinateParser;

import java.util.ArrayList;

public class CheckCellsForEmptySTR {

    // проверка клеток на пустоту по прямой линии хода
    // подсчет клеток на пути
    // проверка каждой клетки на пустоту
    // если на последней клетке противник то ход возможен
    public boolean upDirectionIsEmpty(ToCoordinateParser figurePosition, ToCoordinateParser figureMove) {
        StraightCellsOnDirection cellsOnDirection = new StraightCellsOnDirection();
        ArrayList<ToCoordinateParser> tmp = cellsOnDirection.getUpCells(figurePosition, figureMove);

        int cellsCount = tmp.size();
        int counter = 0;

        for (int i = 0; i < cellsCount; i++) {
            ToCoordinateParser onPosition = tmp.get(i);
            if (isCell(onPosition)) {
                counter++;
                if (allCellsIsEmpty(counter, cellsCount)) {
                    return true;
                }
            } else if (lastCellNotEmpty(counter, cellsCount) &&
                    onLastCellOpponent(figurePosition, onPosition)) {
                return true;
            }
        }
        return false;
    }

    public boolean downDirectionIsEmpty(ToCoordinateParser figurePosition, ToCoordinateParser figureMove) {
        StraightCellsOnDirection cellsOnDirection = new StraightCellsOnDirection();
        ArrayList<ToCoordinateParser> tmp = cellsOnDirection.getDownCells(figurePosition, figureMove);

        int cellsCount = tmp.size();
        int counter = 0;

        for (int i = 0; i < cellsCount; i++) {
            ToCoordinateParser onPosition = cellsOnDirection.getDownCells(figurePosition, figureMove).get(i);
            if (isCell(onPosition)) {
                counter++;
                if (allCellsIsEmpty(counter, cellsCount)) {
                    return true;
                }
            } else if (lastCellNotEmpty(counter, cellsCount) &&
                    onLastCellOpponent(figurePosition, onPosition)) {
                return true;
            }
        }
        return false;
    }

    public boolean rightDirectionIsEmpty(ToCoordinateParser figurePosition, ToCoordinateParser figureMove) {
        StraightCellsOnDirection cellsOnDirection = new StraightCellsOnDirection();
        ArrayList<ToCoordinateParser> tmp = cellsOnDirection.getRightCells(figurePosition, figureMove);

        int cellsCount = tmp.size();
        int counter = 0;

        for (int i = 0; i < cellsCount; i++) {
            ToCoordinateParser onPosition = cellsOnDirection.getRightCells(figurePosition, figureMove).get(i);
            if (isCell(onPosition)) {
                counter++;
                if (allCellsIsEmpty(counter, cellsCount)) {
                    return true;
                }
            } else if (lastCellNotEmpty(counter, cellsCount) &&
                    onLastCellOpponent(figurePosition, onPosition)) {
                return true;
            }
        }
        return false;
    }

    public boolean leftDirectionIsEmpty(ToCoordinateParser figurePosition, ToCoordinateParser figureMove) {
        StraightCellsOnDirection cellsOnDirection = new StraightCellsOnDirection();
        ArrayList<ToCoordinateParser> tmp = cellsOnDirection.getLeftCells(figurePosition, figureMove);

        int cellsCount = tmp.size();
        int counter = 0;

        for (int i = 0; i < cellsCount; i++) {
            ToCoordinateParser onPosition = cellsOnDirection.getLeftCells(figurePosition, figureMove).get(i);
            if (isCell(onPosition)) {
                counter++;
                if (allCellsIsEmpty(counter, cellsCount)) {
                    return true;
                }
            } else if (lastCellNotEmpty(counter, cellsCount) &&
                    onLastCellOpponent(figurePosition, onPosition)) {
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

    private boolean onLastCellOpponent(ToCoordinateParser figurePosition, ToCoordinateParser onLastCellInDirection) {
        if (isWhiteMove(figurePosition) && isBlack(onLastCellInDirection)) {
            return true;
        } else return isBlackMove(figurePosition) && isWhite(onLastCellInDirection);
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
