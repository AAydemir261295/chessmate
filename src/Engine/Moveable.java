package Engine;

import ChessItems.Items.ChessItem;

public interface Moveable {

    int move(ToCoordinateParser before, ToCoordinateParser after);
    
}
