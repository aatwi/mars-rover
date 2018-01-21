package mars.rover.instructions;

import mars.rover.Grid;
import mars.rover.Position;
import org.junit.Test;

import static mars.rover.Direction.EAST;
import static org.fest.assertions.Assertions.assertThat;

public class RightRotationTest {

    @Test
    public void
    it_should_not_change_the_position_when_nextPosition_is_called() {
        RightRotation rightRotation = new RightRotation();
        Position currentPosition = new Position(0, 0);
        assertThat(rightRotation.move(new Grid(2, 3), currentPosition, EAST))
                .isEqualTo(currentPosition);
    }
}