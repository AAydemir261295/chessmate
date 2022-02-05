package Engine.Mate;

import ChessItems.Items.Board;
import ChessItems.Items.ChessItem;
import ChessItems.WhiteFigures.WhiteFigure;
import Engine.Directions.Diagonal.DiagonalCellsOnDirection;
import Engine.Directions.Straight.StraightCellsOnDirection;
import Engine.ToCoordinateParser;

import java.util.ArrayList;

public class WhiteSave {

    // если возможен мат
    // перебираем фигуры противника
    // проверяем может ли какая нибудь из них перекрыть путь от мата
    // или сбить фигуру
    public boolean possibleSave(ToCoordinateParser checkFigurePosition, ToCoordinateParser kingPosition) {
        Board board = new Board();
        int boardSize = board.getBoard().size();
        ChessItem checkItem = board.getItemFromCoordinate(checkFigurePosition);
        ArrayList<ToCoordinateParser> cellsOnDirection = getCellsOnFigureDirection(checkFigurePosition, kingPosition, checkItem);

        for (int i = 0; i < boardSize; i++) {
            ToCoordinateParser figureOnPosition = board.getCoordinate(i);
            if (isWhite(figureOnPosition)) {
                ChessItem whiteFigure = board.getItemFromCoordinate(figureOnPosition);
                if (figureCanBeatOrShut(whiteFigure, figureOnPosition, checkFigurePosition)) {
                    return true;
                }
                for (ToCoordinateParser possibleMove : cellsOnDirection) {
                    if (figureCanBeatOrShut(whiteFigure, figureOnPosition, possibleMove)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isWhite(ToCoordinateParser figurePosition) {
        return new Board().getItemFromCoordinate(figurePosition) instanceof WhiteFigure;
    }

    private boolean figureCanBeatOrShut(ChessItem item, ToCoordinateParser figureOnPosition, ToCoordinateParser movePosition) {
        return item.getDirection().checkDirection(figureOnPosition, movePosition) == 1;
    }

    private ArrayList<ToCoordinateParser> getCellsOnDiagonalDirection(ToCoordinateParser figurePosition,
                                                                      ToCoordinateParser kingPosition,
                                                                      ChessItem item) {
        if (item.getDiagonal().isLeftDownDirection(figurePosition, kingPosition)) {
            DiagonalCellsOnDirection emptyCells = new DiagonalCellsOnDirection();
            return emptyCells.getLeftDownCells(figurePosition, kingPosition);
        } else if (item.getDiagonal().isLeftUpDirection(figurePosition, kingPosition)) {
            DiagonalCellsOnDirection emptyCells = new DiagonalCellsOnDirection();
            return emptyCells.getLeftUpCells(figurePosition, kingPosition);
        } else if (item.getDiagonal().isRightDownDirection(figurePosition, kingPosition)) {
            DiagonalCellsOnDirection emptyCells = new DiagonalCellsOnDirection();
            return emptyCells.getRightDownCells(figurePosition, kingPosition);
        } else if (item.getDiagonal().isRightUpDirection(figurePosition, kingPosition)) {
            DiagonalCellsOnDirection emptyCells = new DiagonalCellsOnDirection();
            return emptyCells.getRightUpCells(figurePosition, kingPosition);
        }
        return new ArrayList<>();
    }

    private ArrayList<ToCoordinateParser> getCellsOnStraightDirection(ToCoordinateParser figurePosition,
                                                                      ToCoordinateParser kingPosition,
                                                                      ChessItem item) {
        if (item.getStraight().isRightDirection(figurePosition, kingPosition)) {
            StraightCellsOnDirection emptyCells = new StraightCellsOnDirection();
            return emptyCells.getRightCells(figurePosition, kingPosition);
        } else if (item.getStraight().isLeftDirection(figurePosition, kingPosition)) {
            StraightCellsOnDirection emptyCells = new StraightCellsOnDirection();
            return emptyCells.getLeftCells(figurePosition, kingPosition);
        } else if (item.getStraight().isDownDirection(figurePosition, kingPosition)) {
            StraightCellsOnDirection emptyCells = new StraightCellsOnDirection();
            return emptyCells.getDownCells(figurePosition, kingPosition);
        } else if (item.getStraight().isUpDirection(figurePosition, kingPosition)) {
            StraightCellsOnDirection emptyCells = new StraightCellsOnDirection();
            return emptyCells.getUpCells(figurePosition, kingPosition);
        }
        return new ArrayList<>();
    }

    private ArrayList<ToCoordinateParser> getCellsOnFigureDirection(ToCoordinateParser checkFigurePosition,
                                                                    ToCoordinateParser kingPosition,
                                                                    ChessItem checkItem) {
        ArrayList<ToCoordinateParser> diagonal = getCellsOnDiagonalDirection(checkFigurePosition, kingPosition, checkItem);
        ArrayList<ToCoordinateParser> straight = getCellsOnStraightDirection(checkFigurePosition, kingPosition, checkItem);

        if (diagonal.size() > 0) {
            return diagonal;
        } else {
            return straight;
        }
    }
}
