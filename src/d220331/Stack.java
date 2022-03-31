package d220331;

import java.util.ArrayList;

public class Stack {
    public int top = 0;
    public ArrayList data = new ArrayList();

    public void push(Object obj) {
        data.add(obj);
    }

    public Object pop() {
        Object tmp = data.get(top);
        data.remove(top);
        return tmp;
    }

    public Object peek() {
        Object tmp = data.get(top);
        return tmp;
    }
}
