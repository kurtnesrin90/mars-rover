package Base;

public class Position {
    private int x;
    private int y;
    private CompassDirection facing;

    public Position(int x, int y, CompassDirection facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    @Override
    public String toString() {
        return "Base.Position{" +
                "x=" + x +
                ", y=" + y +
                ", facing=" + facing +
                '}';
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public CompassDirection getFacing() {
        return facing;
    }
}
