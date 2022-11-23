package main.Problem;

import main.Entity.CoastGuardBoat;
import main.Entity.Location;
import main.Entity.Ship;
import main.Entity.Station;

import java.util.ArrayList;

public class Pickup extends Operator {
    @Override
    public State performOperation(State state) throws CloneNotSupportedException {
        CoastGuardState oldState = (CoastGuardState) state;
        CoastGuardState newState = (CoastGuardState) oldState.clone();
        CoastGuardBoat newCoastGuardBoat = newState.getCoastGuardBoat();
        ArrayList<Ship> shipList = newState.getShipList();

        for (Ship ship : shipList) {
            if (ship.getLocation().equals(newCoastGuardBoat.getLocation())) {
                int boatCurrentCapacity = newCoastGuardBoat.getMaxPassengersCapacity() - newCoastGuardBoat.getCurrentCapacity();
                int currentPassengerCount = ship.getPassengersCount();
                int mostPossibleCount = Math.min(boatCurrentCapacity, currentPassengerCount);
                ship.setPassengersCount(ship.getPassengersCount() - mostPossibleCount);
                newCoastGuardBoat.setCurrentCapacity(newCoastGuardBoat.getCurrentCapacity() + mostPossibleCount);
                newState.setSavedPassengersCount(newState.getSavedPassengersCount() + mostPossibleCount);
                int deathCount = updateShips(newState);
                newState.setPassengersDeathCount(newState.getPassengersDeathCount() + deathCount);
                break;
            }
        }
        return newState;
    }

    @Override
    public boolean isValidOperation(State state) {
        CoastGuardState oldState = (CoastGuardState) state;
        CoastGuardBoat coastGuardBoat = oldState.getCoastGuardBoat();

        if (coastGuardBoat.getCurrentCapacity() == 0)
            return false;

        ArrayList<Ship> shipList = oldState.getShipList();

        for (Ship ship : shipList)
            if (ship.getLocation().equals(coastGuardBoat.getLocation()) && !ship.isWreck())
                return true;

        return false;
    }
}
