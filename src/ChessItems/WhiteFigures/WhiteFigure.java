package ChessItems.WhiteFigures;

import ChessItems.Items.ChessItem;

public abstract class WhiteFigure extends ChessItem {

    public WhiteFigure(int x, int y, String cellColor, String figure, int moveCounter) {
        super(x, y, cellColor, figure, moveCounter);
    }

    public WhiteFigure(int x, int y, String cellColor, String figure) {
        super(x, y, cellColor, figure);
    }

    public WhiteFigure() {
    }
}
