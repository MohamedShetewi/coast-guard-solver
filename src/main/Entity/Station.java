package main.Entity;

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
    }
}
