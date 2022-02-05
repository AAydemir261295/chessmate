package Engine.Mate;

import ChessItems.BlackFigures.King.BlackKing;
import ChessItems.Items.Board;
import ChessItems.Items.ChessItem;
import ChessItems.WhiteFigures.WhiteFigure;
import Engine.ToCoordinateParser;

public class MateForBlack {

    // проверяем есть ли клетки не под угрозой удара
    // проверяем можно ли спастись за счет фигур не трогая короля
    public boolean isMate(ToCoordinateParser checkFigurePosition) {
        ToCoordinateParser kingPos = getKingPos();
        CheckCellsForWhiteAttack checkOrMate = new CheckCellsForWhiteAttack();
        BlackSave blackSave = new BlackSave();
        if(checkOrMate.emptyCellsUnderAttack(kingPos) && !(blackSave.possibleSave(checkFigurePosition, kingPos))){
            System.out.println("Мат черным!");
            return true;
        }
        return false;
    }

    private ToCoordinateParser getKingPos() {
        Board board = new Board();
        for (int i = 0; i < board.getBoard().size(); i++) {
            ToCoordinateParser onPosition = board.getCoordinate(i);
            if (isBlackKing(getFigure(onPosition))) {
                return onPosition;
            }
        }
        return null;
    }

    private ChessItem getFigure(ToCoordinateParser position) {
        Board board = new Board();
        return board.getItemFromCoordinate(position);
    }

    private boolean isBlackKing(ChessItem figure) {
        return figure instanceof BlackKing;
    }
}
