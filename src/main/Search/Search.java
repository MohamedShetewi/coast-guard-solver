package main.Search;

import main.Problem.Node;
import main.Problem.Problem;

public abstract class Search {
    public SearchQueue<Node> searchQueue;
    private int expandedNodes;
    public Node search(Problem p) {
        //TODO
        return null;
    }

    public Node search(Problem p, int maxDepth) {
        //TODO
        return null;
    }

    public int getExpandedNodes() {
        return expandedNodes;
    }

    public void setExpandedNodes(int expandedNodes) {
        this.expandedNodes = expandedNodes;
    }
}
