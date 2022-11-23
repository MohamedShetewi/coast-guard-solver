package main.Search;

import main.Problem.State;

public class AStar extends InformedSearch {

    public AStar(int whichHeuristic) {
        searchQueue = new InformedSearchQueue(((o1, o2) -> whichHeuristic == 1 ?
                ((heuristic1(o1.getState()) + o1.getPathCostFromRoot()) - (heuristic1(o2.getState()) + o2.getPathCostFromRoot()))
                : ((heuristic2(o1.getState()) + o1.getPathCostFromRoot()) - (heuristic2(o2.getState()) + o2.getPathCostFromRoot()))));
    }

    @Override
    public int heuristic1(State s) {
        //TODO
        return 0;
    }

    @Override
    public int heuristic2(State s) {
        //TODO
        return 0;
    }
}
