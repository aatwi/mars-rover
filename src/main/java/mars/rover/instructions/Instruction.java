package mars.rover.instructions;

import mars.rover.Grid;
import mars.rover.Position;
import mars.rover.Direction;

public interface Instruction {

    default Direction rotate(Direction direction) {
        return direction;
    }

    default Position move(Grid grid, Position currentPosition, Direction direction) {
        return currentPosition;
    }
}
