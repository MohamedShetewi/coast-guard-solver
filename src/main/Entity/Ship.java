package main.Entity;

import java.util.Objects;

public class Ship {
    private Location location;
    private int passengersCount;
    private int blackBoxDamage;
    private boolean isBlackBoxRetrieved;

    public Ship(Location location, int passengersCount) {
        this.location = location;
        this.passengersCount = passengersCount;
        this.blackBoxDamage = 1;
        this.isBlackBoxRetrieved = false;
    }

    public Ship(Location location, int passengersCount, int blackBoxDamage, boolean isBlackBoxRetrieved) {
        this.location = location;
        this.passengersCount = passengersCount;
        this.blackBoxDamage = blackBoxDamage;
        this.isBlackBoxRetrieved = isBlackBoxRetrieved;
    }

    public boolean isWreck() {
        return passengersCount == 0;
    }

    public boolean isBlackBoxRetrievable() {
        return isWreck() && !isBlackBoxRetrieved && blackBoxDamage < 20;
    }

    public Location getLocation() {
        return location;
    }

    public int getPassengersCount() {
        return passengersCount;
    }

    public int getBlackBoxDamage() {
        return blackBoxDamage;
    }

    public boolean isBlackBoxRetrieved() {
        return isBlackBoxRetrieved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return passengersCount == ship.passengersCount && blackBoxDamage == ship.blackBoxDamage && isBlackBoxRetrieved == ship.isBlackBoxRetrieved && location.equals(ship.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, passengersCount, blackBoxDamage, isBlackBoxRetrieved);
    }
}
