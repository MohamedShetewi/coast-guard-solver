package code.Problem;

public abstract class Operator {
    public abstract State performOperation(State state) throws CloneNotSupportedException;
    public abstract boolean isValidOperation(State state);

}

