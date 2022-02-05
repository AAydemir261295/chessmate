package Engine;

import Engine.Directions.Diagonal.DiagonalDirection;
import Engine.Directions.Straight.StraightDirection;
import Engine.ToCoordinateParser;

public interface HasDirection {

    int checkDirection(ToCoordinateParser before, ToCoordinateParser after);

}
