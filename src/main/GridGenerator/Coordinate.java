package main.GridGenerator;

public class Coordinate {
    private int x, y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public String toString() {
        return this.x + ","+ this.y;
    }
}
