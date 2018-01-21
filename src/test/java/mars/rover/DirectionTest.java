package mars.rover;

import org.junit.Test;

import static mars.rover.Direction.*;
import static org.fest.assertions.Assertions.assertThat;

public class DirectionTest {
    @Test
    public void
    it_should_from_the_NORTH_to_the_EAST_when_going_right() {
        assertThat(NORTH.rotateRight()).isEqualTo(EAST);
    }

    @Test
    public void
    it_should_from_the_NORTH_to_the_WEST_when_going_left() {
        assertThat(NORTH.rotateLeft()).isEqualTo(WEST);
    }

    @Test
    public void
    it_should_from_the_EAST_to_the_SOUTH_when_going_right() {
        assertThat(EAST.rotateRight()).isEqualTo(SOUTH);
    }

    @Test
    public void
    it_should_from_the_EAST_to_the_NORTH_when_going_left() {
        assertThat(EAST.rotateLeft()).isEqualTo(NORTH);
    }

    @Test
    public void
    it_should_from_the_SOUTH_to_the_WEST_when_going_right() {
        assertThat(SOUTH.rotateRight()).isEqualTo(WEST);
    }

    @Test
    public void
    it_should_from_the_SOUTH_to_the_EAST_when_going_left() {
        assertThat(SOUTH.rotateLeft()).isEqualTo(EAST);
    }

    @Test
    public void
    it_should_from_the_WEST_to_the_NORTH_when_going_right() {
        assertThat(WEST.rotateRight()).isEqualTo(NORTH);
    }

    @Test
    public void
    it_should_from_the_WEST_to_the_SOUTH_when_going_left() {
        assertThat(WEST.rotateLeft()).isEqualTo(SOUTH);
    }
}