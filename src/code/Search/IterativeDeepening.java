package code.Search;

import code.Problem.Node;
import code.Problem.Problem;

public class IterativeDeepening extends DFS {
    @Override
    public Node search(Problem p) throws CloneNotSupportedException {
        int depth = 0;
        Node ans;
        while (true) {
            ans = super.search(p, depth);
            if (ans != null && p.isGoalState(ans.getState()))
                break;
            depth++;
        }
        return ans;
    }
}
