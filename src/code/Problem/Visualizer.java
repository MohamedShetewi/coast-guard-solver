package code.Problem;

import code.Entity.CoastGuardBoat;
import code.Entity.Location;
import code.Entity.Ship;
import code.Entity.Station;

import java.util.ArrayList;

public class Visualizer {

    private final int cellWidth = 8;

    /**
     *
     * @param node
     * @return the explicit grid with the positions of boats (<>), ships (SHi) and stations (STi)
     * the info of each element is printed.
     *
     * output example:
     *
     * ----------------------------------------------
     * |   ST0  |   <>   |   SH8  |   SH4  |  SH10  |
     * ----------------------------------------------
     * |   SH5  |   SH1  |   SH6  |        |   SH9  |
     * ----------------------------------------------
     * |   SH7  |   SH3  |   SH2  |  SH11  |   SH0  |
     * ----------------------------------------------
     *
     * Action           --> DROP
     * Coast Guard Boat --> Current Capacity: 0
     * SH0 --> Passenger Count: 5, Box Damage: 1
     * SH1 --> Passenger Count: 73, Box Damage: 1
     * ....
     */
    public String visualize(Node node) {
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

    private String getStateInfo(Node node) {
        ArrayList<Ship> ships = ((CoastGuardState) node.getState()).getShipList();
        ArrayList<Station> stations = ((CoastGuardState) node.getState()).getStationList();
        CoastGuardBoat coastGuardBoat = ((CoastGuardState) node.getState()).getCoastGuardBoat();

        StringBuilder stateInfo = new StringBuilder();
        if (node.getGeneratingOperator() != null)
            stateInfo.append("Action           --> ").append(node.getGeneratingOperator().toString()).append("\n");
        stateInfo.append("Coast Guard Boat --> ").append("Current Capacity: ").append(coastGuardBoat.getCurrentCapacity()).append("\n");

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

    private String getRowSeparator(int width) {
        return repeatString("-", width * (cellWidth + 1) + 1);
    }

    private String getCellInIndex(Location location, Node node) {
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
                cellContent += cellContent.isEmpty() ? "" : "&";
                cellContent += "SH" + i;
                return cellFormatter(cellContent);
            }
        }

        for (int i = 0; i < stations.size(); i++) {
            Station station = stations.get(i);
            if (station.getLocation().equals(location)) {
                cellContent += cellContent.isEmpty() ? "" : "&";
                cellContent += "ST" + i;
                cellFormatter(cellContent);
            }
        }
        return cellFormatter(cellContent);
    }

    private String cellFormatter(String cellContent) {
        int spaceCount = cellWidth - cellContent.length();
        int prefixCount = spaceCount - spaceCount / 2;
        int suffixCount = spaceCount - prefixCount;

        String cellFormatted = repeatString(" ", prefixCount);
        cellFormatted += cellContent;
        cellFormatted += repeatString(" ", suffixCount);

        return cellFormatted + "|";
    }

    private String repeatString(String s, int n) {
        StringBuilder res = new StringBuilder();
        while (n-- > 0)
            res.append(s);
        return res.toString();
    }
}
