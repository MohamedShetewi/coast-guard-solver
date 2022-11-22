package main.Entity;

public class Ship {
    private Location location;
    private int passengersCount;
    private int blackBoxHealth;

    public Ship(Location location, int passengersCount) {
        this.location = location;
        this.passengersCount = passengersCount;
        this.blackBoxHealth = 1;
    }
    public Ship(Location location, int passengersCount, int blackBoxHealth) {
        this.location = location;
        this.passengersCount = passengersCount;
        this.blackBoxHealth = blackBoxHealth;
    }

    public boolean isWreck() {
        return passengersCount == 0;
    }

    public boolean isBlackBoxDamaged() {
        return blackBoxHealth >= 20;
    }

    public Location getLocation() {
        return location;
    }

    public int getPassengersCount() {
        return passengersCount;
    }

    public int getBlackBoxHealth() {
        return blackBoxHealth;
    }
}
