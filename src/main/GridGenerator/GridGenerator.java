package main.GridGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GridGenerator {
    private int gridWidth, gridHeight;
    private int boatCapacity;
    private Coordinate boatInitPos;

    private List<Coordinate> stationsPositions, shipsPositions;
    private List<Integer> passengerCountInShips;

    public GridGenerator() {
        this.gridWidth = getRandomInt(5, 15);
        this.gridHeight = getRandomInt(5, 15);
        this.boatCapacity = getRandomInt(30, 100);

        int boatX = getRandomInt(0, this.gridHeight);
        int boatY = getRandomInt(0, this.gridWidth);
        this.boatInitPos = new Coordinate(boatX, boatY);

        shipsPositions = new ArrayList<>();
        stationsPositions = new ArrayList<>();
        passengerCountInShips = new ArrayList<>();

        this.generateShips();
        this.generateStations();
    }


    private void generateShips() {
        int maxShipsCount = this.gridWidth * this.gridHeight - 2; // we minus 2 because we want 1 boat and min 1 station
        int shipsCount = getRandomInt(1, maxShipsCount);

        while (shipsCount > 0) {
            Coordinate newShipPos = new Coordinate(getRandomInt(0, this.gridHeight), getRandomInt(0, this.gridWidth));
            if (isPositionTaken(newShipPos))
                continue;
            this.shipsPositions.add(newShipPos);
            this.passengerCountInShips.add(getRandomInt(1, 100));
            shipsCount--;
        }
    }

    private void generateStations() {

        int maxStationsCount = this.gridHeight * this.gridWidth - (this.shipsPositions.size() + 1); // no of ships +  1 boat
        int stationsCount = getRandomInt(1, maxStationsCount);

        while (stationsCount > 0) {
            Coordinate newStationPos = new Coordinate(getRandomInt(0, this.gridHeight), getRandomInt(0, this.gridWidth));

            if (isPositionTaken(newStationPos))
                continue;
            this.stationsPositions.add(newStationPos);
            stationsCount--;
        }
    }


    private boolean isPositionTaken(Coordinate newPosition) {
        if (newPosition.equals(boatInitPos))
            return true;
        for (Coordinate shipPosition : shipsPositions)
            if (newPosition.equals(shipPosition))
                return true;
        for (Coordinate stationPosition : stationsPositions)
            if (newPosition.equals(stationPosition))
                return true;
        return false;
    }

    private int getRandomInt(int min, int max) {
        return (new Random()).nextInt(max - min + 1) + min;
    }

    public String toString() {
        StringBuilder finalString = new StringBuilder();

        finalString.append(gridWidth).append(",").append(gridHeight).append(";");
        finalString.append(boatCapacity).append(";");
        finalString.append(boatInitPos).append(";");

        boolean isFirst = true;
        for (Coordinate station : stationsPositions) {
            if (isFirst) {
                isFirst = false;
            } else {
                finalString.append(",");
            }
            finalString.append(station.toString());
        }

        finalString.append(";");

        isFirst = true;
        for (int i = 0; i < shipsPositions.size(); i++) {
            if (isFirst) {
                isFirst = false;
            } else {
                finalString.append(",");
            }
            finalString.append(shipsPositions.get(i)).append(",").append(passengerCountInShips.get(i));
        }
        finalString.append(";");
        return finalString.toString();
    }

    private void printState() {
        System.out.println(gridWidth + " " + gridHeight);
        System.out.println(boatInitPos);
        System.out.println(shipsPositions.size());
        System.out.println(stationsPositions.size());
    }
}
