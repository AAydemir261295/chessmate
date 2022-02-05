package ChessItems.WhiteFigures.King;

import ChessItems.Items.Board;
import ChessItems.WhiteFigures.Castle.WhiteCastle;
import Engine.CheckCellForAttack;
import Engine.Directions.Straight.CheckCellsForCastling;
import Engine.Directions.Straight.StraightDirection;
import Engine.ToCoordinateParser;

public class WhiteKingCastling {

    public boolean isCastleable(ToCoordinateParser kingPos, ToCoordinateParser castlePos) {
        StraightDirection direction = new StraightDirection();
        CheckCellsForCastling cellsOnDirectionForCastling = new CheckCellsForCastling();

        if (direction.isLeftDirection(kingPos, castlePos) && cellsOnDirectionForCastling.leftDirectionIsEmpty(kingPos, castlePos)
                && !(leftCastlingIsUnderAttack(kingPos)) && figuresNotMoved(kingPos, castlePos)) {
            return true;
        } else
            return direction.isRightDirection(kingPos, castlePos) && cellsOnDirectionForCastling.rightDirectionIsEmpty(kingPos, castlePos)
                    && !(rightCastlingIsUnderAttack(kingPos) && figuresNotMoved(kingPos, castlePos));
    }

    private boolean leftCastlingIsUnderAttack(ToCoordinateParser kingPos) {
        Board board = new Board();
        CheckCellForAttack x = new CheckCellForAttack();
        int index = board.getIndexOfCoordinate(kingPos) - 2;
        ToCoordinateParser futureKingCoord = board.getCoordinate(index);
        if (x.cellIsUnderBlackAttack(futureKingCoord)) {
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
        if (x.cellIsUnderBlackAttack(futureKingCoord)) {
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
        return board.getItemFromCoordinate(figurePos) instanceof WhiteKing &&
                ((WhiteKing) board.getItemFromCoordinate(figurePos)).getMoveCounter() == 0;
    }

    private boolean castleIsNotMoved(ToCoordinateParser movePos) {
        Board board = new Board();
        return board.getItemFromCoordinate(movePos) instanceof WhiteCastle &&
                ((WhiteCastle) board.getItemFromCoordinate(movePos)).getMoveCounter() == 0;
    }
}
