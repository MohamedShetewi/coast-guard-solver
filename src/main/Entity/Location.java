package main.Entity;

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


    public String toString() {
        return this.x + "," + this.y;
    }
}
