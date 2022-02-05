package ChessItems.BlackFigures.Castle;

import ChessItems.BlackFigures.BlackFigure;
import Engine.Moveable;

public abstract class B_Castle extends BlackFigure implements Moveable {
    // для более гибкого использование Ладьи
    public B_Castle(int x, int y, String cellColor, String figure, int moveCounter) {
        super(x, y, cellColor, figure, moveCounter);
    }

    public B_Castle() {
    }
}
