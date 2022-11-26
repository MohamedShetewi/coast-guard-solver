package main.Problem;

public abstract class Problem {

    public State initialState;
    public Operator[] operators;

    public Problem(State initialState, Operator[] operators) {
        this.initialState = initialState;
        this.operators = operators;
    }

    public abstract int pathCost(State state);

    public abstract boolean isGoalState(State state);

    public Operator[] getOperators() {
        return operators;
    }
}
