package main.Search;

public interface SearchQueue<T> {
    void enqueue(T element);
    T dequeue();
    boolean isEmpty();
    int size();
}
