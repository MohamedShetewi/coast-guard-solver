package main.Problem;

import main.Entity.Ship;

public class CoastGuardProblem extends Problem {

    public CoastGuardProblem(CoastGuardState initialState, Operator[] operators) {
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
    public int pathCost(State state) {
        return 0;
    }

    public CoastGuardState getInitialState() {
        return (CoastGuardState) initialState;
    }
}
