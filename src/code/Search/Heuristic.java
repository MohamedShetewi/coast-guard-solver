package code.Search;

import code.Problem.State;

public interface Heuristic {
    int calculate(State s);
}
