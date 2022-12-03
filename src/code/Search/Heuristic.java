package code.Search;

import code.Problem.State;

public interface Heuristic {
    double calculate(State s);
}
