package code.Search;

public class AStar extends InformedSearch {

    public AStar(int whichHeuristic) {
        searchQueue = new InformedSearchQueue(((o1, o2) ->
                ((heuristics[whichHeuristic].calculate(o1.getState()) + o1.getPathCostFromRoot())
                        - (heuristics[whichHeuristic].calculate(o2.getState()) + o2.getPathCostFromRoot()))));
    }

}
