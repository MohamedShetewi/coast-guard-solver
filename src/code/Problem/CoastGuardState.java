package code.Problem;

import code.Entity.CoastGuardBoat;
import code.Entity.Ship;
import code.Entity.Station;

import java.util.ArrayList;
import java.util.Objects;

public class CoastGuardState implements State {

    private ArrayList<Ship> shipList;
    private ArrayList<Station> stationList;
    private CoastGuardBoat coastGuardBoat;
    private int savedPassengersCount;
    private int passengersDeathCount;
    private int damagedBoxesCount;
    private int gridWidth;
    private int gridHeight;

    public CoastGuardState(ArrayList<Ship> shipList, ArrayList<Station> stationList, CoastGuardBoat coastGuardBoat, int gridWidth, int gridHeight) {
        this.shipList = shipList;
        this.stationList = stationList;
        this.coastGuardBoat = coastGuardBoat;
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        this.savedPassengersCount = 0;
        this.passengersDeathCount = 0;
    }


    public int getSavedPassengersCount() {
        return savedPassengersCount;
    }

    public int getPassengersDeathCount() {
        return passengersDeathCount;
    }

    public void setSavedPassengersCount(int savedPassengersCount) {
        this.savedPassengersCount = savedPassengersCount;
    }

    public int getGridWidth() {
        return gridWidth;
    }

    public int getGridHeight() {
        return gridHeight;
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

    public int getDamagedBoxesCount() {
        return damagedBoxesCount;
    }

    public void updateDeathAndDamageInState(){
        ArrayList<Ship> shipList = this.getShipList();
        int deathCount = 0, damagedCount = 0;

        //updates the number of passengers on all ships after performing an action
        for (Ship ship : shipList) {
            if (!ship.isWreck()) {
                ship.setPassengersCount(ship.getPassengersCount() - 1);
                deathCount++;
            } else if (ship.isBlackBoxRetrievable())
                ship.setBlackBoxDamage(ship.getBlackBoxDamage() + 1);
            if (ship.isBlackBoxDamaged())
                damagedCount++;
        }

        //updates the count of deaths until this state
        this.passengersDeathCount += deathCount;
        this.damagedBoxesCount = damagedCount;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ArrayList<Ship> newShipList = new ArrayList<>();
        ArrayList<Station> newStationList = new ArrayList<>();
        CoastGuardBoat newCoastGuardBoat = (CoastGuardBoat) this.coastGuardBoat.clone();

        for (Ship ship : this.shipList)
            newShipList.add((Ship) ship.clone());

        for (Station station : this.stationList)
            newStationList.add((Station) station.clone());

        return new CoastGuardState(newShipList, newStationList, newCoastGuardBoat, this.savedPassengersCount, this.passengersDeathCount);
    }

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
