package Engine;

import ChessItems.BlackFigures.BlackFigure;
import ChessItems.Items.Board;
import ChessItems.Items.ChessItem;
import ChessItems.WhiteFigures.King.WhiteKing;

public class CheckForWhite {
    // проверка всех фигур
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
            if (isBlack(opponentFigure) && opponentFigure.getDirection().checkDirection(opponentPosition, kingPos) == 1) {
                isCheck = 1;
                System.out.println("Шах белым!");
                return isCheck;
            }
        }

        return isCheck = 0;
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
        return new Board().getItemFromCoordinate(position);
    }

    private boolean isWhiteKing(ChessItem figure) {
        return figure instanceof WhiteKing;
    }

    private boolean isBlack(ChessItem figure) {
        return figure instanceof BlackFigure;
    }

    public int getIsCheck() {
        return isCheck;
    }
}
