package code.Entity;

import java.util.Objects;

public class Location {
    private int i, j;

    public Location(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location that = (Location) o;
        return i == that.i && j == that.j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Location(this.i, this.j);
    }

    public String toString() {
        return this.i + "," + this.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }


}
