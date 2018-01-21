package mars.rover.instructions;

import mars.rover.Grid;
import mars.rover.Position;
import mars.rover.Direction;
import org.fest.assertions.Assertions;
import org.junit.Test;

import static mars.rover.Direction.*;
import static org.fest.assertions.Assertions.assertThat;

public class ForwardMovementTest {

    private ForwardMovement forwardMovement = new ForwardMovement();
    private final Grid GRID = new Grid(5, 5);

    @Test
    public void
    it_should_move_the_rover_one_cell_to_the_right() {
        assertNewPosition(EAST, new Position(4, 3));
    }

    @Test
    public void
    it_should_move_the_rover_one_cell_to_the_left() {
        assertNewPosition(WEST, new Position(2, 3));
    }

    @Test
    public void
    it_should_move_the_rover_one_cell_upwards() {
        assertNewPosition(NORTH, new Position(3, 4));
    }

    @Test
    public void
    it_should_move_the_rover_one_cell_downwards() {
        assertNewPosition(SOUTH, new Position(3, 2));
    }

    @Test
    public void
    it_should_not_move_the_rover_NORTH_if_next_cell_is_out_of_bound() {
        Position initialPosition = new Position(1, 5);
        Position newPosition = forwardMovement.move(GRID, initialPosition, NORTH);
        assertThat(newPosition).isEqualTo(initialPosition);
    }

    @Test
    public void
    it_should_not_move_the_rover_SOUTH_if_next_cell_is_out_of_bound() {
        Position initialPosition = new Position(1, 0);
        Position newPosition = forwardMovement.move(GRID, initialPosition, SOUTH);
        assertThat(newPosition).isEqualTo(initialPosition);
    }

    @Test
    public void
    it_should_not_move_the_rover_WEST_if_next_cell_is_out_of_bound() {
        Position initialPosition = new Position(0, 1);
        Position newPosition = forwardMovement.move(GRID, initialPosition, WEST);
        assertThat(newPosition).isEqualTo(initialPosition);
    }

    @Test
    public void
    it_should_not_move_the_rover_EAST_if_next_cell_is_out_of_bound() {
        Position initialPosition = new Position(5, 1);
        Position newPosition = forwardMovement.move(GRID, initialPosition, EAST);
        assertThat(newPosition).isEqualTo(initialPosition);
    }

    private void assertNewPosition(Direction direction, Position expected) {
        Position initialPosition = new Position(3, 3);
        Position newPosition = forwardMovement.move(GRID, initialPosition, direction);
        assertThat(newPosition).isEqualTo(expected);
    }

    @Test
    public void
    it_should_return_the_same_direction_when_nextDirection_is_called() {
        Assertions.assertThat(forwardMovement.rotate(EAST)).isEqualTo(EAST);
    }

}