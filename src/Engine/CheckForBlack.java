package Engine;

import ChessItems.BlackFigures.King.BlackKing;
import ChessItems.Items.Board;
import ChessItems.Items.ChessItem;
import ChessItems.WhiteFigures.WhiteFigure;

public class CheckForBlack {
    //Проверка на шах для черных фигур
    private static int isCheck = 0;

    public int isCheck() {
        Board board = new Board();
        int boardSize = board.getBoard().size();
        ToCoordinateParser kingPos = getKingPos();
        // перебор всех фигур
        // если фигура противника
        // проверяем смотрит ли она на короля
        for (int i = 0; i < boardSize; i++) {
            ToCoordinateParser opponentPosition = board.getCoordinate(i);
            ChessItem opponentFigure = board.getItemFromCoordinate(opponentPosition);
            if (isWhite(opponentFigure) && opponentFigure.getDirection().checkDirection(opponentPosition, kingPos) == 1) {
                isCheck = 1;
                System.out.println("Шах черным!");
                return isCheck;
            }
        }
        return isCheck = 0;
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
        return new Board().getItemFromCoordinate(position);
    }

    private boolean isBlackKing(ChessItem figure) {
        return figure instanceof BlackKing;
    }

    private boolean isWhite(ChessItem figure) {
        return figure instanceof WhiteFigure;
    }

    public int getIsCheck() {
        return isCheck;
    }
}
