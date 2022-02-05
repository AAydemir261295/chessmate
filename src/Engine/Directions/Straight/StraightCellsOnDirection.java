package Engine.Directions.Straight;

import Engine.ToCoordinateParser;

import java.util.ArrayList;

public class StraightCellsOnDirection {

    // подсчет кол-во клеток на пути по прямой линии хода
    public ArrayList<ToCoordinateParser> getUpCells(ToCoordinateParser figurePosition, ToCoordinateParser movePosition) {
        ArrayList<ToCoordinateParser> cells = new ArrayList<>();
        int cellsOnUpDownDirection = Math.abs(figurePosition.getY() - movePosition.getY());
        ToCoordinateParser cell = figurePosition;

        for (int i = 0; i < cellsOnUpDownDirection; i++) {
            int y = cell.getY() + i + 1;
            ToCoordinateParser tmpCell = new ToCoordinateParser(figurePosition.getX(), y);
            cells.add(tmpCell);
        }
        return cells;
    }

    public ArrayList<ToCoordinateParser> getDownCells(ToCoordinateParser figurePosition, ToCoordinateParser movePosition) {
        ArrayList<ToCoordinateParser> cells = new ArrayList<>();
        int cellsOnUpDownDirection = Math.abs(figurePosition.getY() - movePosition.getY());
        ToCoordinateParser cell = figurePosition;

        for (int i = 0; i < cellsOnUpDownDirection; i++) {
            int y = cell.getY() - i - 1;
            ToCoordinateParser tmpCell = new ToCoordinateParser(figurePosition.getX(), y);
            cells.add(tmpCell);
        }
        return cells;
    }

    public ArrayList<ToCoordinateParser> getRightCells(ToCoordinateParser figurePosition, ToCoordinateParser movePosition) {
        ArrayList<ToCoordinateParser> cells = new ArrayList<>();
        int cellsOnRightLeftDirection = Math.abs(figurePosition.getX() - movePosition.getX());
        ToCoordinateParser cell = figurePosition;

        for (int i = 0; i < cellsOnRightLeftDirection; i++) {
            int x = cell.getX() + 1 + i;
            ToCoordinateParser tmpCell = new ToCoordinateParser(x, figurePosition.getY());
            cells.add(tmpCell);
        }
        return cells;
    }

    public ArrayList<ToCoordinateParser> getLeftCells(ToCoordinateParser figurePosition, ToCoordinateParser movePosition) {
        ArrayList<ToCoordinateParser> cells = new ArrayList<>();
        int cellsOnRightLeftDirection = Math.abs(figurePosition.getX() - movePosition.getX());
        ToCoordinateParser cell = figurePosition;

        for (int i = 0; i < cellsOnRightLeftDirection; i++) {
            int x = cell.getX() - 1 - i;
            ToCoordinateParser tmpCell = new ToCoordinateParser(x, figurePosition.getY());
            cells.add(tmpCell);
        }
        return cells;
    }
}
