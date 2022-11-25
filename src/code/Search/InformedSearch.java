package code.Search;

import code.Problem.Node;

import java.util.Comparator;
import java.util.PriorityQueue;

public abstract class InformedSearch extends Search{
    static class InformedSearchQueue implements SearchQueue<Node> {
        PriorityQueue<Node> priorityQueue;
        InformedSearchQueue(Comparator<Node> c) {
            priorityQueue = new PriorityQueue<>(c);
        }

        @Override
        public void enqueue(Node element) {
            priorityQueue.add(element);
        }

        @Override
        public Node dequeue() {
            return priorityQueue.poll();
        }

        @Override
        public boolean isEmpty() {
            return priorityQueue.isEmpty();
        }

        @Override
        public int size() {
            return priorityQueue.size();
        }
    }

    Heuristic[] heuristics;

//    public abstract int heuristic1(State s);
//    public abstract int heuristic2(State s);
}
