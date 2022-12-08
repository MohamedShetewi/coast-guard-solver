package code.Problem;

import code.Entity.CoastGuardBoat;
import code.Entity.Location;
import code.Entity.Ship;
import code.Entity.Station;

import java.util.ArrayList;

public class CoastGuardParser {

    private String problemEncoding;

    public CoastGuardParser(String problemEncoding) {
        this.problemEncoding = problemEncoding;
    }

    public CoastGuardState parse() throws Exception {
        String[] tokens = problemEncoding.split(";");

        if (tokens.length != 5)
            throw new Exception("Invalid encoding format");

        int[] gridDimensions = parseDimensions(tokens[0]);
        int maxPassengerCount = parsePassengerCapacity(tokens[1]);
        Location boatInitialPosition = parseBoatInitialPos(tokens[2]);
        CoastGuardBoat boat = new CoastGuardBoat(boatInitialPosition, maxPassengerCount);
        ArrayList<Station> stations = parseStations(tokens[3]);
        ArrayList<Ship> ships = parseShips(tokens[4]);

        return new CoastGuardState(ships, stations, boat,
                0, 0, 0, gridDimensions[0], gridDimensions[1]);
    }

    private int[] parseDimensions(String dimensionsEncoding) {
        String[] dimensionsTokens = dimensionsEncoding.split(",");
        int width = Integer.parseInt(dimensionsTokens[0]);
        int height = Integer.parseInt(dimensionsTokens[1]);
        return new int[]{width, height};
    }

    private int parsePassengerCapacity(String maxPassengersEncoding) {
        return Integer.parseInt(maxPassengersEncoding);
    }

    private Location parseBoatInitialPos(String boatInitialPosEncoding) {
        String[] positionTokens = boatInitialPosEncoding.split(",");
        int i = Integer.parseInt(positionTokens[0]);
        int j = Integer.parseInt(positionTokens[1]);
        return new Location(i, j);
    }

    /**
     * @param stationsPosEncoding -> should be in the form (xi, yi) representing the location of station i
     * @return List of stations
     * @throws Exception if the length is not even
     */
    private ArrayList<Station> parseStations(String stationsPosEncoding) throws Exception {
        String[] stationsTokens = stationsPosEncoding.split(",");
        if (stationsTokens.length % 2 != 0) throw new Exception("Invalid stations format");

        ArrayList<Station> stations = new ArrayList<>();
        for (int tokens = 0; tokens < stationsTokens.length; tokens += 2) {
            Location stationLocation = new Location(Integer.parseInt(stationsTokens[tokens]), Integer.parseInt(stationsTokens[tokens + 1]));
            stations.add(new Station(stationLocation));
        }
        return stations;
    }

    /**
     * @param shipsEncoding -> should be in the form (xi, yi, passengerCount)
     * @return list of ships
     * @throws Exception if the count is not divisible by 3
     */
    private ArrayList<Ship> parseShips(String shipsEncoding) throws Exception {
        String[] shipsTokens = shipsEncoding.split(",");
        if (shipsTokens.length % 3 != 0) throw new Exception("Invalid ships format");

        ArrayList<Ship> ships = new ArrayList<>();
        for (int tokens = 0; tokens < shipsTokens.length; tokens += 3) {
            Location shipLocation = new Location(Integer.parseInt(shipsTokens[tokens]), Integer.parseInt(shipsTokens[tokens + 1]));
            ships.add(new Ship(shipLocation, Integer.parseInt(shipsTokens[tokens + 2])));
        }
        return ships;
    }
}
