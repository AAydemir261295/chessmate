package Engine.Mate;

import ChessItems.BlackFigures.BlackFigure;
import ChessItems.Items.Board;
import ChessItems.Items.ChessItem;
import ChessItems.WhiteFigures.King.WhiteKing;
import ChessItems.WhiteFigures.WhiteFigure;
import Engine.ToCoordinateParser;

public class MateForWhite {

    public boolean isMate(ToCoordinateParser checkFigurePosition) {
        ToCoordinateParser whiteKingPos = getKingPos();
        CheckCellsForBlackAttack checkOrMate = new CheckCellsForBlackAttack();
        WhiteSave whiteSave = new WhiteSave();
        if(checkOrMate.emptyCellsUnderAttack(whiteKingPos) && !(whiteSave.possibleSave(checkFigurePosition, whiteKingPos))){
            System.out.println("Мат белым");
            return true;
        }
        return false;
    }

    private ToCoordinateParser getKingPos() {
        Board board = new Board();
        for (int i = 0; i < board.getBoard().size(); i++) {
            ToCoordinateParser onPosition = board.getCoordinate(i);
            if (isWhiteKing(getFigure(onPosition))) {
                return onPosition;
            }
        }
        return null;
    }

    private ChessItem getFigure(ToCoordinateParser position) {
        Board board = new Board();
        return board.getItemFromCoordinate(position);
    }

    private boolean isWhiteKing(ChessItem figure) {
        return figure instanceof WhiteKing;
    }

}
