package main.Search;

import main.Problem.Node;

import java.util.LinkedList;
import java.util.Queue;

public class BFS extends Search{
    static class BFSQueue implements SearchQueue<Node> {
        Queue<Node> q;
        BFSQueue() {
            q = new LinkedList<>();
        }
        @Override
        public void enqueue(Node element) {
            q.add(element);
        }

        @Override
        public Node dequeue() {
            return q.poll();
        }

        @Override
        public boolean isEmpty() {
            return q.isEmpty();
        }

        @Override
        public int size() {
            return q.size();
        }
    }
    public BFS() {
        searchQueue = new BFSQueue();
    }
}
