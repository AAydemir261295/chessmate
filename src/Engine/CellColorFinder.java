package Engine;

import ChessItems.Items.Board;
import ChessItems.Items.ChessItem;

public class CellColorFinder {
    // помогает отрисовать клетку в зависимости от цвета на которой стояля фигура
    public String getCellColor(ToCoordinateParser cellPosition) {
        Board board = new Board();
        ChessItem item = board.getItemFromCoordinate(cellPosition);

        if(cellIsBlack(item)){
            return "black";
        }
        else if(cellIsWhite(item)){
            return "white";
        }
        return "";
    }

    private boolean cellIsBlack(ChessItem item) {
        return item.getCellColor().equals("black");
    }

    private boolean cellIsWhite(ChessItem item) {
        return item.getCellColor().equals("white");
    }
}
