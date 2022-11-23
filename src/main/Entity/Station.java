package main.Entity;

import java.util.Objects;

public class Station {

    private Location location;
    private int passengersCount;

    public Station(Location location) {
        this.location = location;
        this.passengersCount = 0;
    }

    public Station(Location location, int passengersCount) {
        this.location = location;
        this.passengersCount = passengersCount;
    }
    public Location getLocation() {
        return location;
    }

    public int getPassengersCount() {
        return passengersCount;
    }

    public void setPassengersCount(int passengersCount) {
        this.passengersCount = passengersCount;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Station((Location)this.location.clone(), this.passengersCount);
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return passengersCount == station.passengersCount && location.equals(station.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, passengersCount);
    }
}
