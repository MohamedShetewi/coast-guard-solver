package code.Search;

import code.Entity.CoastGuardBoat;
import code.Entity.Location;
import code.Problem.*;

import java.util.*;

public abstract class Search {
    public SearchQueue<Node> searchQueue;
    private int expandedNodes;

    public Node search(Problem p) throws CloneNotSupportedException {
        State initialState = p.getInitialState();
        Node initialNode = new Node(initialState, null, null, 0, 0);
        HashSet<State> visited = new HashSet<>();
        searchQueue.enqueue(initialNode);
        visited.add(initialNode.getState());
        while (!searchQueue.isEmpty()) {
            Node node = searchQueue.dequeue();
            expandedNodes++;
            if (p.isGoalState(node.getState()))
                return node;
            for (Operator o : p.getOperators()) {
                if (o.isValidOperation(node.getState())) {
                    State newState = o.performOperation(node.getState());
                    if (visited.add(newState)) {
                        Node expandedNode = new Node(newState, node, o, node.getDepth() + 1, p.pathCost(newState));
                        searchQueue.enqueue(expandedNode);
                    }
                }
            }
        }
        return null;
    }

    public Node search(Problem p, int maxDepth) throws CloneNotSupportedException {
        State initialState = p.getInitialState();
        Node initialNode = new Node(initialState, null, null, 0, 0);
        HashSet<State> visited = new HashSet<>();
        searchQueue.enqueue(initialNode);
        visited.add(initialNode.getState());
        while (!searchQueue.isEmpty()) {
            Node node = searchQueue.dequeue();
            expandedNodes++;
            if (p.isGoalState(node.getState()))
                return node;
            if (node.getDepth() == maxDepth)
                break;
            for (Operator o : p.getOperators()) {
                if (o.isValidOperation(node.getState())) {
                    State newState = o.performOperation(node.getState());
                    if (visited.add(newState)) {
                        Node expandedNode = new Node(newState, node, o, node.getDepth() + 1, p.pathCost(newState));
                        searchQueue.enqueue(expandedNode);
                    }
                }
            }
        }
        return null;
    }

    public int getExpandedNodes() {
        return expandedNodes;
    }
}
