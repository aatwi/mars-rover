package mars.rover;

import org.junit.Before;
import org.junit.Test;

import static mars.rover.Direction.*;
import static mars.rover.instructions.InstructionFactory.*;
import static org.fest.assertions.Assertions.assertThat;

public class MarsRoverTest {

    private final Grid GRID = new Grid(5, 5);;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void
    it_should_change_the_direction_from_NORTH_to_WEST_when_going_left() {
        assertRoverRotatesLeft(NORTH, WEST);
    }

    @Test
    public void
    it_should_change_the_direction_from_WEST_to_SOUTH_when_going_left() {
        assertRoverRotatesLeft(WEST, SOUTH);
    }

    @Test
    public void
    it_should_change_the_direction_from_SOUTH_to_EAST_when_going_left() {
        assertRoverRotatesLeft(SOUTH, EAST);
    }

    @Test
    public void
    it_should_change_the_direction_from_EAST_to_NORTH_when_going_left() {
        assertRoverRotatesLeft(EAST, NORTH);
    }

    @Test
    public void
    it_should_change_the_direction_from_North_to_East_when_going_right() {
        assertRoverRotatesRight(NORTH, EAST);
    }

    @Test
    public void
    it_should_change_the_direction_from_WEST_to_NORTH_when_going_right() {
        assertRoverRotatesRight(WEST, NORTH);
    }

    @Test
    public void
    it_should_change_the_direction_from_SOUTH_to_WEST_when_going_right() {
        assertRoverRotatesRight(SOUTH, WEST);
    }

    @Test
    public void
    it_should_change_the_direction_from_EAST_to_SOUTH_when_going_right() {
        assertRoverRotatesRight(EAST, SOUTH);
    }

    @Test
    public void
    it_should_move_the_rover_one_cell_to_the_EAST() {
        assertRoverNewPosition(EAST, 2, 2);
    }

    @Test
    public void
    it_should_move_the_rover_one_cell_to_the_WEST() {
        assertRoverNewPosition(WEST, 0, 2);
    }

    @Test
    public void
    it_should_move_the_rover_one_cell_to_the_NORTH() {
        assertRoverNewPosition(NORTH, 1, 3);
    }

    @Test
    public void
    it_should_move_the_rover_one_cell_to_the_SOUTH() {
        assertRoverNewPosition(SOUTH, 1, 1);
    }

    @Test
    public void
    it_should_move_the_rover_based_on_multiple_instructions_acceptance_test_1() {
        Position initialPosition = new Position(1, 2);
        MarsRover marsRover = new MarsRover(initialPosition, NORTH, new Grid(5, 5));
        marsRover.moveRover("LMLMLMLMM");

        assertThat(marsRover).isEqualTo(new MarsRover(new Position(1, 3), NORTH, new Grid(5, 5)));
    }

    @Test
    public void
    it_should_move_the_rover_based_on_multiple_instructions_acceptance_test_2() {
        Position initialPosition = new Position(3, 3);
        MarsRover marsRover = new MarsRover(initialPosition, EAST, new Grid(5, 5));
        marsRover.moveRover("MMRMMRMRRM");

        assertThat(marsRover).isEqualTo(new MarsRover(new Position(5, 1), EAST, new Grid(5, 5)));
    }

    private void assertRoverRotatesLeft(Direction initialDirection, Direction newDirection) {
        assertRoverNewDirection(initialDirection, LEFT, newDirection);
    }

    private void assertRoverRotatesRight(Direction initialDirection, Direction newDirection) {
        assertRoverNewDirection(initialDirection, RIGHT, newDirection);
    }

    private void assertRoverNewPosition(Direction roverDirection, int newXPosition, int newYPosition) {
        Position initialPosition = new Position(1, 2);
        MarsRover marsRover = new MarsRover(initialPosition, roverDirection, new Grid(5, 5));
        marsRover.singleInstructionMove(getInstruction(MOVE));

        assertThat(marsRover.position()).isEqualTo(new Position(newXPosition, newYPosition));
    }

    private void assertRoverNewDirection(Direction initialDirection, String instruction, Direction newDirection) {
        Position initialPosition = new Position(1, 2);
        MarsRover marsRover = new MarsRover(initialPosition, initialDirection, GRID);
        marsRover.singleInstructionMove(getInstruction(instruction));
        assertThat(marsRover.direction()).isEqualTo(newDirection);
    }
}