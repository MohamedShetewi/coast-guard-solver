package main.Problem;

import main.Entity.CoastGuardBoat;
import main.Entity.Ship;

import java.util.ArrayList;

public abstract class Operator {
    public abstract State performOperation(State state) throws CloneNotSupportedException;
    public abstract boolean isValidOperation(State state);

    public int updateShips(State state) throws CloneNotSupportedException {
        CoastGuardState newState = (CoastGuardState) state;
        CoastGuardBoat newCoastGuardBoat = newState.getCoastGuardBoat();
        ArrayList<Ship> shipList = newState.getShipList();
        int deathCount = 0;

        for (Ship ship : shipList) {
            if (!ship.isWreck()) {
                ship.setPassengersCount(ship.getPassengersCount() - 1);
                deathCount++;
            } else if (ship.isBlackBoxRetrievable())
                ship.setBlackBoxDamage(ship.getBlackBoxDamage() + 1);
        }
        return deathCount;
    }

}

