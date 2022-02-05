package ChessItems.BlackFigures;


import ChessItems.Items.ChessItem;

public abstract class BlackFigure extends ChessItem {

    public BlackFigure(int x, int y, String cellColor, String figure) {
        super(x, y, cellColor, figure);
    }

    public BlackFigure() {
    }

    public BlackFigure(int x, int y, String cellColor, String figure, int moveCounter) {
        super(x, y, cellColor, figure, moveCounter);
    }
}
