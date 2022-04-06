package y22.m04.d06;

public class UseQueue {
    public static void main(String[] args) {
        MyQueue q;

        System.out.println("LinearQueue");
        q = new LinearQueue();
        q.init();
        q.enqueue(1);
        q.printQueue();
        q.enqueue(2);
        q.printQueue();
        q.enqueue(3);
        q.printQueue();
        q.dequeue();
        q.printQueue();
        q.dequeue();
        q.printQueue();
        q.dequeue();
        q.printQueue();
        System.out.println("q = " + q.getQ());

        System.out.println("CircularQueue");
        q = new CircularQueue();
        q.init();
        q.enqueue(1);
        q.printQueue();
        q.enqueue(2);
        q.printQueue();
        q.enqueue(3);
        q.printQueue();
        q.dequeue();
        q.printQueue();
        q.dequeue();
        q.printQueue();
        q.dequeue();
        q.printQueue();

        q.enqueue(4);
        q.printQueue();
        q.enqueue(5);
        q.printQueue();
        q.enqueue(6);
        q.printQueue();
        q.dequeue();
        q.printQueue();
        q.dequeue();
        q.printQueue();
        q.dequeue();
        q.printQueue();
        System.out.println("q = " + q.getQ());
    }
}
