package mars.rover;

public enum Direction {

    NORTH {
        @Override
        public Direction rotateLeft() {
            return WEST;
        }

        @Override
        public Direction rotateRight() {
            return EAST;
        }
    },
    SOUTH {
        @Override
        public Direction rotateLeft() {
            return EAST;
        }

        @Override
        public Direction rotateRight() {
            return WEST;
        }
    },
    EAST {
        @Override
        public Direction rotateLeft() {
            return NORTH;
        }

        @Override
        public Direction rotateRight() {
            return SOUTH;
        }
    },
    WEST {
        @Override
        public Direction rotateLeft() {
            return SOUTH;
        }

        @Override
        public Direction rotateRight() {
            return NORTH;
        }
    };

    public abstract Direction rotateLeft();

    public abstract Direction rotateRight();
}
