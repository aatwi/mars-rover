package mars.rover.instructions;

import mars.rover.Direction;

public final class LeftRotation implements Instruction {

    public LeftRotation() {
    }

    @Override
    public Direction rotate(Direction direction) {
        return direction.rotateLeft();
    }
}
