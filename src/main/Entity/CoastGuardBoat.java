package main.Entity;

public class CoastGuardBoat {
    private Location location;
    private int maxPassengersCapacity;
    private int currentCapacity;

    public CoastGuardBoat(Location location, int maxPassengersCapacity) {
        this.location = location;
        this.maxPassengersCapacity = maxPassengersCapacity;
    }
}
