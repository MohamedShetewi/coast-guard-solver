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
            case UP:
                coastGuardBoat.setLocation(new Location(xLocation - 1, yLocation));
                break;
            case DOWN:
                coastGuardBoat.setLocation(new Location(xLocation + 1, yLocation));
                break;
            case LEFT:
                coastGuardBoat.setLocation(new Location(xLocation, yLocation - 1));
                break;
            case RIGHT:
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
            case UP:
                return xLocation - 1 >= 0;
            case DOWN:
                return xLocation + 1 < gridHeight;
            case LEFT:
                return yLocation - 1 >= 0;
            case RIGHT:
                return yLocation + 1 < gridWidth;
            default:
                return true;
        }
    }
}
