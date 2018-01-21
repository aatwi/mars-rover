package mars.rover.instructions;

public class InstructionFactory {

    public static final String LEFT = "L";
    public static final String RIGHT = "R";
    public static final String MOVE = "M";

    public static Instruction getInstruction(String instruction) {
        switch (instruction) {
            case LEFT:
                return new LeftRotation();
            case RIGHT:
                return new RightRotation();
            case MOVE:
                return new ForwardMovement();
            default:
                throw new UnsupportedOperationException();
        }
    }
}
