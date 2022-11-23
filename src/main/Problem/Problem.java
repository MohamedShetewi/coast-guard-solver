package main.Problem;

public abstract class Problem {

    public State initialState;
    public Operator[] operators;

    public Problem(State initialState, Operator[] operators) {
        this.initialState = initialState;
        this.operators = operators;
    }

    public Operator[] getOperators() {
        return operators;
    }
}
