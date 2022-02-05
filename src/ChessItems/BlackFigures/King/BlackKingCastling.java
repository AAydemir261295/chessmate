package ChessItems.BlackFigures.King;

import ChessItems.BlackFigures.Castle.BlackCastle;
import ChessItems.Items.Board;
import Engine.CheckCellForAttack;
import Engine.Directions.Straight.CheckCellsForCastling;
import Engine.Directions.Straight.StraightDirection;
import Engine.ToCoordinateParser;

public class BlackKingCastling {
    // проверка всех условий для рокировки
    // если ничего не препятсвует и ладья и король были нетронуты
    public boolean isCastleable(ToCoordinateParser kingPos, ToCoordinateParser castlePos) {
        StraightDirection direction = new StraightDirection();
        CheckCellsForCastling cellsOn = new CheckCellsForCastling();

        if (direction.isLeftDirection(kingPos, castlePos) && cellsOn.leftDirectionIsEmpty(kingPos, castlePos)
                && !(leftCastlingIsUnderAttack(kingPos)) && figuresNotMoved(kingPos, castlePos)) {
            return true;
        } else
            return (direction.isRightDirection(kingPos, castlePos) && cellsOn.rightDirectionIsEmpty(kingPos, castlePos)
                    && !(rightCastlingIsUnderAttack(kingPos)) && figuresNotMoved(kingPos, castlePos));
    }

    // если клетка на которую король встанет после рокировки
    // будет под ударом противника рокировка невозможна
    private boolean leftCastlingIsUnderAttack(ToCoordinateParser kingPos) {
        Board board = new Board();
        CheckCellForAttack x = new CheckCellForAttack();
        int index = board.getIndexOfCoordinate(kingPos) - 2;
        ToCoordinateParser futureKingCoord = board.getCoordinate(index);
        if (x.cellIsUnderWhiteAttack(futureKingCoord)) {
            System.out.println("рокировочная клетка под ударом!");
            return true;
        }
        return false;
    }

    private boolean rightCastlingIsUnderAttack(ToCoordinateParser kingPos) {
        Board board = new Board();
        CheckCellForAttack x = new CheckCellForAttack();
        int index = board.getIndexOfCoordinate(kingPos) - 1;
        ToCoordinateParser futureKingCoord = board.getCoordinate(index);
        if (x.cellIsUnderWhiteAttack(futureKingCoord)) {
            System.out.println("рокировочная клетка под ударом!");
            return true;
        }
        return false;
    }

    private boolean figuresNotMoved(ToCoordinateParser kingPos, ToCoordinateParser castlePos) {
        return castleIsNotMoved(castlePos) && kingIsNotMoved(kingPos);
    }

    private boolean kingIsNotMoved(ToCoordinateParser figurePos) {
        Board board = new Board();
        return board.getItemFromCoordinate(figurePos) instanceof BlackKing &&
                ((BlackKing) board.getItemFromCoordinate(figurePos)).getMoveCounter() == 0;
    }

    private boolean castleIsNotMoved(ToCoordinateParser movePos) {
        Board board = new Board();
        return board.getItemFromCoordinate(movePos) instanceof BlackCastle &&
                ((BlackCastle) board.getItemFromCoordinate(movePos)).getMoveCounter() == 0;
    }
}
