package main.Problem;

import main.Entity.CoastGuardBoat;
import main.Entity.Ship;

import java.util.ArrayList;

public abstract class Operator {
    public abstract State performOperation(State state) throws CloneNotSupportedException;
    public abstract boolean isValidOperation(State state);

}

