package main.Problem;

public class Node {

    private State state;
    private Node parentNode;
    private Operator operatorFromParent; // TODO Can you think of a better naming?
    private int depth;
    private int pathCostFromRoot;

    public Node(State state, Node parentNode, Operator operatorFromParent, int depth, int pathCostFromRoot) {
        this.state = state;
        this.parentNode = parentNode;
        this.operatorFromParent = operatorFromParent;
        this.depth = depth;
        this.pathCostFromRoot = pathCostFromRoot;
    }

    public State getState() {
        return state;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public Operator getOperatorFromParent() {
        return operatorFromParent;
    }

    public int getDepth() {
        return depth;
    }

    public int getPathCostFromRoot() {
        return pathCostFromRoot;
    }
}
