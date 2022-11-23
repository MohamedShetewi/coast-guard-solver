package main.Problem;

import main.Entity.CoastGuardBoat;
import main.Entity.Ship;

import java.util.ArrayList;

public class Retrieve extends Operator{
    @Override
    public State performOperation(State state) throws CloneNotSupportedException {
        CoastGuardState oldState = (CoastGuardState)state;
        CoastGuardState newState = (CoastGuardState) oldState.clone();
        CoastGuardBoat coastGuardBoat = newState.getCoastGuardBoat();
        ArrayList<Ship> shipList = newState.getShipList();

        for(Ship ship : shipList)
            if(ship.getLocation().equals(coastGuardBoat.getLocation())) {
                ship.setBlackBoxRetrieved(true);
                break;
            }

        int deathCount = updateShips(newState);
        newState.setPassengersDeathCount(newState.getPassengersDeathCount() + deathCount);

        return newState;
    }

    @Override
    public boolean isValidOperation(State state) {
        CoastGuardState oldState = (CoastGuardState)state;
        CoastGuardBoat coastGuardBoat = oldState.getCoastGuardBoat();
        ArrayList<Ship> shipList = oldState.getShipList();

        for(Ship ship : shipList)
            if(ship.getLocation().equals(coastGuardBoat.getLocation()) && ship.isBlackBoxRetrievable())
                return true;

        return false;
    }
}
