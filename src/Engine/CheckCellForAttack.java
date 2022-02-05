package Engine;

import ChessItems.BlackFigures.BlackFigure;
import ChessItems.Items.Board;
import ChessItems.Items.ChessItem;
import ChessItems.WhiteFigures.WhiteFigure;

import java.util.function.BinaryOperator;

public class CheckCellForAttack {
    // проверка клетки не находится ли она под ударом противника

    public boolean cellIsUnderWhiteAttack(ToCoordinateParser toTestCell){
        Board board = new Board();
        int size = board.getBoard().size();
        for (int i = 0; i < size; i++) {
            ToCoordinateParser onPosition = board.getCoordinate(i);
            ChessItem item = board.getItemFromCoordinate(onPosition);
            if(isWhite(item) && moveIsPossible(item, onPosition, toTestCell)){
                return true;
            }
        }
        return false;
    }

    public boolean cellIsUnderBlackAttack(ToCoordinateParser toTestCell){
        Board board = new Board();
        int size = board.getBoard().size();
        for (int i = 0; i < size; i++) {
            ToCoordinateParser onPosition = board.getCoordinate(i);
            ChessItem item = board.getItemFromCoordinate(onPosition);
            if(isBlack(item) && moveIsPossible(item, onPosition, toTestCell)){
                return true;
            }
        }
        return false;
    }

    private boolean moveIsPossible(ChessItem item, ToCoordinateParser figurePosition, ToCoordinateParser movePosition){
        return item.getDirection().checkDirection(figurePosition, movePosition) == 1;
    }

    private boolean isWhite(ChessItem item){
        return item instanceof WhiteFigure;
    }

    private boolean isBlack(ChessItem item){
        return item instanceof BlackFigure;
    }
}
