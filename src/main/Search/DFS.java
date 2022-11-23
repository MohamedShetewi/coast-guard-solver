package main.Search;

import main.Problem.Node;

import java.util.Stack;

public class DFS extends Search{
    static class DFSQueue implements SearchQueue<Node>{
        Stack<Node> stack;

        DFSQueue() {
            stack = new Stack<>();
        }

        @Override
        public void enqueue(Node element) {
            stack.push(element);
        }

        @Override
        public Node dequeue() {
            return stack.pop();
        }

        @Override
        public boolean isEmpty() {
            return stack.isEmpty();
        }

        @Override
        public int size() {
            return stack.size();
        }
    }

    public DFS() {
        searchQueue = new DFSQueue();
    }
}
