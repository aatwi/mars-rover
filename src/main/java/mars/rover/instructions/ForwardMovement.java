package mars.rover.instructions;

import mars.rover.Grid;
import mars.rover.Position;
import mars.rover.Direction;

import static mars.rover.Direction.*;

public final class ForwardMovement implements Instruction {

    public ForwardMovement() {
    }

    @Override
    public Position move(Grid grid, Position currentPosition, Direction direction) {
        int newYPosition = nextYPosition(direction, currentPosition.yPosition(), grid);
        int newXPosition = nextXPosition(direction, currentPosition.xPosition(), grid);
        return new Position(newXPosition, newYPosition);
    }

    private int nextYPosition(Direction direction, int yPosition, Grid grid) {
        int movement = 0;
        if (direction.equals(NORTH) && grid.getHeight() > yPosition) {
            movement = 1;
        } else if (direction.equals(SOUTH) && yPosition > 0) {
            movement = -1;
        }
        return yPosition + movement;
    }

    private int nextXPosition(Direction direction, int xPosition, Grid grid) {
        int movement = 0;
        if (direction.equals(EAST) && grid.getWidth() > xPosition) {
            movement = 1;
        } else if (direction.equals(WEST) && xPosition > 0) {
            movement = -1;
        }
        return xPosition + movement;
    }
}
