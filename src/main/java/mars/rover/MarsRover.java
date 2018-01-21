package mars.rover;

import com.google.common.collect.Lists;
import mars.rover.instructions.Instruction;

import java.util.ArrayList;
import java.util.Objects;

import static mars.rover.instructions.InstructionFactory.getInstruction;

public final class MarsRover {
    private Position position;
    private Direction direction;
    private Grid grid;

    public MarsRover(Position position, Direction direction, Grid grid) {
        this.position = position;
        this.direction = direction;
        this.grid = grid;
    }

    public void moveRover(String instructionString) {
        ArrayList<String> instructions = Lists.newArrayList(instructionString.split(""));
        instructions.forEach(instruction -> singleInstructionMove(getInstruction(instruction)));
    }

    void singleInstructionMove(Instruction instruction) {
        this.direction = instruction.rotate(direction);
        this.position = instruction.move(grid, position, direction);
    }

    public Position position() {
        return position;
    }

    public Direction direction() {
        return direction;
    }

    @Override
    public String toString() {
        return "MarsRover{" +
                "position=" + position +
                ", direction=" + direction +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarsRover marsRover = (MarsRover) o;
        return Objects.equals(position, marsRover.position) &&
                direction == marsRover.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }


}
