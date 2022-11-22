package main.Problem;

import main.Entity.Ship;

public class CoastGuardProblem extends Problem {

    private CoastGuardState initialState;
    private Operator[] operators;

    public static String genGrid() {
        return (new GridGenerator()).toString();
    }

    // TODO
    public static String solver(String grid, String strategy, boolean visualize) {
        return "";
    }

    public static boolean isGoalState(CoastGuardState state) {
        if (state.getCoastGuardBoat().getCurrentCapacity() > 0)
            return false;
        for (Ship ship : state.getShipList())
            if (!ship.isWreck() || !ship.isBlackBoxDamaged())
                return false;
        return true;
    }

    // TODO
    public static int pathCost(CoastGuardState state) {
        return 0;
    }

    public CoastGuardState getInitialState() {
        return initialState;
    }
}
