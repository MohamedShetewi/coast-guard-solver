package code.Search;

import code.Entity.Location;
import code.Entity.Ship;
import code.Problem.CoastGuardState;
import code.Problem.State;

public class Heuristic2 implements Heuristic {
    @Override
    public int calculate(State s) {
        int minDistance = Integer.MAX_VALUE;
        Location guardLocation = ((CoastGuardState) s).getCoastGuardBoat().getLocation();
        for (Ship ship : ((CoastGuardState) s).getShipList()) {
            if (!ship.isWreck()) {
                int distance = Math.abs(ship.getLocation().getI() - guardLocation.getI())
                        + Math.abs(ship.getLocation().getJ() - guardLocation.getJ());
                minDistance = Math.min(minDistance, distance);
            }
        }
        int minPassengers = Integer.MAX_VALUE;
        for (Ship ship : ((CoastGuardState) s).getShipList()) {
            if (!ship.isWreck()) {
                minPassengers = Math.min(minPassengers, ship.getPassengersCount());
            }
        }
        int estimatedDeaths = 0;
        for (Ship ship : ((CoastGuardState) s).getShipList()) {
            if (!ship.isWreck()) {
                estimatedDeaths += Math.min(ship.getPassengersCount(), Math.max(minPassengers, minDistance));
            }
        }
        int toBeDamagedBoxes = 0;
        for (Ship ship : ((CoastGuardState) s).getShipList()) {
            int distance = Math.abs(ship.getLocation().getI() - guardLocation.getI())
                    + Math.abs(ship.getLocation().getJ() - guardLocation.getJ());
            if (ship.isBlackBoxRetrievable()) {
                if (distance >= 20 - ship.getBlackBoxDamage())
                    toBeDamagedBoxes++;
            } else if (!ship.isWreck()) {
                if (distance >= 20 + ship.getPassengersCount())
                    toBeDamagedBoxes++;
            }
        }
        return 1000 * estimatedDeaths + toBeDamagedBoxes;
    }
}
