package main.Problem;

import main.Entity.CoastGuardBoat;
import main.Entity.Location;

public class Move extends Operator {
    Direction direction;
    int gridWidth;
    int gridHeight;

    public Move(Direction direction, int gridWidth, int gridHeight) {
        this.direction = direction;
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
    }

    @Override
    public State performOperation(State state) throws CloneNotSupportedException {
        CoastGuardState oldState = (CoastGuardState) state;
        CoastGuardState newState = (CoastGuardState) oldState.clone();
        CoastGuardBoat coastGuardBoat = newState.getCoastGuardBoat();

        int xLocation = coastGuardBoat.getLocation().getX();
        int yLocation = coastGuardBoat.getLocation().getY();

        switch (direction) {
            case up:
                coastGuardBoat.setLocation(new Location(xLocation - 1, yLocation));
                break;
            case down:
                coastGuardBoat.setLocation(new Location(xLocation + 1, yLocation));
                break;
            case left:
                coastGuardBoat.setLocation(new Location(xLocation, yLocation - 1));
                break;
            case right:
                coastGuardBoat.setLocation(new Location(xLocation, yLocation + 1));
                break;
            default:
                break;
        }
        int deathCount = updateShips(newState);
        newState.setPassengersDeathCount(newState.getPassengersDeathCount() + deathCount);

        return newState;
    }

    @Override
    public boolean isValidOperation(State state) {
        CoastGuardState oldState = (CoastGuardState) state;
        CoastGuardBoat coastGuardBoat = oldState.getCoastGuardBoat();

        int xLocation = coastGuardBoat.getLocation().getX();
        int yLocation = coastGuardBoat.getLocation().getY();

        switch (direction) {
            case up:
                return xLocation - 1 >= 0;
            case down:
                return xLocation + 1 < gridHeight;
            case left:
                return yLocation - 1 >= 0;
            case right:
                return yLocation + 1 < gridWidth;
            default:
                return true;
        }
    }
}
