package main.Search;

import main.Problem.State;

public interface Heuristic {
    int calculate(State s);
}
