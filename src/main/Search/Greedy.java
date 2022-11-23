package main.Search;

public class Greedy extends InformedSearch {

    public Greedy(int whichHeuristic) {
        searchQueue = new InformedSearchQueue((o1, o2) ->
                (heuristics[whichHeuristic].calculate(o1.getState()) - heuristics[whichHeuristic].calculate(o2.getState())));
    }

}
