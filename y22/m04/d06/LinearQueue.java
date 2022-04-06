package y22.m04.d06;

import java.util.ArrayList;

public class LinearQueue implements MyQueue {
    int MAX_QUEUE_SIZE;
    ArrayList<Integer> q;
    int front;
    int rear;

    @Override
    public ArrayList<Integer> getQ(){
        return q;
    }

    @Override
    public void init() {
        MAX_QUEUE_SIZE = 5;
        front = -1;
        rear = -1;
        q = new ArrayList<>();
        for (int i = 0; i < MAX_QUEUE_SIZE; i++) {
            q.add(0);
        }
    }

    @Override
    public boolean isEmpty() {
        if(front == rear) {
            return true;
        }
        else return false;
    }

    @Override
    public boolean isFull() {
        if(rear == MAX_QUEUE_SIZE -1) {
            return true;
        }
        else return false;
    }

    @Override
    public void enqueue(int e) {
        if (isFull()) {
            System.out.println("Queue is Full");
            new Exception();
        }
        q.set(++rear, e);
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            new Exception();
        }
        return q.get(++front);
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            new Exception();
        }
        return q.get(front);
    }

    @Override
    public void printQueue() {
        for (int i = 0; i < MAX_QUEUE_SIZE; i++) {
            if (i <= front || i > rear)
                System.out.printf("   | ");
            else
                System.out.printf(" %d | ", q.get(i));
        }
        System.out.printf("\n");
    }
}
