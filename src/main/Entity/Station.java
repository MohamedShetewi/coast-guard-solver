package main.Entity;

public class Station {

    private Location location;
    private int passengersCount;

    public Station(Location location) {
        this.location = location;
        this.passengersCount = 0;
    }
    public Location getLocation() {
        return location;
    }

    public int getPassengersCount() {
        return passengersCount;
    }
}
