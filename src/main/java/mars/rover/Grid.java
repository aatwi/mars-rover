package mars.rover;

public final class Grid {

    private final int height;
    private final int width;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
