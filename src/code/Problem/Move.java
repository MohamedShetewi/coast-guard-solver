package code.Problem;

import code.Entity.CoastGuardBoat;
import code.Entity.Location;

public class Move extends Operator {
    Direction direction;

    public Move(Direction direction) {
        this.direction = direction;
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

        newState.updateDeathInState();

        return newState;
    }

    @Override
    public boolean isValidOperation(State state) {
        CoastGuardState oldState = (CoastGuardState) state;
        CoastGuardBoat coastGuardBoat = oldState.getCoastGuardBoat();

        int gridHeight = oldState.getGridHeight();
        int gridWidth = oldState.getGridWidth();

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
