package code.Problem;

import code.Entity.Ship;

public class CoastGuard extends Problem {

    public CoastGuard(CoastGuardState initialState, Operator[] operators) {
        super(initialState, operators);
    }

    public static String genGrid() {
        return (new GridGenerator()).toString();
    }

    // TODO
    public static String solve(String grid, String strategy, boolean visualize) {
        return "";
    }

    public boolean isGoalState(State state) {
        CoastGuardState coastGuardState = (CoastGuardState) state;
        if (coastGuardState.getCoastGuardBoat().getCurrentCapacity() > 0)
            return false;
        for (Ship ship : coastGuardState.getShipList())
            if (!ship.isWreck() || ship.isBlackBoxRetrievable())
                return false;
        return true;
    }

    // TODO
    public double pathCost(State state) {
        CoastGuardState coastGuardState = (CoastGuardState) state;
        return coastGuardState.getPassengersDeathCount()
                + (1.0 * coastGuardState.getDamagedBoxesCount()
                / (1.0 * (coastGuardState.getDamagedBoxesCount() + coastGuardState.getPassengersDeathCount())));
    }

    public CoastGuardState getInitialState() {
        return (CoastGuardState) initialState;
    }
}
