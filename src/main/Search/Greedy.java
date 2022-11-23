package main.Search;

import main.Problem.State;

public class Greedy extends InformedSearch {

    public Greedy(int whichHeuristic) {
        searchQueue = new InformedSearchQueue((o1, o2) ->
                whichHeuristic == 1 ? (heuristic1(o1.getState()) - heuristic1(o2.getState()))
                        : (heuristic2(o1.getState()) - heuristic2(o2.getState())));
    }

    public int heuristic1(State s) {
        //TODO implement the actual heuristic
        return 0;
    }

    public int heuristic2(State s) {
        //TODO implement the actual heuristic
        return 0;
    }
}
