package main.Entity;

import java.util.Objects;

public class CoastGuardBoat {
    private Location location;
    private int maxPassengersCapacity;
    private int currentCapacity;

    public CoastGuardBoat(Location location, int maxPassengersCapacity) {
        this.location = location;
        this.maxPassengersCapacity = maxPassengersCapacity;
    }

    public CoastGuardBoat(Location location, int maxPassengersCapacity, int currentCapacity) {
        this.location = location;
        this.currentCapacity = currentCapacity;
        this.maxPassengersCapacity = maxPassengersCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoastGuardBoat that = (CoastGuardBoat) o;
        return maxPassengersCapacity == that.maxPassengersCapacity && currentCapacity == that.currentCapacity && location.equals(that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, maxPassengersCapacity, currentCapacity);
    }

    public int getMaxPassengersCapacity() {
        return maxPassengersCapacity;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new CoastGuardBoat((Location) this.location.clone(), this.maxPassengersCapacity, this.currentCapacity);
    }
}
