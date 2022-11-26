package main.Problem;

import java.util.Objects;

public class Node {

    private State state;
    private Node parentNode;
    private Operator generatingOperator; // the operator that led to this Node;
    private int depth;
    private int pathCostFromRoot;

    public Node(State state, Node parentNode, Operator generatingOperator, int depth, int pathCostFromRoot) {
        this.state = state;
        this.parentNode = parentNode;
        this.generatingOperator = generatingOperator;
        this.depth = depth;
        this.pathCostFromRoot = pathCostFromRoot;
    }

    public State getState() {
        return state;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public Operator getGeneratingOperator() {
        return generatingOperator;
    }

    public int getDepth() {
        return depth;
    }

    public int getPathCostFromRoot() {
        return pathCostFromRoot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return depth == node.depth && pathCostFromRoot == node.pathCostFromRoot && state.equals(node.state) && parentNode.equals(node.parentNode) && generatingOperator.equals(node.generatingOperator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, parentNode, generatingOperator, depth, pathCostFromRoot);
    }
}
