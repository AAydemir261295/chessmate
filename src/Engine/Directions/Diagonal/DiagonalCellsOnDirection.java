package Engine.Directions.Diagonal;

import Engine.ToCoordinateParser;

import java.util.ArrayList;

public class DiagonalCellsOnDirection {

    //подсчет количества клеток на пути
    public ArrayList<ToCoordinateParser> getLeftDownCells(ToCoordinateParser figurePosition, ToCoordinateParser movePosition) {
        ArrayList<ToCoordinateParser> cells = new ArrayList<>();
        int cellsOnDirection = Math.abs(figurePosition.getY() - movePosition.getY());

        for (int i = 1; i < cellsOnDirection + 1; i++) {
            ToCoordinateParser cell = new ToCoordinateParser(figurePosition.getX() - i, figurePosition.getY() - i);
            cells.add(cell);
        }
        return cells;
    }

    public ArrayList<ToCoordinateParser> getRightDownCells(ToCoordinateParser figurePosition, ToCoordinateParser movePosition) {
        ArrayList<ToCoordinateParser> cells = new ArrayList<>();
        int cellsOnDirection = Math.abs(figurePosition.getY() - movePosition.getY());

        for (int i = 1; i < cellsOnDirection + 1; i++) {
            ToCoordinateParser cell = new ToCoordinateParser(figurePosition.getX() + i, figurePosition.getY() - i);
            cells.add(cell);
        }
        return cells;
    }

    public ArrayList<ToCoordinateParser> getLeftUpCells(ToCoordinateParser figurePosition, ToCoordinateParser movePosition) {
        ArrayList<ToCoordinateParser> cells = new ArrayList<>();
        int cellsOnDirection = Math.abs(figurePosition.getY() - movePosition.getY());

        for (int i = 1; i < cellsOnDirection + 1; i++) {
            ToCoordinateParser cell = new ToCoordinateParser(figurePosition.getX() - i, figurePosition.getY() + i);
            cells.add(cell);
        }
        return cells;
    }

    public ArrayList<ToCoordinateParser> getRightUpCells(ToCoordinateParser figurePosition, ToCoordinateParser movePosition) {
        ArrayList<ToCoordinateParser> cells = new ArrayList<>();
        int cellsOnDirection = Math.abs(figurePosition.getY() - movePosition.getY());

        for (int i = 1; i < cellsOnDirection + 1; i++) {
            ToCoordinateParser cell = new ToCoordinateParser(figurePosition.getX() + i, figurePosition.getY() + i);
            cells.add(cell);
        }
        return cells;
    }


}
