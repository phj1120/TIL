package y22.m05.d02;

public class Test{
    public static void main(String[] args) {
        Connection conn1 = Connection.get();
        conn1.count();
        Connection conn2 = Connection.get();
        conn2.count();
        System.out.println("conn1.getCount() = " + conn1.getCount());
    }
}

class Connection {
    private static Connection _inst = null;
    private int count = 0;

    public static Connection get() {
        System.out.println("_inst = " + _inst);
        if (_inst == null) {
            _inst = new Connection();
            return _inst;
        }
        return _inst;
    }
    public void count(){
        count++;
    }

    public int getCount() {
        return count;
    }
}
