package main.Search;

import main.Problem.Node;
import main.Problem.Problem;

public class IterativeDeepening extends DFS{
    @Override
    public Node search(Problem p) {
        int depth = 0;
        Node ans;
        while (true) {
            ans = super.search(p, depth);
            if (p.isGoalState(ans.getState()))
                break;
            depth++;
        }
        return ans;
    }
}
