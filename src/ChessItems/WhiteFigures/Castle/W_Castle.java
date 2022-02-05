package ChessItems.WhiteFigures.Castle;

import ChessItems.WhiteFigures.WhiteFigure;

public abstract class W_Castle extends WhiteFigure {

    public W_Castle() {
    }

    public W_Castle(int x, int y, String cellColor, String figure, int moveCounter) {
        super(x, y, cellColor, figure, moveCounter);
    }
}

