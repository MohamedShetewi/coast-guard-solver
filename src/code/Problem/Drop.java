package code.Problem;

import code.Entity.CoastGuardBoat;
import code.Entity.Station;

import java.util.ArrayList;

public class Drop extends Operator {
    @Override
    public State performOperation(State state) throws CloneNotSupportedException {
        CoastGuardState oldState = (CoastGuardState) state;
        CoastGuardState newState = (CoastGuardState) oldState.clone();
        CoastGuardBoat coastGuardBoat = newState.getCoastGuardBoat();

        ArrayList<Station> stationList = newState.getStationList();
        for (Station station : stationList) {
            if (station.getLocation().equals(coastGuardBoat.getLocation())) {
                station.setPassengersCount(station.getPassengersCount() + coastGuardBoat.getCurrentCapacity());
                break;
            }
        }

        coastGuardBoat.setCurrentCapacity(0);
        newState.updateDeathAndDamageInState();

        return newState;
    }

    @Override
    public boolean isValidOperation(State state) {
        CoastGuardState oldState = (CoastGuardState) state;
        CoastGuardBoat coastGuardBoat = oldState.getCoastGuardBoat();

        ArrayList<Station> stationList = oldState.getStationList();

        for (Station station : stationList)
            if (station.getLocation().equals(coastGuardBoat.getLocation())
                    && coastGuardBoat.getCurrentCapacity() > 0)
                return true;

        return false;
    }

    @Override
    public String toString() {
        return "drop";
    }
}
