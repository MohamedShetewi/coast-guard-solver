package code.Problem;

public abstract class Problem {

    private State initialState;


    private Operator[] operators;

    public Problem(State initialState, Operator[] operators) {
        this.initialState = initialState;
        this.operators = operators;
    }
    public State getInitialState() {
        return initialState;
    }

    public abstract int pathCost(State state);

    public abstract boolean isGoalState(State state);

    public Operator[] getOperators() {
        return operators;
    }
}
