package main.Problem;

public interface Operator {
    public State performOperation(State state);
    public boolean isValidOperation(State state);
}
