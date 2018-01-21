package mars.rover.instructions;

import mars.rover.Direction;

public final class RightRotation implements Instruction {

    public RightRotation() {
    }

    @Override
    public Direction rotate(Direction direction) {
        return direction.rotateRight();
    }
}
