package y22.m04.d06;

import java.util.ArrayList;

public class CircularQueue implements MyQueue {
    int MAX_QUEUE_SIZE;
    ArrayList<Integer> q;
    int front;
    int rear;

    @Override
    public ArrayList<Integer> getQ() {
        return q;
    }

    @Override
    public void init() {
        MAX_QUEUE_SIZE = 5;
        front = 0;
        rear = 0;
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
        if (rear % MAX_QUEUE_SIZE == (rear + 1) % MAX_QUEUE_SIZE) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void enqueue(int e) {
        if (isFull()) {
            System.out.println("Queue is Full");
            new Exception();
        }
        q.set((++rear) % MAX_QUEUE_SIZE, e);
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            new Exception();
        }
        return q.get((++front)%MAX_QUEUE_SIZE);
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            new Exception();
        }
        return q.get(front%MAX_QUEUE_SIZE);
    }

    @Override
    public void printQueue() {
        System.out.printf("QUEUE(front=%d rear=%d) = ", front, rear);
        if (!isEmpty()) {
            int i = front;
            do {
                i = (i + 1) % (MAX_QUEUE_SIZE);
                System.out.printf("%d | ", q.get(i));
                if (i == rear) break;
            } while (i != front);
        }
        System.out.println();
    }
}
