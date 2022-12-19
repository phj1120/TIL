package m12.d19;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class UseMinStack {
}

class MinStack {
    Node head;

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val, head);
        }
        head = new Node(val, Math.min(val, getMin()), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    class Node {
        int val;
        int min;
        Node next;

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}


class MinStackBest {
    private Node head;

    public void push(int x) {
        if (head == null)
            head = new Node(x, x, null);
        else
            head = new Node(x, Math.min(x, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

class MinStackNeetCode {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int val) {
        stack.push(val);

        int min;
        if (minStack.isEmpty()) {
            min = val;
        } else {
            min = Math.min(val, minStack.peek());
        }
        minStack.push(min);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        System.out.println(minStack);
        System.out.println(stack);
        return minStack.peek();
    }
}


class MinStackByStack {
    Stack<Integer> stack = new Stack<>();

    public MinStackByStack() {

    }

    public void push(int val) {
        stack.add(val);
    }

    public void pop() {
        stack.remove(stack.size() - 1);
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return stack.stream().min(Integer::compareTo).get();
    }
}


class MinStackByList {
    List<Integer> stack = new ArrayList<>();

    public MinStackByList() {

    }

    public void push(int val) {
        stack.add(val);
    }

    public void pop() {
        stack.remove(stack.size() - 1);
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return stack.stream().min(Integer::compareTo).get();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */