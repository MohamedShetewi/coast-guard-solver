package code.Entity;

import java.util.Objects;

public class Location {
    private int x, y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location that = (Location) o;
        return x == that.x && y == that.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Location(this.x, this.y);
    }

    public String toString() {
        return this.x + "," + this.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
