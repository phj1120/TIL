package y22.m04.d06;

import java.util.ArrayList;

public interface MyQueue {
    ArrayList<Integer> getQ();

    void init();

    boolean isEmpty();

    boolean isFull();

    void enqueue(int e);

    int dequeue();

    int peek();

    void printQueue();
}
