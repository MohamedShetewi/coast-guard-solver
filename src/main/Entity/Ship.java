package main.Entity;

public class Ship {
    private Location location;
    private int passengersCount;
    private int blackBoxHealth;

    public Location getLocation() {
        return location;
    }

    public int getPassengersCount() {
        return passengersCount;
    }

    public int getBlackBoxHealth() {
        return blackBoxHealth;
    }

    public boolean isWrecked() {
        return isWrecked;
    }

    private boolean isWrecked;

    public Ship(Location location, int passengersCount) {
        this.location = location;
        this.passengersCount = passengersCount;
        this.blackBoxHealth = 1;
        this.isWrecked = false;
    }
}
