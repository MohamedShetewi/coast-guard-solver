package code.Problem;

import code.Entity.Ship;
import code.Search.*;

import java.util.Stack;

public class CoastGuard extends Problem {

    public CoastGuard(CoastGuardState initialState, Operator[] operators) {
        super(initialState, operators);
    }

    public static String genGrid() {
        return (new GridGenerator()).toString();
    }

    public static String solve(String grid, String strategy, boolean visualize) throws Exception {
        CoastGuardParser parser = new CoastGuardParser(grid);
        CoastGuardState initialState = parser.parse();
        Operator[] operators = new Operator[]{
                new Move(Direction.RIGHT),
                new Move(Direction.LEFT),
                new Move(Direction.UP),
                new Move(Direction.DOWN),
                new Pickup(),
                new Retrieve(),
                new Drop()
        };
        CoastGuard coastGuard = new CoastGuard(initialState, operators);
        Search search;
        switch (strategy) {
            case "BF":
                search = new BFS();
                break;
            case "DF":
                search = new DFS();
                break;
            case "ID":
                search = new IterativeDeepening();
                break;
            case "GR1":
                search = new Greedy(0);
                break;
            case "GR2":
                search = new Greedy(1);
                break;
            case "AS1":
                search = new AStar(0);
                break;
            case "AS2":
                search = new AStar(1);
                break;
            default:
                throw new Exception("Not supported strategy");
        }
        Node result = search.search(coastGuard);
        if (result == null)
            return "NO SOLUTION FOUND!";
        String ans = encodeAnswer(result, initialState.getShipList().size(), search.getExpandedNodes(), visualize);
        return ans;
    }

    private static String encodeAnswer(Node result, int noOfShips, int expandedNodes, boolean visualize) {
        Stack<Operator> plan = new Stack<>();
        Stack<String> visualization = new Stack<>();
        Node cur = result;
        while (cur.getGeneratingOperator() != null) {
            plan.push(cur.getGeneratingOperator());
            visualization.push(Visualizer.visualize(cur));
            cur = cur.getParentNode();
        }
        visualization.push(Visualizer.visualize(cur));
        StringBuilder planString = new StringBuilder();
        while (!plan.isEmpty()) {
            planString.append(plan.pop()).append(",");
        }
        if (visualize) {
            while (!visualization.isEmpty()) {
                System.out.println(visualization.pop());
            }
        }
        planString.deleteCharAt(planString.length() - 1);
        int deaths = ((CoastGuardState) result.getState()).getPassengersDeathCount();
        int retrieved = noOfShips - ((CoastGuardState) result.getState()).getDamagedBoxesCount();
        String ans = planString + ";" + deaths + ";" + retrieved + ";" + expandedNodes;
        return ans;
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

    public int pathCost(State state) {
        CoastGuardState coastGuardState = (CoastGuardState) state;
        return coastGuardState.getPassengersDeathCount() * 1000 + coastGuardState.getDamagedBoxesCount();
    }
}
