package main.Problem;

import main.Entity.CoastGuardBoat;
import main.Entity.Ship;
import main.Entity.Station;

import java.util.ArrayList;
import java.util.Objects;

public class CoastGuardState implements State {

    private ArrayList<Ship> shipList;
    private ArrayList<Station> stationList;
    private CoastGuardBoat coastGuardBoat;
    private int savedPassengersCount;
    private int passengersDeathCount;

    public CoastGuardState(ArrayList<Ship> shipList, ArrayList<Station> stationList, CoastGuardBoat coastGuardBoat) {
        this.shipList = shipList;
        this.stationList = stationList;
        this.coastGuardBoat = coastGuardBoat;
        this.savedPassengersCount = 0;
        this.passengersDeathCount = 0;
    }

    public CoastGuardState(ArrayList<Ship> shipList, ArrayList<Station> stationList, CoastGuardBoat coastGuardBoat, int savedPassengersCount, int passengersDeathCount) {
        this.shipList = shipList;
        this.stationList = stationList;
        this.coastGuardBoat = coastGuardBoat;
        this.savedPassengersCount = savedPassengersCount;
        this.passengersDeathCount = passengersDeathCount;
    }

    public ArrayList<Ship> getShipList() {
        return shipList;
    }

    public ArrayList<Station> getStationList() {
        return stationList;
    }

    public CoastGuardBoat getCoastGuardBoat() {
        return coastGuardBoat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoastGuardState that = (CoastGuardState) o;
        return savedPassengersCount == that.savedPassengersCount && passengersDeathCount == that.passengersDeathCount && shipList.equals(that.shipList) && stationList.equals(that.stationList) && coastGuardBoat.equals(that.coastGuardBoat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shipList, stationList, coastGuardBoat, savedPassengersCount, passengersDeathCount);
    }
}
