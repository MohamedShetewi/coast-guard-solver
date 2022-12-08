package code.Problem;

import code.Entity.CoastGuardBoat;
import code.Entity.Location;
import code.Entity.Ship;
import code.Entity.Station;

import java.util.ArrayList;

public class Visualizer {

    private static final int cellWidth = 8;

    /**
     * @param node
     * @return the explicit grid with the positions of boats (<>), ships (SHi) and stations (STi)
     * the info of each element is printed.
     * <p>
     * output example:
     * <p>
     * ----------------------------------------------
     * |   ST0  |   <>   |   SH8  |   SH4  |  SH10  |
     * ----------------------------------------------
     * |   SH5  |   SH1  |   SH6  |        |   SH9  |
     * ----------------------------------------------
     * |   SH7  |   SH3  |   SH2  |  SH11  |   SH0  |
     * ----------------------------------------------
     * <p>
     * Action           --> DROP
     * Coast Guard Boat --> Current Capacity: 0
     * SH0 --> Passenger Count: 5, Box Damage: 1
     * SH1 --> Passenger Count: 73, Box Damage: 1
     * ....
     */
    public static String visualize(Node node) {
        int width = ((CoastGuardState) node.getState()).getGridWidth();
        int height = ((CoastGuardState) node.getState()).getGridHeight();

        StringBuilder grid = new StringBuilder();

        grid.append(getRowSeparator(width)).append("\n");
        for (int i = 0; i < height; i++) {
            grid.append("|");
            for (int j = 0; j < width; j++) {
                Location location = new Location(i, j);
                grid.append(getCellInIndex(location, node));
            }
            grid.append("\n").append(getRowSeparator(width)).append("\n");
        }
        return grid.append("\n").append(getStateInfo(node)).toString();
    }

    private static String getStateInfo(Node node) {
        ArrayList<Ship> ships = ((CoastGuardState) node.getState()).getShipList();
        ArrayList<Station> stations = ((CoastGuardState) node.getState()).getStationList();
        CoastGuardBoat coastGuardBoat = ((CoastGuardState) node.getState()).getCoastGuardBoat();

        StringBuilder stateInfo = new StringBuilder();
        if (node.getGeneratingOperator() != null)
            stateInfo.append("Action           --> ").append(node.getGeneratingOperator().toString()).append("\n");
        stateInfo.append("Coast Guard Boat --> ").append("Current Capacity: ")
                .append(coastGuardBoat.getCurrentCapacity()).append('/')
                .append(coastGuardBoat.getMaxPassengersCapacity()).append("\n");

        for (int i = 0; i < ships.size(); i++) {
            Ship ship = ships.get(i);
            stateInfo.append("SH").append(i).append(" --> ")
                    .append("Passenger Count: ").append(ship.getPassengersCount())
                    .append(", Box Damage: ").append(ship.getBlackBoxDamage()).append("\n");
        }

        for (int i = 0; i < stations.size(); i++) {
            Station station = stations.get(i);
            stateInfo.append("ST").append(i).append(" --> ")
                    .append("Passengers: ").append(station.getPassengersCount()).append("\n");
        }
        return stateInfo.toString();
    }

    private static String getRowSeparator(int width) {
        return repeatString("-", width * (cellWidth + 1) + 1);
    }

    private static String getCellInIndex(Location location, Node node) {
        ArrayList<Ship> ships = ((CoastGuardState) node.getState()).getShipList();
        ArrayList<Station> stations = ((CoastGuardState) node.getState()).getStationList();
        CoastGuardBoat coastGuardBoat = ((CoastGuardState) node.getState()).getCoastGuardBoat();

        String cellContent = "";
        if (coastGuardBoat.getLocation().equals(location)) {
            cellContent += "<>";
        }

        for (int i = 0; i < ships.size(); i++) {
            Ship ship = ships.get(i);
            if (ship.getLocation().equals(location)) {
                cellContent = cellContent.isEmpty() ? "SH" + i : "<SH" + i + ">";
            }
        }

        for (int i = 0; i < stations.size(); i++) {
            Station station = stations.get(i);
            if (station.getLocation().equals(location)) {
                cellContent = cellContent.isEmpty() ? "ST" + i : "<ST" + i + ">";
            }
        }
        return cellFormatter(cellContent);
    }

    private static String cellFormatter(String cellContent) {
        int spaceCount = cellWidth - cellContent.length();
        int prefixCount = spaceCount - spaceCount / 2;
        int suffixCount = spaceCount - prefixCount;

        String cellFormatted = repeatString(" ", prefixCount);
        cellFormatted += cellContent;
        cellFormatted += repeatString(" ", suffixCount);

        return cellFormatted + "|";
    }

    private static String repeatString(String s, int n) {
        StringBuilder res = new StringBuilder();
        while (n-- > 0)
            res.append(s);
        return res.toString();
    }
}
